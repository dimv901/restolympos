/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Circuitos;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
import mask.CircuitoMask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import request.VendedorRequest;
import response.CircuitosResponse;

/**
 *
 * @author Diego
 */
@Stateless
@Path("entities.circuitos")
public class CircuitosFacadeREST extends AbstractFacade<Circuitos> {
 
    private static final Logger logger = LoggerFactory.getLogger(CircuitosFacadeREST.class);

    @PersistenceContext(unitName = "py.com.twisted_RestOlympos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public CircuitosFacadeREST() {
        super(Circuitos.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Circuitos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Circuitos entity) {
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
    public Circuitos find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Circuitos> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Circuitos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("getCircuitos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCircuitos(VendedorRequest vendedorRequest) {
        logger.debug("Parametros Recibidos =>", vendedorRequest.toString());
        CircuitosResponse circuitosResponse = new CircuitosResponse();
        List<Circuitos> circuitosList = new ArrayList();

        circuitosList = super.findAll();
        if (circuitosList.isEmpty()) {
            logger.error("Error", "No se puede obtener los circuitos");
            circuitosResponse.setStatus(-100);
            circuitosResponse.setMessage("No se puede obtener los circuitos");
            return Response.ok(circuitosResponse).build();
        }

        List<CircuitoMask> circuitoMaskList = new ArrayList<>();
        for (Circuitos cd : circuitosList) {
            CircuitoMask cm = new CircuitoMask();
            cm.setId(cd.getId());
            cm.setDescripcion(cd.getDescripcion());
            circuitoMaskList.add(cm);
        }

        circuitosResponse.setStatus(100);
        circuitosResponse.setMessage("Sincronizacion exitosa");
        circuitosResponse.getList().addAll(circuitoMaskList);
        return Response.ok(circuitosResponse).build();

    }

}
