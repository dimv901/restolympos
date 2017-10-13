/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.MotivosNoCompra;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import request.VendedorRequest;
import response.MotivosNoCompraResponse;

/**
 *
 * @author Diego
 */
@Stateless
@Path("entities.motivosnocompra")
public class MotivosNoCompraFacadeREST extends AbstractFacade<MotivosNoCompra> {

    @PersistenceContext(unitName = "py.com.twisted_RestOlympos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(MotivosNoCompraFacadeREST.class);

    public MotivosNoCompraFacadeREST() {
        super(MotivosNoCompra.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(MotivosNoCompra entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, MotivosNoCompra entity) {
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
    public MotivosNoCompra find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<MotivosNoCompra> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<MotivosNoCompra> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("getMotivosNoCompra")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMotivosNoCompra(VendedorRequest vendedorRequest) {
        logger.debug("Parametros Recibidos =>", vendedorRequest.toString());
        MotivosNoCompraResponse motivosNoCompraResponse = new MotivosNoCompraResponse();
        List<MotivosNoCompra> motivosNoCompraList = new ArrayList<>();
        try {
            motivosNoCompraList = super.findAll();
        } catch (Exception e) {
            logger.error("Error", e.getMessage());
        }

        if (motivosNoCompraList.isEmpty()) {
            logger.error("Error", "No se pueden obtener los motivos de no compra");
            motivosNoCompraResponse.setStatus(-100);
            motivosNoCompraResponse.setMessage("No se pueden obtener los motivos de no compra");
            return Response.ok(motivosNoCompraResponse).build();
        }

        motivosNoCompraResponse.setStatus(100);
        motivosNoCompraResponse.setMessage("Sincronizacion exitosa");
        motivosNoCompraResponse.getList().addAll(motivosNoCompraList);
        return Response.ok(motivosNoCompraResponse).build();
    }

}
