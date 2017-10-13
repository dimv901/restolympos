/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Departamentos;
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
import mask.DepartamentoMask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import request.VendedorRequest;
import response.DepartamentosResponse;

/**
 *
 * @author Diego
 */
@Stateless
@Path("entities.departamentos")
public class DepartamentosFacadeREST extends AbstractFacade<Departamentos> {

    @PersistenceContext(unitName = "py.com.twisted_RestOlympos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(DepartamentosFacadeREST.class);

    public DepartamentosFacadeREST() {
        super(Departamentos.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Departamentos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Departamentos entity) {
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
    public Departamentos find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Departamentos> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Departamentos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("getDepartamentos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getDepartamentos(VendedorRequest vendedorRequest) {
        logger.debug("Parametros Recibidos =>", vendedorRequest.toString());
        DepartamentosResponse departamentosResponse = new DepartamentosResponse();
        List<Departamentos> departamentosList = new ArrayList<>();

        departamentosList = super.findAll();
        if (departamentosList.isEmpty()) {
            logger.error("Error", "No se puede obtener la lista de departamentos");
            departamentosResponse.setStatus(-100);
            departamentosResponse.setMessage("No se puede obtener la lista de departamentos");
            return Response.ok(departamentosResponse).build();
        }

        List<DepartamentoMask> departamentoMasksList = new ArrayList<>();
        for (Departamentos dp : departamentosList) {
            DepartamentoMask dm = new DepartamentoMask();
            dm.setId(dp.getId());
            dm.setDescripcion(dp.getDescripcion());
            departamentoMasksList.add(dm);
        }

        departamentosResponse.setStatus(100);
        departamentosResponse.setMessage("Sincronizacion exitosa");
        departamentosResponse.getList().addAll(departamentoMasksList);
        return Response.ok(departamentosResponse).build();
    }

}
