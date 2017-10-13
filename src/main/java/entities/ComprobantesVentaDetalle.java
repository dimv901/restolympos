/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "comprobantes_venta_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprobantesVentaDetalle.findAll", query = "SELECT c FROM ComprobantesVentaDetalle c")
    , @NamedQuery(name = "ComprobantesVentaDetalle.findById", query = "SELECT c FROM ComprobantesVentaDetalle c WHERE c.id = :id")
    , @NamedQuery(name = "ComprobantesVentaDetalle.findByCantidad", query = "SELECT c FROM ComprobantesVentaDetalle c WHERE c.cantidad = :cantidad")
    , @NamedQuery(name = "ComprobantesVentaDetalle.findByImporte", query = "SELECT c FROM ComprobantesVentaDetalle c WHERE c.importe = :importe")
    , @NamedQuery(name = "ComprobantesVentaDetalle.findByPrecio", query = "SELECT c FROM ComprobantesVentaDetalle c WHERE c.precio = :precio")
    , @NamedQuery(name = "ComprobantesVentaDetalle.findByFechaCreacion", query = "SELECT c FROM ComprobantesVentaDetalle c WHERE c.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "ComprobantesVentaDetalle.findByFechaActualizacion", query = "SELECT c FROM ComprobantesVentaDetalle c WHERE c.fechaActualizacion = :fechaActualizacion")})
public class ComprobantesVentaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private double cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private double importe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @JoinColumn(name = "id_cabecera", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ComprobantesVentaCabecera idCabecera;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Productos idProducto;

    public ComprobantesVentaDetalle() {
    }

    public ComprobantesVentaDetalle(Integer id) {
        this.id = id;
    }

    public ComprobantesVentaDetalle(Integer id, double cantidad, double importe, double precio) {
        this.id = id;
        this.cantidad = cantidad;
        this.importe = importe;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public ComprobantesVentaCabecera getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(ComprobantesVentaCabecera idCabecera) {
        this.idCabecera = idCabecera;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobantesVentaDetalle)) {
            return false;
        }
        ComprobantesVentaDetalle other = (ComprobantesVentaDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ComprobantesVentaDetalle[ id=" + id + " ]";
    }
    
}
