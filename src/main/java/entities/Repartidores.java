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
@Table(name = "repartidores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repartidores.findAll", query = "SELECT r FROM Repartidores r")
    , @NamedQuery(name = "Repartidores.findById", query = "SELECT r FROM Repartidores r WHERE r.id = :id")
    , @NamedQuery(name = "Repartidores.findByNombre", query = "SELECT r FROM Repartidores r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Repartidores.findByApellido", query = "SELECT r FROM Repartidores r WHERE r.apellido = :apellido")
    , @NamedQuery(name = "Repartidores.findByCedula", query = "SELECT r FROM Repartidores r WHERE r.cedula = :cedula")
    , @NamedQuery(name = "Repartidores.findByActivo", query = "SELECT r FROM Repartidores r WHERE r.activo = :activo")
    , @NamedQuery(name = "Repartidores.findByFechaCreacion", query = "SELECT r FROM Repartidores r WHERE r.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Repartidores.findByFechaActualizacion", query = "SELECT r FROM Repartidores r WHERE r.fechaActualizacion = :fechaActualizacion")})
public class Repartidores implements Serializable {

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
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRepartidor")
    private List<Repartos> repartosList;
    @JoinColumn(name = "id_movil", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Moviles idMovil;

    public Repartidores() {
    }

    public Repartidores(Integer id) {
        this.id = id;
    }

    public Repartidores(Integer id, String nombre, String apellido, String cedula, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.activo = activo;
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

    public Moviles getIdMovil() {
        return idMovil;
    }

    public void setIdMovil(Moviles idMovil) {
        this.idMovil = idMovil;
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
        if (!(object instanceof Repartidores)) {
            return false;
        }
        Repartidores other = (Repartidores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Repartidores[ id=" + id + " ]";
    }
    
}
