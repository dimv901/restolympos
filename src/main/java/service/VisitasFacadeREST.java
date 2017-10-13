/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Clientes;
import entities.MotivosNoCompra;
import entities.Visitas;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import response.BasicResponse;
import request.VisitRequest;

/**
 *
 * @author Diego
 */
@Stateless
@Path("entities.visitas")
public class VisitasFacadeREST extends AbstractFacade<Visitas> {

    private static final Logger logger = LoggerFactory.getLogger(VisitasFacadeREST.class);
    @PersistenceContext(unitName = "py.com.twisted_RestOlympos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public VisitasFacadeREST() {
        super(Visitas.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Visitas entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Visitas entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Visitas find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Visitas> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Visitas> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @POST
    @Path("registrarVisita")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registraVisita(VisitRequest visitRequest) {
        BasicResponse basicResponse = new BasicResponse();

        if (visitRequest == null) {
            logger.error("Error", "Faltan parametros");
            basicResponse.setStatus(-100);
            basicResponse.setMessage("Faltan parametros");
            return Response.ok(basicResponse).build();
        }
        Visitas v = new Visitas();
        MotivosNoCompra noCompra = null;
        boolean saved = false;
        Clientes clients = null;

        Query qClients = em.createNamedQuery("Clientes.findById");
        qClients.setParameter("id", visitRequest.getIdCliente());

        Query qNoCompra = em.createNamedQuery("MotivosNoCompra.findById");
        qNoCompra.setParameter("id", visitRequest.getIdMotivo());

        try {
            clients = (Clientes) qClients.getSingleResult();
            noCompra = (MotivosNoCompra) qNoCompra.getSingleResult();
            if (clients == null) {
                logger.error("Error", "No se encontro el cliente");
                basicResponse.setStatus(-100);
                basicResponse.setMessage("No se encontro el cliente");
                return Response.ok(basicResponse).build();
            }
            if (noCompra == null) {
                logger.error("Error", "No se encontro el motivo de no compra");
                basicResponse.setStatus(-100);
                basicResponse.setMessage("No se encontro el motivo de no compra");
                return Response.ok(basicResponse).build();
            }

            if (clients != null && noCompra != null) {
                v.setId(noCompra.getId());
                v.setIdCliente(clients);
                v.setIdMotivo(noCompra);
                v.setFechaCreacion(new Date());
                v.setFechaActualizacion(new Date());
                v.setLatitud(visitRequest.getLatitud());
                v.setLongitud(visitRequest.getLongitud());
                em.persist(v);
                saved = true;
            } else {
                logger.error("Error", "Error al construir la respuesta");
                basicResponse.setStatus(-100);
                basicResponse.setMessage("Error al construir la respuesta");
                return Response.ok(basicResponse).build();
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error", "Error");
        }

        if (!saved) {
            basicResponse.setStatus(-100);
            basicResponse.setMessage("Error");
            return Response.ok(basicResponse).build();
        }
        StringBuilder succesMessage = new StringBuilder();
        succesMessage.append("CLIENTE ")
                .append(clients.getNombreNegocio())
                .append(" ")
                .append("MARCADO COMO")
                .append(" ")
                .append(noCompra.getDescripcion());
        basicResponse.setStatus(100);
        basicResponse.setMessage("Operacion exitosa, cliente asignado como NO COMPRA");
        return Response.ok(basicResponse).build();
    }

}
