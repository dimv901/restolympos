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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "movimiento_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovimientoStock.findAll", query = "SELECT m FROM MovimientoStock m")
    , @NamedQuery(name = "MovimientoStock.findById", query = "SELECT m FROM MovimientoStock m WHERE m.id = :id")
    , @NamedQuery(name = "MovimientoStock.findByMovimiento", query = "SELECT m FROM MovimientoStock m WHERE m.movimiento = :movimiento")
    , @NamedQuery(name = "MovimientoStock.findByFechaMovimiento", query = "SELECT m FROM MovimientoStock m WHERE m.fechaMovimiento = :fechaMovimiento")
    , @NamedQuery(name = "MovimientoStock.findByCantidad", query = "SELECT m FROM MovimientoStock m WHERE m.cantidad = :cantidad")
    , @NamedQuery(name = "MovimientoStock.findByFechaCreacion", query = "SELECT m FROM MovimientoStock m WHERE m.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "MovimientoStock.findByFechaActualizacion", query = "SELECT m FROM MovimientoStock m WHERE m.fechaActualizacion = :fechaActualizacion")})
public class MovimientoStock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "movimiento")
    private String movimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_movimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private double cantidad;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Productos idProducto;

    public MovimientoStock() {
    }

    public MovimientoStock(Integer id) {
        this.id = id;
    }

    public MovimientoStock(Integer id, String movimiento, Date fechaMovimiento, double cantidad) {
        this.id = id;
        this.movimiento = movimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
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
        if (!(object instanceof MovimientoStock)) {
            return false;
        }
        MovimientoStock other = (MovimientoStock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MovimientoStock[ id=" + id + " ]";
    }
    
}
