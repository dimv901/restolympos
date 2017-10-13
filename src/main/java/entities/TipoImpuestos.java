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
@Table(name = "tipo_impuestos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoImpuestos.findAll", query = "SELECT t FROM TipoImpuestos t")
    , @NamedQuery(name = "TipoImpuestos.findById", query = "SELECT t FROM TipoImpuestos t WHERE t.id = :id")
    , @NamedQuery(name = "TipoImpuestos.findByDescripcion", query = "SELECT t FROM TipoImpuestos t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TipoImpuestos.findByValor", query = "SELECT t FROM TipoImpuestos t WHERE t.valor = :valor")
    , @NamedQuery(name = "TipoImpuestos.findByFechaCreacion", query = "SELECT t FROM TipoImpuestos t WHERE t.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "TipoImpuestos.findByFechaActualizacion", query = "SELECT t FROM TipoImpuestos t WHERE t.fechaActualizacion = :fechaActualizacion")})
public class TipoImpuestos implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoImpuesto")
    private List<Productos> productosList;

    public TipoImpuestos() {
    }

    public TipoImpuestos(Integer id) {
        this.id = id;
    }

    public TipoImpuestos(Integer id, String descripcion, double valor) {
        this.id = id;
        this.descripcion = descripcion;
        this.valor = valor;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

    @XmlTransient
    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
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
        if (!(object instanceof TipoImpuestos)) {
            return false;
        }
        TipoImpuestos other = (TipoImpuestos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoImpuestos[ id=" + id + " ]";
    }
    
}
