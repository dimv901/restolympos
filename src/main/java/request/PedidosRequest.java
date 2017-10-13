/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package request;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class PedidosRequest {

    private int idCliente;
    private int idVendedor;
    private double importe;
    private double latitud;
    private double longitud;
    private List<PedidosItemRequest> detalle;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
  
    
    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public List<PedidosItemRequest> getDetalle() {
        if (detalle == null) {
            detalle = new ArrayList<>();
        }
        return detalle;
    }

    public void setDetalle(List<PedidosItemRequest> detalle) {
        this.detalle = detalle;
    }

}
