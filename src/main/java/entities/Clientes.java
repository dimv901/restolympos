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
import javax.persistence.Lob;
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
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findById", query = "SELECT c FROM Clientes c WHERE c.id = :id")
    , @NamedQuery(name = "Clientes.findByNombreTitular", query = "SELECT c FROM Clientes c WHERE c.nombreTitular = :nombreTitular")
    , @NamedQuery(name = "Clientes.findByCedulaTitular", query = "SELECT c FROM Clientes c WHERE c.cedulaTitular = :cedulaTitular")
    , @NamedQuery(name = "Clientes.findByContactoTitular", query = "SELECT c FROM Clientes c WHERE c.contactoTitular = :contactoTitular")
    , @NamedQuery(name = "Clientes.findByEmailTitular", query = "SELECT c FROM Clientes c WHERE c.emailTitular = :emailTitular")
    , @NamedQuery(name = "Clientes.findByRazonSocial", query = "SELECT c FROM Clientes c WHERE c.razonSocial = :razonSocial")
    , @NamedQuery(name = "Clientes.findByNombreNegocio", query = "SELECT c FROM Clientes c WHERE c.nombreNegocio = :nombreNegocio")
    , @NamedQuery(name = "Clientes.findByRuc", query = "SELECT c FROM Clientes c WHERE c.ruc = :ruc")
    , @NamedQuery(name = "Clientes.findByEmailNegocio", query = "SELECT c FROM Clientes c WHERE c.emailNegocio = :emailNegocio")
    , @NamedQuery(name = "Clientes.findByTelefonoNegocio", query = "SELECT c FROM Clientes c WHERE c.telefonoNegocio = :telefonoNegocio")
    , @NamedQuery(name = "Clientes.findByBarrio", query = "SELECT c FROM Clientes c WHERE c.barrio = :barrio")
    , @NamedQuery(name = "Clientes.findByCallePrincipal", query = "SELECT c FROM Clientes c WHERE c.callePrincipal = :callePrincipal")
    , @NamedQuery(name = "Clientes.findByCalleSecundaria", query = "SELECT c FROM Clientes c WHERE c.calleSecundaria = :calleSecundaria")
    , @NamedQuery(name = "Clientes.findByNumeroCasa", query = "SELECT c FROM Clientes c WHERE c.numeroCasa = :numeroCasa")
    , @NamedQuery(name = "Clientes.findByReferencia", query = "SELECT c FROM Clientes c WHERE c.referencia = :referencia")
    , @NamedQuery(name = "Clientes.findByGeolocalizado", query = "SELECT c FROM Clientes c WHERE c.geolocalizado = :geolocalizado")
    //, @NamedQuery(name = "Clientes.findByLatitud", query = "SELECT c FROM Clientes c WHERE c.latitud = :latitud")
    , @NamedQuery(name = "Clientes.findByLongitud", query = "SELECT c FROM Clientes c WHERE c.longitud = :longitud")
    , @NamedQuery(name = "Clientes.findByFotoUrl", query = "SELECT c FROM Clientes c WHERE c.fotoUrl = :fotoUrl")
    , @NamedQuery(name = "Clientes.findByTieneFoto", query = "SELECT c FROM Clientes c WHERE c.tieneFoto = :tieneFoto")
    , @NamedQuery(name = "Clientes.findByFechaCreacion", query = "SELECT c FROM Clientes c WHERE c.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Clientes.findByFechaActualizacion", query = "SELECT c FROM Clientes c WHERE c.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "Clientes.findByLunes", query = "SELECT c FROM Clientes c WHERE c.lunes = :lunes")
    , @NamedQuery(name = "Clientes.findByMartes", query = "SELECT c FROM Clientes c WHERE c.martes = :martes")
    , @NamedQuery(name = "Clientes.findByMiercoles", query = "SELECT c FROM Clientes c WHERE c.miercoles = :miercoles")
    , @NamedQuery(name = "Clientes.findByJueves", query = "SELECT c FROM Clientes c WHERE c.jueves = :jueves")
    , @NamedQuery(name = "Clientes.findByViernes", query = "SELECT c FROM Clientes c WHERE c.viernes = :viernes")
    , @NamedQuery(name = "Clientes.findBySabado", query = "SELECT c FROM Clientes c WHERE c.sabado = :sabado")
    , @NamedQuery(name = "Clientes.findByDomingo", query = "SELECT c FROM Clientes c WHERE c.domingo = :domingo")
    , @NamedQuery(name = "Clientes.findByIdCircuito", query = "SELECT c FROM Clientes c WHERE c.idCircuito = :idCircuito")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_titular")
    private String nombreTitular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cedula_titular")
    private String cedulaTitular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "contacto_titular")
    private String contactoTitular;
    @Size(max = 100)
    @Column(name = "email_titular")
    private String emailTitular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "razon_social")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_negocio")
    private String nombreNegocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ruc")
    private String ruc;
    @Size(max = 100)
    @Column(name = "email_negocio")
    private String emailNegocio;
    @Size(max = 30)
    @Column(name = "telefono_negocio")
    private String telefonoNegocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "barrio")
    private String barrio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "calle_principal")
    private String callePrincipal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "calle_secundaria")
    private String calleSecundaria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_casa")
    private int numeroCasa;
    @Size(max = 250)
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "geolocalizado")
    private Boolean geolocalizado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitud")
    private Double latitud;
    @Column(name = "longitud")
    private Double longitud;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "lunes")
    private boolean lunes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "martes")
    private boolean martes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "miercoles")
    private boolean miercoles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jueves")
    private boolean jueves;
    @Basic(optional = false)
    @NotNull
    @Column(name = "viernes")
    private boolean viernes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sabado")
    private boolean sabado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "domingo")
    private boolean domingo;
    
    @JoinColumn(name = "id_circuito", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Circuitos idCircuito;
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ciudades idCiudad;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Departamentos idDepartamento;
    @JoinColumn(name = "id_forma_pago", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FormasPago idFormaPago;
 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<Visitas> visitasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<ComprobantesVentaCabecera> comprobantesVentaCabeceraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<PedidosCabecera> pedidosCabeceraList;
    @Column(name = "hora_visita")
    @Temporal(TemporalType.TIME)
    private Date horaVisita;
    
    public Clientes() {
    }

    public Clientes(Integer id) {
        this.id = id;
    }

    public Clientes(Integer id, String nombreTitular, String cedulaTitular, String contactoTitular, String razonSocial, String nombreNegocio, String ruc, String barrio, String callePrincipal, String calleSecundaria, int numeroCasa, boolean tieneFoto, boolean lunes, boolean martes, boolean miercoles, boolean jueves, boolean viernes, boolean sabado, boolean domingo) {
        this.id = id;
        this.nombreTitular = nombreTitular;
        this.cedulaTitular = cedulaTitular;
        this.contactoTitular = contactoTitular;
        this.razonSocial = razonSocial;
        this.nombreNegocio = nombreNegocio;
        this.ruc = ruc;
        this.barrio = barrio;
        this.callePrincipal = callePrincipal;
        this.calleSecundaria = calleSecundaria;
        this.numeroCasa = numeroCasa;
        this.tieneFoto = tieneFoto;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getCedulaTitular() {
        return cedulaTitular;
    }

    public void setCedulaTitular(String cedulaTitular) {
        this.cedulaTitular = cedulaTitular;
    }

    public String getContactoTitular() {
        return contactoTitular;
    }

    public void setContactoTitular(String contactoTitular) {
        this.contactoTitular = contactoTitular;
    }

    public String getEmailTitular() {
        return emailTitular;
    }

    public void setEmailTitular(String emailTitular) {
        this.emailTitular = emailTitular;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEmailNegocio() {
        return emailNegocio;
    }

    public void setEmailNegocio(String emailNegocio) {
        this.emailNegocio = emailNegocio;
    }

    public String getTelefonoNegocio() {
        return telefonoNegocio;
    }

    public void setTelefonoNegocio(String telefonoNegocio) {
        this.telefonoNegocio = telefonoNegocio;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Boolean getGeolocalizado() {
        return geolocalizado;
    }

    public void setGeolocalizado(Boolean geolocalizado) {
        this.geolocalizado = geolocalizado;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }



    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
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

    public boolean getLunes() {
        return lunes;
    }

    public void setLunes(boolean lunes) {
        this.lunes = lunes;
    }

    public boolean getMartes() {
        return martes;
    }

    public void setMartes(boolean martes) {
        this.martes = martes;
    }

    public boolean getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(boolean miercoles) {
        this.miercoles = miercoles;
    }

    public boolean getJueves() {
        return jueves;
    }

    public void setJueves(boolean jueves) {
        this.jueves = jueves;
    }

    public boolean getViernes() {
        return viernes;
    }

    public void setViernes(boolean viernes) {
        this.viernes = viernes;
    }

    public boolean getSabado() {
        return sabado;
    }

    public void setSabado(boolean sabado) {
        this.sabado = sabado;
    }

    public boolean getDomingo() {
        return domingo;
    }

    public void setDomingo(boolean domingo) {
        this.domingo = domingo;
    }

    public Circuitos getIdCircuito() {
        return idCircuito;
    }

    public void setIdCircuito(Circuitos idCircuito) {
        this.idCircuito = idCircuito;
    }

    public Ciudades getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudades idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Departamentos getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamentos idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public FormasPago getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(FormasPago idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    @XmlTransient
    public List<Visitas> getVisitasList() {
        return visitasList;
    }

    public void setVisitasList(List<Visitas> visitasList) {
        this.visitasList = visitasList;
    }

    @XmlTransient
    public List<ComprobantesVentaCabecera> getComprobantesVentaCabeceraList() {
        return comprobantesVentaCabeceraList;
    }

    public void setComprobantesVentaCabeceraList(List<ComprobantesVentaCabecera> comprobantesVentaCabeceraList) {
        this.comprobantesVentaCabeceraList = comprobantesVentaCabeceraList;
    }

    @XmlTransient
    public List<PedidosCabecera> getPedidosCabeceraList() {
        return pedidosCabeceraList;
    }

    public void setPedidosCabeceraList(List<PedidosCabecera> pedidosCabeceraList) {
        this.pedidosCabeceraList = pedidosCabeceraList;
    }

    public Date getHoraVisita() {
        return horaVisita;
    }

    public void setHoraVisita(Date horaVisita) {
        this.horaVisita = horaVisita;
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
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Clientes[ id=" + id + " ]";
    }

}
