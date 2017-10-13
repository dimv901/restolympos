/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;

import java.util.List;
import mask.VendedorMask;

/**
 *
 * @author Diego
 */
public class VendedorResponse {

    private int status;
    private String message;
    private VendedorMask item;
    private List<VendedorMask> list;


    public VendedorResponse() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

   
    public VendedorMask getItem() {
        return item;
    }

    public void setItem(VendedorMask item) {
        this.item = item;
    }

    public List<VendedorMask> getList() {
        return list;
    }

    public void setList(List<VendedorMask> list) {
        this.list = list;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
