/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package request;

/**
 *
 * @author Diego
 */
public class VendedorRequest {

    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "VendedorRequest{" + "usuario=" + usuario + '}';
    }
    
    
}
