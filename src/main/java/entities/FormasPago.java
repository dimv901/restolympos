/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "formas_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormasPago.findAll", query = "SELECT f FROM FormasPago f")
    , @NamedQuery(name = "FormasPago.findById", query = "SELECT f FROM FormasPago f WHERE f.id = :id")
    , @NamedQuery(name = "FormasPago.findByDescripcion", query = "SELECT f FROM FormasPago f WHERE f.descripcion = :descripcion")
    , @NamedQuery(name = "FormasPago.findByFechaCreacion", query = "SELECT f FROM FormasPago f WHERE f.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "FormasPago.findByFechaActalizacion", query = "SELECT f FROM FormasPago f WHERE f.fechaActalizacion = :fechaActalizacion")})
public class FormasPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actalizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActalizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormaPago")
    private List<Clientes> clientesList;

    public FormasPago() {
    }

    public FormasPago(Integer id) {
        this.id = id;
    }

    public FormasPago(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActalizacion() {
        return fechaActalizacion;
    }

    public void setFechaActalizacion(Date fechaActalizacion) {
        this.fechaActalizacion = fechaActalizacion;
    }

    @XmlTransient
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
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
        if (!(object instanceof FormasPago)) {
            return false;
        }
        FormasPago other = (FormasPago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FormasPago[ id=" + id + " ]";
    }
    
}
