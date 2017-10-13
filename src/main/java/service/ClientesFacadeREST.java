/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Circuitos;
import entities.Clientes;
import entities.Vendedores;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.imageio.ImageIO;
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
import mask.ClienteMask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import response.BasicResponse;
import request.UpdateClientRequest;
import request.VendedorRequest;
import response.ClientesResponse;
import sun.misc.BASE64Decoder;

/**
 *
 * @author Diego
 */
@Stateless
@Path("entities.clientes")
public class ClientesFacadeREST extends AbstractFacade<Clientes> {

    @PersistenceContext(unitName = "py.com.twisted_RestOlympos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(ClientesFacadeREST.class);

    public ClientesFacadeREST() {
        super(Clientes.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Clientes entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Clientes entity) {
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
    public Clientes find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Clientes> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Clientes> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("getClientes")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getClientes(VendedorRequest vendedorRequest) {
        logger.debug("Parametros Recibidos =>", vendedorRequest.toString());
        ClientesResponse clientesResponse = new ClientesResponse();

        Vendedores vd = null;
        Query qVendedor = em.createNamedQuery("Vendedores.findByCedula");
        qVendedor.setParameter("cedula", vendedorRequest.getUsuario());

        try {
            vd = (Vendedores) qVendedor.getSingleResult();
        } catch (Exception e) {
            logger.error("Error", e.getMessage());
        }

        if (vd == null) {
            logger.error("Error", "No se encontro el vendedor");
            clientesResponse.setStatus(-100);
            clientesResponse.setMessage("No se encontro el vendedor");
            return Response.ok(clientesResponse).build();
        }

        if (!vd.getAndroid()) {
            logger.error("Error", "El vendedor no esta habilitado para operar desde Android");
            clientesResponse.setStatus(-100);
            clientesResponse.setMessage("El vendedor no esta habilitado para operar desde Android");
            return Response.ok(clientesResponse).build();
        }

        Query qCircuitos = em.createNamedQuery("Circuitos.findById");
        qCircuitos.setParameter("id", vd.getIdCircuito().getId());
        Circuitos c = null;
        try {
            c = (Circuitos) qCircuitos.getSingleResult();
        } catch (Exception e) {
            logger.error("Error", e.getMessage());
        }

        if (c == null) {
            logger.error("Error", "No se pueden obtener el circuito del vendedor");
            clientesResponse.setStatus(-100);
            clientesResponse.setMessage("No se pueden obtener el circuito del vendedor");
            return Response.ok(clientesResponse).build();
        }

        List<Clientes> clientesList = c.getClientesList();
        if (clientesList.isEmpty()) {
            logger.error("Error", "No se pueden obtener los clientes del vendedor");
            clientesResponse.setStatus(-100);
            clientesResponse.setMessage("No se pueden obtener los clientes del vendedor");
            return Response.ok(clientesResponse).build();
        }

        List<ClienteMask> clientMaskList = new ArrayList<>();

        for (Clientes cc : clientesList) {
            ClienteMask cm = new ClienteMask();
            cm.setId(cc.getId());
            cm.setNombreTitular(cc.getNombreTitular());
            cm.setCedulaTitular(cc.getCedulaTitular());
            cm.setContactoTitular(cc.getContactoTitular());
            cm.setEmailTitular(cc.getEmailTitular());
            cm.setRazonSocial(cc.getRazonSocial());
            cm.setNombreNegocio(cc.getNombreNegocio());
            cm.setRuc(cc.getRuc());
            cm.setEmailNegocio(cc.getEmailNegocio());
            cm.setTelefonoNegocio(cc.getTelefonoNegocio());
            cm.setBarrio(cc.getBarrio());
            cm.setCallePrincipal(cc.getCallePrincipal());
            cm.setCalleSecundaria(cc.getCalleSecundaria());
            cm.setNumeroCasa(cc.getNumeroCasa());
            cm.setReferencia(cc.getReferencia());
            StringBuilder sb = new StringBuilder();
            sb.append(cc.getCallePrincipal()).append(" ").append("#").append(cc.getNumeroCasa()).append(" ").append("c/").append(" ").append(cc.getCalleSecundaria());
            cm.setDireccion(sb.toString());
            cm.setGeolocalizado(cc.getGeolocalizado());
            cm.setLatitud(cc.getLatitud());
            cm.setLongitud(cc.getLongitud());
            cm.setTieneFoto(cc.getTieneFoto());
            if (cc.getTieneFoto()) {
                String base64String = Base64.getEncoder().encodeToString(cc.getFoto());
                cm.setFoto(base64String);
            }
            cm.setLunes(cc.getLunes());
            cm.setMartes(cc.getMartes());
            cm.setMiercoles(cc.getMiercoles());
            cm.setJueves(cc.getJueves());
            cm.setViernes(cc.getViernes());
            cm.setSabado(cc.getSabado());
            cm.setDomingo(cc.getDomingo());
            cm.setIdCircuito(cc.getIdCircuito().getId());
            cm.setIdCiudad(cc.getIdCiudad().getId());
            cm.setIdDepartamento(cc.getIdDepartamento().getId());

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String sData = sdf.format(cc.getHoraVisita());
            System.out.println("FECHA Y HORA ORGINAL" + cc.getHoraVisita());
            System.out.println("FECHA Y HORA " + sData);
            cm.setHoraVisita(sData);
            clientMaskList.add(cm);
        }
        clientesResponse.setStatus(100);
        clientesResponse.setMessage("Sincronizacion exitosa");
        clientesResponse.getList().addAll(clientMaskList);
        return Response.ok(clientesResponse).build();
    }

    @POST
    @Path("actualizarClienteUbicacion")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateClienteLocation(UpdateClientRequest updateClientRequest) {
        System.out.println("Parametros Recibidos =>" + updateClientRequest.toString());
        logger.debug("Parametros Recibidos =>", updateClientRequest.toString());
        BasicResponse basicResponse = new BasicResponse();
        boolean saved = false;
        Clientes cl = null;
        Query qClientes = em.createNamedQuery("Clientes.findById");
        qClientes.setParameter("id", updateClientRequest.getClientId());
        cl = (Clientes) qClientes.getSingleResult();
        if (cl == null) {
            logger.error("Error", "No se encontro el cliente");
            basicResponse.setStatus(-100);
            basicResponse.setMessage("No se encontro el cliente");
            return Response.ok(basicResponse).build();
        }

        if (updateClientRequest.getLatitude() != 0 && updateClientRequest.getLongitude() != 0) {
            cl.setLatitud(updateClientRequest.getLatitude());
            cl.setLongitud(updateClientRequest.getLongitude());
            cl.setGeolocalizado(true);
            cl.setFechaActualizacion(new Date());
        }

        try {
            em.persist(cl);
            saved = true;
        } catch (Exception e) {
            logger.error("Error", "Error al actualizar la localizacion del cliente");
        }

        if (!saved) {
            basicResponse.setStatus(-100);
            basicResponse.setMessage("Error al actualizar la localizacion del cliente");
            return Response.ok(basicResponse).build();
        }

        basicResponse.setStatus(100);
        basicResponse.setMessage("Cliente actualizado correctamente");
        return Response.ok(basicResponse).build();
    }

    @POST
    @Path("actualizarClienteFoto")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateClientePicture(UpdateClientRequest updateClientRequest) {
        logger.debug("Parametros Recibidos =>", updateClientRequest.toString());
        BasicResponse basicResponse = new BasicResponse();
        boolean saved = false;
        Clientes cl = null;
        String filePath = "c://imagenes//negocio//";
        String filename = "";
        String extension = ".jpg";
        Query qClientes = em.createNamedQuery("Clientes.findById");
        qClientes.setParameter("id", updateClientRequest.getClientId());
        cl = (Clientes) qClientes.getSingleResult();
        if (cl == null) {
            logger.error("Error", "No se encontro el cliente");
            basicResponse.setStatus(-100);
            basicResponse.setMessage("No se encontro el cliente");
            return Response.ok(basicResponse).build();
        }
        filename = String.valueOf(cl.getId());

        try {
            BufferedImage image = null;
            byte[] imageByte;
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(updateClientRequest.getPicture());
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
// write the image to a file
            File outputfile = new File(filePath + filename + extension);
            ImageIO.write(image, "jpg", outputfile);
            cl.setTieneFoto(true);
            cl.setFotoUrl(outputfile.getPath());
            cl.setFoto(imageByte);
        } catch (Exception e) {
            logger.error("Error", "Error al convertir la imagen");
            basicResponse.setStatus(-100);
            basicResponse.setMessage("Error al convertir la imagen");
            return Response.ok(basicResponse).build();
        }

        try {
            em.persist(cl);
            saved = true;
        } catch (Exception e) {
            logger.error("Error", "Error al actualizar la imagen del cliente");
        }

        if (!saved) {
            basicResponse.setStatus(-100);
            basicResponse.setMessage("Error al actualizar la imagen del cliente");
            return Response.ok(basicResponse).build();
        }

        basicResponse.setStatus(100);
        basicResponse.setMessage("Cliente actualizado correctamente");
        return Response.ok(basicResponse).build();
    }
}
