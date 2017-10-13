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
@Table(name = "pedidos_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidosDetalle.findAll", query = "SELECT p FROM PedidosDetalle p")
    , @NamedQuery(name = "PedidosDetalle.findById", query = "SELECT p FROM PedidosDetalle p WHERE p.id = :id")
    , @NamedQuery(name = "PedidosDetalle.findByCantidad", query = "SELECT p FROM PedidosDetalle p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "PedidosDetalle.findByPrecio", query = "SELECT p FROM PedidosDetalle p WHERE p.precio = :precio")
    , @NamedQuery(name = "PedidosDetalle.findByImporte", query = "SELECT p FROM PedidosDetalle p WHERE p.importe = :importe")
    , @NamedQuery(name = "PedidosDetalle.findByFechaCreacion", query = "SELECT p FROM PedidosDetalle p WHERE p.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "PedidosDetalle.findByFechaActualizacion", query = "SELECT p FROM PedidosDetalle p WHERE p.fechaActualizacion = :fechaActualizacion")})
public class PedidosDetalle implements Serializable {

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
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private double importe;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @JoinColumn(name = "id_cabecera", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PedidosCabecera idCabecera;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Productos idProducto;

    public PedidosDetalle() {
    }

    public PedidosDetalle(Integer id) {
        this.id = id;
    }

    public PedidosDetalle(Integer id, double cantidad, double precio, double importe) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.importe = importe;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
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

    public PedidosCabecera getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(PedidosCabecera idCabecera) {
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
        if (!(object instanceof PedidosDetalle)) {
            return false;
        }
        PedidosDetalle other = (PedidosDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PedidosDetalle[ id=" + id + " ]";
    }
    
}
