/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Clientes;
import entities.PedidosCabecera;
import entities.PedidosDetalle;
import entities.Productos;
import entities.Vendedores;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
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
import request.PedidosItemRequest;
import request.PedidosRequest;
import response.BasicResponse;

/**
 *
 * @author Diego
 */
@Stateless
@Path("entities.pedidoscabecera")
public class PedidosCabeceraFacadeREST extends AbstractFacade<PedidosCabecera> {

    @PersistenceContext(unitName = "py.com.twisted_RestOlympos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(PedidosCabeceraFacadeREST.class);

    public PedidosCabeceraFacadeREST() {
        super(PedidosCabecera.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(PedidosCabecera entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, PedidosCabecera entity) {
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
    public PedidosCabecera find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PedidosCabecera> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PedidosCabecera> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("registrarPedido")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarPedido(PedidosRequest pedidosRequest) {
        BasicResponse basicResponse = new BasicResponse();
        boolean saved = false;
        PedidosCabecera cabecera;

        Query qClientes = em.createNamedQuery("Clientes.findById");
        qClientes.setParameter("id", pedidosRequest.getIdCliente());
        Clientes cl = (Clientes) qClientes.getSingleResult();
        if (cl == null) {
            logger.error("Error", "No se encontro el cliente");
            basicResponse.setStatus(-100);
            basicResponse.setMessage("No se encontro el cliente");
            return Response.ok(basicResponse).build();
        }

        Query qVendedor = em.createNamedQuery("Vendedores.findById");
        qVendedor.setParameter("id", pedidosRequest.getIdVendedor());
        Vendedores ve = (Vendedores) qVendedor.getSingleResult();
        if (ve == null) {
            logger.error("Error", "No se encontro el vendedor");
            basicResponse.setStatus(-100);
            basicResponse.setMessage("No se encontro el vendedor");
            return Response.ok(basicResponse).build();
        }

        try {
            cabecera = new PedidosCabecera();
            cabecera.setIdCliente(cl);
            cabecera.setEstado("PENDIENTE");
            cabecera.setIdVendedor(ve);
            cabecera.setFechaCreacion(new Date());
            cabecera.setFechaPedido(new Date());
            cabecera.setImporte(pedidosRequest.getImporte());
            cabecera.setLatitud(pedidosRequest.getLatitud());
            cabecera.setLongitud(pedidosRequest.getLongitud());
            for (PedidosItemRequest pir : pedidosRequest.getDetalle()) {
                PedidosDetalle pe = new PedidosDetalle();
                pe.setCantidad(pir.getCantidad());
                pe.setFechaCreacion(new Date());
                pe.setIdCabecera(cabecera);
                Query qProducto = em.createNamedQuery("Productos.findById");
                qProducto.setParameter("id", pir.getIdProducto());
                Productos pr = (Productos) qProducto.getSingleResult();
                pe.setIdProducto(pr);
                pe.setPrecio(pr.getPrecioVenta());
                double imp = pr.getPrecioVenta() * pir.getCantidad();
                pe.setImporte(imp);
                cabecera.getPedidosDetalleList().add(pe);
            }
            em.persist(cabecera);
            saved = true;
            if (saved) {
                for (PedidosItemRequest pir : pedidosRequest.getDetalle()) {
                    Query qProducto = em.createNamedQuery("Productos.findById");
                    qProducto.setParameter("id", pir.getIdProducto());
                    Productos pr = (Productos) qProducto.getSingleResult();
                    double currentStock = pr.getStock().getCantidad() - pir.getCantidad();
                    pr.getStock().setCantidad(currentStock);
                    em.merge(pr);
                }
            }
        } catch (EJBException e) {
            e.printStackTrace();
            @SuppressWarnings("ThrowableResultIgnored")
            Exception cause = e.getCausedByException();
            if (cause instanceof ConstraintViolationException) {
                @SuppressWarnings("ThrowableResultIgnored")
                ConstraintViolationException cve = (ConstraintViolationException) e.getCausedByException();
                for (Iterator<ConstraintViolation<?>> it = cve.getConstraintViolations().iterator(); it.hasNext();) {
                    ConstraintViolation<? extends Object> v = it.next();
                    System.err.println(v);
                    System.err.println("==>>" + v.getMessage());
                }
            }
            logger.error("Error", "No se pudo guardar el pedido");
            basicResponse.setStatus(-100);
            basicResponse.setMessage("No se pudo guardar el pedido");
            return Response.ok(basicResponse).build();
        }

        if (!saved) {
            basicResponse.setStatus(-100);
            basicResponse.setMessage("No se pudo guardar el pedido");
            return Response.ok(basicResponse).build();
        }

        basicResponse.setStatus(100);
        basicResponse.setMessage("Pedido creado con exito.");
        return Response.ok(basicResponse).build();
    }

}
