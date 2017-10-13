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
@Table(name = "comprobantes_venta_cabecera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprobantesVentaCabecera.findAll", query = "SELECT c FROM ComprobantesVentaCabecera c")
    , @NamedQuery(name = "ComprobantesVentaCabecera.findById", query = "SELECT c FROM ComprobantesVentaCabecera c WHERE c.id = :id")
    , @NamedQuery(name = "ComprobantesVentaCabecera.findByTotalComprobante", query = "SELECT c FROM ComprobantesVentaCabecera c WHERE c.totalComprobante = :totalComprobante")
    , @NamedQuery(name = "ComprobantesVentaCabecera.findByTotalIva10", query = "SELECT c FROM ComprobantesVentaCabecera c WHERE c.totalIva10 = :totalIva10")
    , @NamedQuery(name = "ComprobantesVentaCabecera.findByTotalIva5", query = "SELECT c FROM ComprobantesVentaCabecera c WHERE c.totalIva5 = :totalIva5")
    , @NamedQuery(name = "ComprobantesVentaCabecera.findByTotalExentas", query = "SELECT c FROM ComprobantesVentaCabecera c WHERE c.totalExentas = :totalExentas")
    , @NamedQuery(name = "ComprobantesVentaCabecera.findByFechaCreacion", query = "SELECT c FROM ComprobantesVentaCabecera c WHERE c.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "ComprobantesVentaCabecera.findByFechaActualizacion", query = "SELECT c FROM ComprobantesVentaCabecera c WHERE c.fechaActualizacion = :fechaActualizacion")})
public class ComprobantesVentaCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_comprobante")
    private double totalComprobante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_iva_10")
    private double totalIva10;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_iva_5")
    private double totalIva5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_exentas")
    private double totalExentas;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComprobanteVenta")
    private List<Repartos> repartosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCabecera")
    private List<ComprobantesVentaDetalle> comprobantesVentaDetalleList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clientes idCliente;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PedidosCabecera idPedido;
    @JoinColumn(name = "id_tipo_comprobante", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoComprobantes idTipoComprobante;

    public ComprobantesVentaCabecera() {
    }

    public ComprobantesVentaCabecera(Integer id) {
        this.id = id;
    }

    public ComprobantesVentaCabecera(Integer id, double totalComprobante, double totalIva10, double totalIva5, double totalExentas) {
        this.id = id;
        this.totalComprobante = totalComprobante;
        this.totalIva10 = totalIva10;
        this.totalIva5 = totalIva5;
        this.totalExentas = totalExentas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTotalComprobante() {
        return totalComprobante;
    }

    public void setTotalComprobante(double totalComprobante) {
        this.totalComprobante = totalComprobante;
    }

    public double getTotalIva10() {
        return totalIva10;
    }

    public void setTotalIva10(double totalIva10) {
        this.totalIva10 = totalIva10;
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
    public List<Repartos> getRepartosList() {
        return repartosList;
    }

    public void setRepartosList(List<Repartos> repartosList) {
        this.repartosList = repartosList;
    }

    @XmlTransient
    public List<ComprobantesVentaDetalle> getComprobantesVentaDetalleList() {
        return comprobantesVentaDetalleList;
    }

    public void setComprobantesVentaDetalleList(List<ComprobantesVentaDetalle> comprobantesVentaDetalleList) {
        this.comprobantesVentaDetalleList = comprobantesVentaDetalleList;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public PedidosCabecera getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(PedidosCabecera idPedido) {
        this.idPedido = idPedido;
    }

    public TipoComprobantes getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(TipoComprobantes idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
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
        if (!(object instanceof ComprobantesVentaCabecera)) {
            return false;
        }
        ComprobantesVentaCabecera other = (ComprobantesVentaCabecera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ComprobantesVentaCabecera[ id=" + id + " ]";
    }
    
}
