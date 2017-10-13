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
@Table(name = "vendedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedores.findAll", query = "SELECT v FROM Vendedores v")
    , @NamedQuery(name = "Vendedores.findById", query = "SELECT v FROM Vendedores v WHERE v.id = :id")
    , @NamedQuery(name = "Vendedores.findByNombre", query = "SELECT v FROM Vendedores v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "Vendedores.findByApellido", query = "SELECT v FROM Vendedores v WHERE v.apellido = :apellido")
    , @NamedQuery(name = "Vendedores.findByCedula", query = "SELECT v FROM Vendedores v WHERE v.cedula = :cedula")
    , @NamedQuery(name = "Vendedores.findByActivo", query = "SELECT v FROM Vendedores v WHERE v.activo = :activo")
    , @NamedQuery(name = "Vendedores.findByAndroid", query = "SELECT v FROM Vendedores v WHERE v.android = :android")
    , @NamedQuery(name = "Vendedores.findByTelefonoContacto", query = "SELECT v FROM Vendedores v WHERE v.telefonoContacto = :telefonoContacto")
    , @NamedQuery(name = "Vendedores.findByFechaCreacion", query = "SELECT v FROM Vendedores v WHERE v.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Vendedores.findByFechaActualizacion", query = "SELECT v FROM Vendedores v WHERE v.fechaActualizacion = :fechaActualizacion")})
public class Vendedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "android")
    private boolean android;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "telefono_contacto")
    private String telefonoContacto;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @JoinColumn(name = "id_circuito", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Circuitos idCircuito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVendedor")
    private List<PedidosCabecera> pedidosCabeceraList;

    public Vendedores() {
    }

    public Vendedores(Integer id) {
        this.id = id;
    }

    public Vendedores(Integer id, String nombre, String apellido, String cedula, boolean activo, boolean android, String telefonoContacto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.activo = activo;
        this.android = android;
        this.telefonoContacto = telefonoContacto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getAndroid() {
        return android;
    }

    public void setAndroid(boolean android) {
        this.android = android;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
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

    public Circuitos getIdCircuito() {
        return idCircuito;
    }

    public void setIdCircuito(Circuitos idCircuito) {
        this.idCircuito = idCircuito;
    }

    @XmlTransient
    public List<PedidosCabecera> getPedidosCabeceraList() {
        return pedidosCabeceraList;
    }

    public void setPedidosCabeceraList(List<PedidosCabecera> pedidosCabeceraList) {
        this.pedidosCabeceraList = pedidosCabeceraList;
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
        if (!(object instanceof Vendedores)) {
            return false;
        }
        Vendedores other = (Vendedores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Vendedores[ id=" + id + " ]";
    }
    
}
