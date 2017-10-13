/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "usuarios_web")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosWeb.findAll", query = "SELECT u FROM UsuariosWeb u")
    , @NamedQuery(name = "UsuariosWeb.findById", query = "SELECT u FROM UsuariosWeb u WHERE u.id = :id")
    , @NamedQuery(name = "UsuariosWeb.findByDescripcion", query = "SELECT u FROM UsuariosWeb u WHERE u.descripcion = :descripcion")
    , @NamedQuery(name = "UsuariosWeb.findByUsuario", query = "SELECT u FROM UsuariosWeb u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "UsuariosWeb.findByPassword", query = "SELECT u FROM UsuariosWeb u WHERE u.password = :password")
    , @NamedQuery(name = "UsuariosWeb.findByEmail", query = "SELECT u FROM UsuariosWeb u WHERE u.email = :email")
    , @NamedQuery(name = "UsuariosWeb.findByActivo", query = "SELECT u FROM UsuariosWeb u WHERE u.activo = :activo")
    , @NamedQuery(name = "UsuariosWeb.findByResetPassword", query = "SELECT u FROM UsuariosWeb u WHERE u.resetPassword = :resetPassword")
    , @NamedQuery(name = "UsuariosWeb.findByFechaCreacion", query = "SELECT u FROM UsuariosWeb u WHERE u.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "UsuariosWeb.findByFechaActualizacion", query = "SELECT u FROM UsuariosWeb u WHERE u.fechaActualizacion = :fechaActualizacion")})
public class UsuariosWeb implements Serializable {

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
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reset_password")
    private boolean resetPassword;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    public UsuariosWeb() {
    }

    public UsuariosWeb(Integer id) {
        this.id = id;
    }

    public UsuariosWeb(Integer id, String descripcion, String usuario, String password, String email, boolean activo, boolean resetPassword) {
        this.id = id;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
        this.activo = activo;
        this.resetPassword = resetPassword;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getResetPassword() {
        return resetPassword;
    }

    public void setResetPassword(boolean resetPassword) {
        this.resetPassword = resetPassword;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosWeb)) {
            return false;
        }
        UsuariosWeb other = (UsuariosWeb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UsuariosWeb[ id=" + id + " ]";
    }
    
}
