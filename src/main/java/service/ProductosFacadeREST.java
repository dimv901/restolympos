/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Productos;
import java.util.ArrayList;
import java.util.Base64;
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
import mask.ProductoMask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import request.VendedorRequest;
import response.ProductosResponse;

/**
 *
 * @author Diego
 */
@Stateless
@Path("entities.productos")
public class ProductosFacadeREST extends AbstractFacade<Productos> {

    @PersistenceContext(unitName = "py.com.twisted_RestOlympos_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private static final Logger logger = LoggerFactory.getLogger(ProductosFacadeREST.class);

    public ProductosFacadeREST() {
        super(Productos.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Productos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Productos entity) {
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
    public Productos find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Productos> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Productos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("getProductos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getProductos(VendedorRequest vendedorRequest) {
        logger.debug("Parametros Recibidos =>", vendedorRequest.toString());
        ProductosResponse productosResponse = new ProductosResponse();
        List<Productos> productosList = new ArrayList<>();
        try {
            productosList = super.findAll();
        } catch (Exception e) {
            logger.error("Error", e.getMessage());
        }

        if (productosList.isEmpty()) {
            logger.error("Error", "No se pueden obtener los productos");
            productosResponse.setStatus(-100);
            productosResponse.setMessage("No se pueden obtener los productos");
            return Response.ok(productosResponse).build();
        }

        List<ProductoMask> productoMasksList = new ArrayList<>();
        for (Productos p : productosList) {
            ProductoMask pm = new ProductoMask();
            pm.setId(p.getId());
            pm.setDescripcion(p.getDescripcion());
            pm.setCantidad(p.getStock().getCantidad());
            pm.setCodigoBarra(p.getCodigoBarra());
            pm.setTieneFoto(p.getTieneFoto());
            if (p.getTieneFoto()) {
                String base64String = Base64.getEncoder().encodeToString(p.getFoto());
                pm.setFoto(base64String);
            }
            pm.setPrecioVenta(p.getPrecioVenta());
            productoMasksList.add(pm);
        }
        productosResponse.setStatus(100);
        productosResponse.setMessage("Sincronizacion exitosa");
        productosResponse.getList().addAll(productoMasksList);
        return Response.ok(productosResponse).build();
    }

}
