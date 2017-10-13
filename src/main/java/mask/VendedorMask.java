/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mask;

/**
 *
 * @author Diego
 */
public class VendedorMask {

    private Integer id;
    private String nombre;
    private String apellido;
    private String cedula;
    private Boolean activo;
    private Boolean android;
    private String telefonoContacto;
    private Integer idCircuito;

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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getAndroid() {
        return android;
    }

    public void setAndroid(Boolean android) {
        this.android = android;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public Integer getIdCircuito() {
        return idCircuito;
    }

    public void setIdCircuito(Integer idCircuito) {
        this.idCircuito = idCircuito;
    }

}
