/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findById", query = "SELECT p FROM Productos p WHERE p.id = :id")
    , @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Productos.findByCodigoBarra", query = "SELECT p FROM Productos p WHERE p.codigoBarra = :codigoBarra")
    , @NamedQuery(name = "Productos.findByActivo", query = "SELECT p FROM Productos p WHERE p.activo = :activo")
    , @NamedQuery(name = "Productos.findByPrecioVenta", query = "SELECT p FROM Productos p WHERE p.precioVenta = :precioVenta")
    , @NamedQuery(name = "Productos.findByPrecioCosto", query = "SELECT p FROM Productos p WHERE p.precioCosto = :precioCosto")
    , @NamedQuery(name = "Productos.findByFotoUrl", query = "SELECT p FROM Productos p WHERE p.fotoUrl = :fotoUrl")
    , @NamedQuery(name = "Productos.findByTieneFoto", query = "SELECT p FROM Productos p WHERE p.tieneFoto = :tieneFoto")
    , @NamedQuery(name = "Productos.findByFechaCreacion", query = "SELECT p FROM Productos p WHERE p.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Productos.findByFechaActualizacion", query = "SELECT p FROM Productos p WHERE p.fechaActualizacion = :fechaActualizacion")})
public class Productos implements Serializable {

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
    @Size(min = 1, max = 100)
    @Column(name = "codigo_barra")
    private String codigoBarra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private double precioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_costo")
    private double precioCosto;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Size(max = 2147483647)
    @Column(name = "foto_url")
    private String fotoUrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiene_foto")
    private boolean tieneFoto;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    //OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    //private List<Stock> stockList;
    @JoinColumn(name = "id_producto_familia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductoFamilias idProductoFamilia;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proveedores idProveedor;
    @JoinColumn(name = "id_tipo_impuesto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoImpuestos idTipoImpuesto;
    @OneToOne(mappedBy = "stock", cascade=CascadeType.REMOVE)
    private Stock stock;

    public Productos() {
    }

    public Productos(Integer id) {
        this.id = id;
    }

    public Productos(Integer id, String descripcion, String codigoBarra, boolean activo, double precioVenta, double precioCosto, boolean tieneFoto) {
        this.id = id;
        this.descripcion = descripcion;
        this.codigoBarra = codigoBarra;
        this.activo = activo;
        this.precioVenta = precioVenta;
        this.precioCosto = precioCosto;
        this.tieneFoto = tieneFoto;
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

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public boolean getTieneFoto() {
        return tieneFoto;
    }

    public void setTieneFoto(boolean tieneFoto) {
        this.tieneFoto = tieneFoto;
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

   /* @XmlTransient
    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }*/

    public ProductoFamilias getIdProductoFamilia() {
        return idProductoFamilia;
    }

    public void setIdProductoFamilia(ProductoFamilias idProductoFamilia) {
        this.idProductoFamilia = idProductoFamilia;
    }

    public Proveedores getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedores idProveedor) {
        this.idProveedor = idProveedor;
    }

    public TipoImpuestos getIdTipoImpuesto() {
        return idTipoImpuesto;
    }

    public void setIdTipoImpuesto(TipoImpuestos idTipoImpuesto) {
        this.idTipoImpuesto = idTipoImpuesto;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
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
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Productos[ id=" + id + " ]";
    }

}
