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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "orden_compra_cabecera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenCompraCabecera.findAll", query = "SELECT o FROM OrdenCompraCabecera o")
    , @NamedQuery(name = "OrdenCompraCabecera.findById", query = "SELECT o FROM OrdenCompraCabecera o WHERE o.id = :id")
    , @NamedQuery(name = "OrdenCompraCabecera.findByFecha", query = "SELECT o FROM OrdenCompraCabecera o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "OrdenCompraCabecera.findByTotal", query = "SELECT o FROM OrdenCompraCabecera o WHERE o.total = :total")
    , @NamedQuery(name = "OrdenCompraCabecera.findByFechaCreacion", query = "SELECT o FROM OrdenCompraCabecera o WHERE o.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "OrdenCompraCabecera.findByFechaActualizacion", query = "SELECT o FROM OrdenCompraCabecera o WHERE o.fechaActualizacion = :fechaActualizacion")})
public class OrdenCompraCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proveedores idProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCabecera")
    private List<OrdenCompraDetalle> ordenCompraDetalleList;

    public OrdenCompraCabecera() {
    }

    public OrdenCompraCabecera(Integer id) {
        this.id = id;
    }

    public OrdenCompraCabecera(Integer id, Date fecha, double total) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public Proveedores getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedores idProveedor) {
        this.idProveedor = idProveedor;
    }

    @XmlTransient
    public List<OrdenCompraDetalle> getOrdenCompraDetalleList() {
        return ordenCompraDetalleList;
    }

    public void setOrdenCompraDetalleList(List<OrdenCompraDetalle> ordenCompraDetalleList) {
        this.ordenCompraDetalleList = ordenCompraDetalleList;
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
        if (!(object instanceof OrdenCompraCabecera)) {
            return false;
        }
        OrdenCompraCabecera other = (OrdenCompraCabecera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OrdenCompraCabecera[ id=" + id + " ]";
    }
    
}
