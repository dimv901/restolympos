/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Vendedores;
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
import mask.VendedorMask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import request.UpdateVendedorRequest;
import request.VendedorRequest;
import response.BasicResponse;
import response.VendedorResponse;

/**
 *
 * @author Diego
 */
@Stateless
@Path("entities.vendedores")
public class VendedoresFacadeREST extends AbstractFacade<Vendedores> {

    @PersistenceContext(unitName = "py.com.twisted_RestOlympos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(VendedoresFacadeREST.class);

    public VendedoresFacadeREST() {
        super(Vendedores.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Vendedores entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Vendedores entity) {
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
    public Vendedores find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vendedores> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vendedores> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("getDatosVendedor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getDatosVendedor(VendedorRequest vendedorRequest) {
        logger.debug("Parametros Recibidos =>", vendedorRequest.toString());

        VendedorResponse vendedorResponse = new VendedorResponse();
        Vendedores vd = null;
        Query q = em.createNamedQuery("Vendedores.findByCedula");
        q.setParameter("cedula", vendedorRequest.getUsuario());

        try {
            vd = (Vendedores) q.getSingleResult();
        } catch (Exception e) {
            logger.error("Error", e.getMessage());
        }

        if (vd == null) {
            logger.error("Error", "No se encontro el vendedor");
            vendedorResponse.setStatus(-100);
            vendedorResponse.setMessage("No se encontro el vendedor");
            return Response.ok(vendedorResponse).build();
        }

        if (!vd.getAndroid()) {
            logger.error("Error", "El vendedor no esta habilitado para operar desde Android");
            vendedorResponse.setStatus(-100);
            vendedorResponse.setMessage("El vendedor no esta habilitado para operar desde Android");
            return Response.ok(vendedorResponse).build();
        }

        VendedorMask vendedorMask = new VendedorMask();
        vendedorMask.setId(vd.getId());
        vendedorMask.setActivo(vd.getActivo());
        vendedorMask.setAndroid(vd.getAndroid());
        vendedorMask.setApellido(vd.getApellido());
        vendedorMask.setCedula(vd.getCedula());
        vendedorMask.setIdCircuito(vd.getIdCircuito().getId());
        vendedorMask.setNombre(vd.getNombre());
        vendedorMask.setTelefonoContacto(vd.getTelefonoContacto());

        vendedorResponse.setStatus(100);
        vendedorResponse.setMessage("Sincronizacion exitosa");
        vendedorResponse.setItem(vendedorMask);
        return Response.ok(vendedorResponse).build();
    }

}
