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
@Table(name = "tipo_comprobantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoComprobantes.findAll", query = "SELECT t FROM TipoComprobantes t")
    , @NamedQuery(name = "TipoComprobantes.findById", query = "SELECT t FROM TipoComprobantes t WHERE t.id = :id")
    , @NamedQuery(name = "TipoComprobantes.findByDescripcion", query = "SELECT t FROM TipoComprobantes t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TipoComprobantes.findByFechaCreacion", query = "SELECT t FROM TipoComprobantes t WHERE t.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "TipoComprobantes.findByFechaActualizacion", query = "SELECT t FROM TipoComprobantes t WHERE t.fechaActualizacion = :fechaActualizacion")})
public class TipoComprobantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoComprobante")
    private List<ComprobantesCompraCabecera> comprobantesCompraCabeceraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoComprobante")
    private List<ComprobantesVentaCabecera> comprobantesVentaCabeceraList;

    public TipoComprobantes() {
    }

    public TipoComprobantes(Integer id) {
        this.id = id;
    }

    public TipoComprobantes(Integer id, String descripcion) {
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

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    @XmlTransient
    public List<ComprobantesCompraCabecera> getComprobantesCompraCabeceraList() {
        return comprobantesCompraCabeceraList;
    }

    public void setComprobantesCompraCabeceraList(List<ComprobantesCompraCabecera> comprobantesCompraCabeceraList) {
        this.comprobantesCompraCabeceraList = comprobantesCompraCabeceraList;
    }

    @XmlTransient
    public List<ComprobantesVentaCabecera> getComprobantesVentaCabeceraList() {
        return comprobantesVentaCabeceraList;
    }

    public void setComprobantesVentaCabeceraList(List<ComprobantesVentaCabecera> comprobantesVentaCabeceraList) {
        this.comprobantesVentaCabeceraList = comprobantesVentaCabeceraList;
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
        if (!(object instanceof TipoComprobantes)) {
            return false;
        }
        TipoComprobantes other = (TipoComprobantes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoComprobantes[ id=" + id + " ]";
    }
    
}
