/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;

import entities.Clientes;
import java.util.ArrayList;
import java.util.List;
import mask.ClienteMask;

/**
 *
 * @author Diego
 */
public class ClientesResponse {

    private int status;
    private String message;
    private ClienteMask item;
    private List<ClienteMask> list;

    public ClientesResponse() {
    }

    
    
    public ClientesResponse(int status, String message, ClienteMask item, List<ClienteMask> list) {
        this.status = status;
        this.message = message;
        this.item = item;
        this.list = list;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ClienteMask getItem() {
        return item;
    }

    public void setItem(ClienteMask item) {
        this.item = item;
    }

    public List<ClienteMask> getList() {
        if (list==null){
            list = new ArrayList<>();
        }
        return list;
    }

    public void setList(List<ClienteMask> list) {
        this.list = list;
    }
    
    
    
}
