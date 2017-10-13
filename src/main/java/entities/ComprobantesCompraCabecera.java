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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "comprobantes_compra_cabecera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprobantesCompraCabecera.findAll", query = "SELECT c FROM ComprobantesCompraCabecera c")
    , @NamedQuery(name = "ComprobantesCompraCabecera.findById", query = "SELECT c FROM ComprobantesCompraCabecera c WHERE c.id = :id")
    , @NamedQuery(name = "ComprobantesCompraCabecera.findByNumeroComprobante", query = "SELECT c FROM ComprobantesCompraCabecera c WHERE c.numeroComprobante = :numeroComprobante")
    , @NamedQuery(name = "ComprobantesCompraCabecera.findByTotalComprobante", query = "SELECT c FROM ComprobantesCompraCabecera c WHERE c.totalComprobante = :totalComprobante")
    , @NamedQuery(name = "ComprobantesCompraCabecera.findByTotalGravadas10", query = "SELECT c FROM ComprobantesCompraCabecera c WHERE c.totalGravadas10 = :totalGravadas10")
    , @NamedQuery(name = "ComprobantesCompraCabecera.findByTotalIva10", query = "SELECT c FROM ComprobantesCompraCabecera c WHERE c.totalIva10 = :totalIva10")
    , @NamedQuery(name = "ComprobantesCompraCabecera.findByTotalGravadas5", query = "SELECT c FROM ComprobantesCompraCabecera c WHERE c.totalGravadas5 = :totalGravadas5")
    , @NamedQuery(name = "ComprobantesCompraCabecera.findByTotalIva5", query = "SELECT c FROM ComprobantesCompraCabecera c WHERE c.totalIva5 = :totalIva5")
    , @NamedQuery(name = "ComprobantesCompraCabecera.findByTotalExentas", query = "SELECT c FROM ComprobantesCompraCabecera c WHERE c.totalExentas = :totalExentas")
    , @NamedQuery(name = "ComprobantesCompraCabecera.findByFechaActualizacion", query = "SELECT c FROM ComprobantesCompraCabecera c WHERE c.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "ComprobantesCompraCabecera.findByFechaCreacion", query = "SELECT c FROM ComprobantesCompraCabecera c WHERE c.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "ComprobantesCompraCabecera.findByFechaComprobante", query = "SELECT c FROM ComprobantesCompraCabecera c WHERE c.fechaComprobante = :fechaComprobante")})
public class ComprobantesCompraCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "numero_comprobante")
    private String numeroComprobante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_comprobante")
    private double totalComprobante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_gravadas_10")
    private double totalGravadas10;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_iva_10")
    private double totalIva10;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_gravadas_5")
    private double totalGravadas5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_iva_5")
    private double totalIva5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_exentas")
    private double totalExentas;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_comprobante")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaComprobante;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proveedores idProveedor;
    @JoinColumn(name = "id_tipo_comprobante", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoComprobantes idTipoComprobante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCabecera")
    private List<ComprobantesCompraDetalle> comprobantesCompraDetalleList;

    public ComprobantesCompraCabecera() {
    }

    public ComprobantesCompraCabecera(Integer id) {
        this.id = id;
    }

    public ComprobantesCompraCabecera(Integer id, String numeroComprobante, double totalComprobante, double totalGravadas10, double totalIva10, double totalGravadas5, double totalIva5, double totalExentas, Date fechaComprobante) {
        this.id = id;
        this.numeroComprobante = numeroComprobante;
        this.totalComprobante = totalComprobante;
        this.totalGravadas10 = totalGravadas10;
        this.totalIva10 = totalIva10;
        this.totalGravadas5 = totalGravadas5;
        this.totalIva5 = totalIva5;
        this.totalExentas = totalExentas;
        this.fechaComprobante = fechaComprobante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public double getTotalComprobante() {
        return totalComprobante;
    }

    public void setTotalComprobante(double totalComprobante) {
        this.totalComprobante = totalComprobante;
    }

    public double getTotalGravadas10() {
        return totalGravadas10;
    }

    public void setTotalGravadas10(double totalGravadas10) {
        this.totalGravadas10 = totalGravadas10;
    }

    public double getTotalIva10() {
        return totalIva10;
    }

    public void setTotalIva10(double totalIva10) {
        this.totalIva10 = totalIva10;
    }

    public double getTotalGravadas5() {
        return totalGravadas5;
    }

    public void setTotalGravadas5(double totalGravadas5) {
        this.totalGravadas5 = totalGravadas5;
    }

    public double getTotalIva5() {
        return totalIva5;
    }

    public void setTotalIva5(double totalIva5) {
        this.totalIva5 = totalIva5;
    }

    public double getTotalExentas() {
        return totalExentas;
    }

    public void setTotalExentas(double totalExentas) {
        this.totalExentas = totalExentas;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaComprobante() {
        return fechaComprobante;
    }

    public void setFechaComprobante(Date fechaComprobante) {
        this.fechaComprobante = fechaComprobante;
    }

    public Proveedores getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedores idProveedor) {
        this.idProveedor = idProveedor;
    }

    public TipoComprobantes getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(TipoComprobantes idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    @XmlTransient
    public List<ComprobantesCompraDetalle> getComprobantesCompraDetalleList() {
        return comprobantesCompraDetalleList;
    }

    public void setComprobantesCompraDetalleList(List<ComprobantesCompraDetalle> comprobantesCompraDetalleList) {
        this.comprobantesCompraDetalleList = comprobantesCompraDetalleList;
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
        if (!(object instanceof ComprobantesCompraCabecera)) {
            return false;
        }
        ComprobantesCompraCabecera other = (ComprobantesCompraCabecera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ComprobantesCompraCabecera[ id=" + id + " ]";
    }
    
}
