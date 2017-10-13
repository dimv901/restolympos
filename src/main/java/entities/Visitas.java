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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "visitas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visitas.findAll", query = "SELECT v FROM Visitas v")
    , @NamedQuery(name = "Visitas.findById", query = "SELECT v FROM Visitas v WHERE v.id = :id")
    , @NamedQuery(name = "Visitas.findByFechaCreacion", query = "SELECT v FROM Visitas v WHERE v.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Visitas.findByFechaActualizacion", query = "SELECT v FROM Visitas v WHERE v.fechaActualizacion = :fechaActualizacion")})
public class Visitas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clientes idCliente;
    @JoinColumn(name = "id_motivo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MotivosNoCompra idMotivo;
    @Basic(optional = false)
    @Column(name = "longitud")
    private Double longitud;
    @Basic(optional = false)
    @Column(name = "latitud")
    private Double latitud;

    public Visitas() {
    }

    public Visitas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public MotivosNoCompra getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(MotivosNoCompra idMotivo) {
        this.idMotivo = idMotivo;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
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
        if (!(object instanceof Visitas)) {
            return false;
        }
        Visitas other = (Visitas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Visitas[ id=" + id + " ]";
    }

}
