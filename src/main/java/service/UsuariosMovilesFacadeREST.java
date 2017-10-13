/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.UsuariosMoviles;
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
import request.LoginRequest;
import response.LoginResponse;

/**
 *
 * @author Diego
 */
@Stateless
@Path("entities.usuariosmoviles")
public class UsuariosMovilesFacadeREST extends AbstractFacade<UsuariosMoviles> {

    @PersistenceContext(unitName = "py.com.twisted_RestOlympos_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private static final Logger logger = LoggerFactory.getLogger(UsuariosMovilesFacadeREST.class);

    public UsuariosMovilesFacadeREST() {
        super(UsuariosMoviles.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(UsuariosMoviles entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, UsuariosMoviles entity) {
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
    public UsuariosMoviles find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<UsuariosMoviles> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<UsuariosMoviles> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest loginRequest) {
        logger.debug("Parametros Recibidos =>", loginRequest.toString());
        LoginResponse loginResponse = new LoginResponse();
        UsuariosMoviles us = null;
        Query q = em.createNamedQuery("UsuariosMoviles.findByUsuario");
        q.setParameter("usuario", loginRequest.getUsuario());

        try {
            us = (UsuariosMoviles) q.getSingleResult();
        } catch (Exception e) {
            logger.error("Error", e.getMessage());
        }

        if (us == null) {
            logger.error("Error", "No se encontro el usuario");
            loginResponse.setStatus(-100);
            loginResponse.setMessage("No se encontro el usuario");
            return Response.ok(loginResponse).build();
        }

        if (!us.getPassword().equals(loginRequest.getPassword())) {
            logger.error("Error", "Password incorrecto");
            loginResponse.setStatus(-100);
            loginResponse.setMessage("Password incorrecto");
            return Response.ok(loginResponse).build();
        }

        if (!us.getActivo()) {
            logger.error("Error", "El usuasrio no esta activo");
            loginResponse.setStatus(-100);
            loginResponse.setMessage("El usuasrio no esta activo");
            return Response.ok(loginResponse).build();
        }

        //LOGIN EXITOSO
        loginResponse.setStatus(100);
        loginResponse.setUsuario(loginRequest.getUsuario());
        loginResponse.setMessage("Login exitoso");

        return Response.ok(loginResponse).build();
    }

    @POST
    @Path("updatePin")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePin(LoginRequest loginRequest) {
        logger.debug("Parametros Recibidos =>", loginRequest.toString());
        LoginResponse loginResponse = new LoginResponse();
        UsuariosMoviles us = null;
        Query q = em.createNamedQuery("UsuariosMoviles.findByUsuario");
        q.setParameter("usuario", loginRequest.getUsuario());

        try {
            us = (UsuariosMoviles) q.getSingleResult();
        } catch (Exception e) {
            logger.error("Error", e.getMessage());
        }

        if (us == null) {
            logger.error("Error", "No se encontro el usuario");
            loginResponse.setStatus(-100);
            loginResponse.setMessage("No se encontro el usuario");
            return Response.ok(loginResponse).build();
        }

        try {
            us.setPassword(loginRequest.getPassword());
            em.merge(us);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error", "No se pudo actualizar el PIN");
            loginResponse.setStatus(-100);
            loginResponse.setMessage("No se pudo actualizar el PIN");
            return Response.ok(loginResponse).build();
        }

        //LOGIN EXITOSO
        loginResponse.setStatus(100);
        loginResponse.setMessage("El PIN se actualizo correctamente, por favor vuelva a iniciar su sesion.");
        return Response.ok(loginResponse).build();
    }

}
