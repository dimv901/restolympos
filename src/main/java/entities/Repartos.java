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
@Table(name = "repartos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repartos.findAll", query = "SELECT r FROM Repartos r")
    , @NamedQuery(name = "Repartos.findById", query = "SELECT r FROM Repartos r WHERE r.id = :id")
    , @NamedQuery(name = "Repartos.findByEntregado", query = "SELECT r FROM Repartos r WHERE r.entregado = :entregado")
    , @NamedQuery(name = "Repartos.findByFechaEntregado", query = "SELECT r FROM Repartos r WHERE r.fechaEntregado = :fechaEntregado")
    , @NamedQuery(name = "Repartos.findByFechaCreacion", query = "SELECT r FROM Repartos r WHERE r.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Repartos.findByFechaActualizacion", query = "SELECT r FROM Repartos r WHERE r.fechaActualizacion = :fechaActualizacion")})
public class Repartos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entregado")
    private boolean entregado;
    @Column(name = "fecha_entregado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntregado;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @JoinColumn(name = "id_comprobante_venta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ComprobantesVentaCabecera idComprobanteVenta;
    @JoinColumn(name = "id_repartidor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Repartidores idRepartidor;

    public Repartos() {
    }

    public Repartos(Integer id) {
        this.id = id;
    }

    public Repartos(Integer id, boolean entregado) {
        this.id = id;
        this.entregado = entregado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public Date getFechaEntregado() {
        return fechaEntregado;
    }

    public void setFechaEntregado(Date fechaEntregado) {
        this.fechaEntregado = fechaEntregado;
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

    public ComprobantesVentaCabecera getIdComprobanteVenta() {
        return idComprobanteVenta;
    }

    public void setIdComprobanteVenta(ComprobantesVentaCabecera idComprobanteVenta) {
        this.idComprobanteVenta = idComprobanteVenta;
    }

    public Repartidores getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(Repartidores idRepartidor) {
        this.idRepartidor = idRepartidor;
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
        if (!(object instanceof Repartos)) {
            return false;
        }
        Repartos other = (Repartos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Repartos[ id=" + id + " ]";
    }
    
}
