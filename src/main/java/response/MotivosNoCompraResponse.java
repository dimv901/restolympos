/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;

import entities.MotivosNoCompra;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class MotivosNoCompraResponse {

    private int status;
    private String message;
    private MotivosNoCompra item;
    private List<MotivosNoCompra> list;

    public MotivosNoCompraResponse() {
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

    public MotivosNoCompra getItem() {
        return item;
    }

    public void setItem(MotivosNoCompra item) {
        this.item = item;
    }

    public List<MotivosNoCompra> getList() {
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

    public void setList(List<MotivosNoCompra> list) {
        this.list = list;
    }

}
