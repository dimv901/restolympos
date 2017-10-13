/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Diego
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.CircuitosFacadeREST.class);
        resources.add(service.CiudadesFacadeREST.class);
        resources.add(service.ClientesFacadeREST.class);
        resources.add(service.ComprobantesCompraCabeceraFacadeREST.class);
        resources.add(service.ComprobantesCompraDetalleFacadeREST.class);
        resources.add(service.ComprobantesVentaCabeceraFacadeREST.class);
        resources.add(service.ComprobantesVentaDetalleFacadeREST.class);
        resources.add(service.DepartamentosFacadeREST.class);
        resources.add(service.EmpresaFacadeREST.class);
        resources.add(service.FormasPagoFacadeREST.class);
        resources.add(service.MotivosNoCompraFacadeREST.class);
        resources.add(service.MovilesFacadeREST.class);
        resources.add(service.MovimientoStockFacadeREST.class);
        resources.add(service.OrdenCompraCabeceraFacadeREST.class);
        resources.add(service.OrdenCompraDetalleFacadeREST.class);
        resources.add(service.PaisesFacadeREST.class);
        resources.add(service.PedidosCabeceraFacadeREST.class);
        resources.add(service.PedidosDetalleFacadeREST.class);
        resources.add(service.ProductoFamiliasFacadeREST.class);
        resources.add(service.ProductosFacadeREST.class);
        resources.add(service.ProveedoresFacadeREST.class);
        resources.add(service.RepartidoresFacadeREST.class);
        resources.add(service.RepartosFacadeREST.class);
        resources.add(service.StockFacadeREST.class);
        resources.add(service.TipoComprobantesFacadeREST.class);
        resources.add(service.TipoImpuestosFacadeREST.class);
        resources.add(service.UsuariosMovilesFacadeREST.class);
        resources.add(service.UsuariosWebFacadeREST.class);
        resources.add(service.VendedoresFacadeREST.class);
        resources.add(service.VisitasFacadeREST.class);
    }
    
}
