/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "pedidos_cabecera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidosCabecera.findAll", query = "SELECT p FROM PedidosCabecera p")
    , @NamedQuery(name = "PedidosCabecera.findById", query = "SELECT p FROM PedidosCabecera p WHERE p.id = :id")
    , @NamedQuery(name = "PedidosCabecera.findByImporte", query = "SELECT p FROM PedidosCabecera p WHERE p.importe = :importe")
    , @NamedQuery(name = "PedidosCabecera.findByLatitud", query = "SELECT p FROM PedidosCabecera p WHERE p.latitud = :latitud")
    , @NamedQuery(name = "PedidosCabecera.findByLongitud", query = "SELECT p FROM PedidosCabecera p WHERE p.longitud = :longitud")
    , @NamedQuery(name = "PedidosCabecera.findByEstado", query = "SELECT p FROM PedidosCabecera p WHERE p.estado = :estado")
    , @NamedQuery(name = "PedidosCabecera.findByFechaPedido", query = "SELECT p FROM PedidosCabecera p WHERE p.fechaPedido = :fechaPedido")
    , @NamedQuery(name = "PedidosCabecera.findByFechaCreacion", query = "SELECT p FROM PedidosCabecera p WHERE p.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "PedidosCabecera.findByFechaActualizacion", query = "SELECT p FROM PedidosCabecera p WHERE p.fechaActualizacion = :fechaActualizacion")})
public class PedidosCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private double importe;
    @Basic(optional = false)
    @Column(name = "latitud")
    private double latitud;
    @Basic(optional = false)
    @Column(name = "longitud")
    private double longitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCabecera")
    private List<PedidosDetalle> pedidosDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedido")
    private List<ComprobantesVentaCabecera> comprobantesVentaCabeceraList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clientes idCliente;
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vendedores idVendedor;

    public PedidosCabecera() {
    }

    public PedidosCabecera(Integer id) {
        this.id = id;
    }

    public PedidosCabecera(Integer id, double importe, double latitud, double longitud, String estado, Date fechaPedido) {
        this.id = id;
        this.importe = importe;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estado = estado;
        this.fechaPedido = fechaPedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
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
    public List<PedidosDetalle> getPedidosDetalleList() {
        if (pedidosDetalleList == null) {
            pedidosDetalleList = new ArrayList<>();
        }
        return pedidosDetalleList;
    }

    public void setPedidosDetalleList(List<PedidosDetalle> pedidosDetalleList) {
        this.pedidosDetalleList = pedidosDetalleList;
    }

    @XmlTransient
    public List<ComprobantesVentaCabecera> getComprobantesVentaCabeceraList() {
        return comprobantesVentaCabeceraList;
    }

    public void setComprobantesVentaCabeceraList(List<ComprobantesVentaCabecera> comprobantesVentaCabeceraList) {
        this.comprobantesVentaCabeceraList = comprobantesVentaCabeceraList;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Vendedores getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Vendedores idVendedor) {
        this.idVendedor = idVendedor;
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
        if (!(object instanceof PedidosCabecera)) {
            return false;
        }
        PedidosCabecera other = (PedidosCabecera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PedidosCabecera[ id=" + id + " ]";
    }

}
