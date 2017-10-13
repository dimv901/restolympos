/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Ciudades;
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
import mask.CiudadMask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import request.VendedorRequest;
import response.CiudadesResponse;

/**
 *
 * @author Diego
 */
@Stateless
@Path("entities.ciudades")
public class CiudadesFacadeREST extends AbstractFacade<Ciudades> {

    @PersistenceContext(unitName = "py.com.twisted_RestOlympos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(CiudadesFacadeREST.class);

    public CiudadesFacadeREST() {
        super(Ciudades.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Ciudades entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Ciudades entity) {
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
    public Ciudades find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ciudades> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ciudades> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("getCiudades")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCiudades(VendedorRequest vendedorRequest) {
        logger.debug("Parametros Recibidos =>", vendedorRequest.toString());
        CiudadesResponse cuidadesResponse = new CiudadesResponse();
        List<Ciudades> ciudadesList = new ArrayList();

        ciudadesList = super.findAll();
        if (ciudadesList.isEmpty()) {
            logger.error("Error", "No se puede obtener la lista de ciudades");
            cuidadesResponse.setStatus(-100);
            cuidadesResponse.setMessage("No se puede obtener la lista de ciudades");
            return Response.ok(cuidadesResponse).build();
        }

        List<CiudadMask> ciudadMaskList = new ArrayList<>();
        for (Ciudades cd : ciudadesList) {
            CiudadMask cm = new CiudadMask();
            cm.setId(cd.getId());
            cm.setDescripcion(cd.getDescripcion());
            cm.setIdDepartamento(cd.getIdDepartamento().getId());
            ciudadMaskList.add(cm);
        }

        cuidadesResponse.setStatus(100);
        cuidadesResponse.setMessage("Sincronizacion exitosa");
        cuidadesResponse.getList().addAll(ciudadMaskList);
        return Response.ok(cuidadesResponse).build();

    }

}
