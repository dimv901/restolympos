/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;

import java.util.ArrayList;
import java.util.List;
import mask.CircuitoMask;

/**
 *
 * @author Diego
 */
public class CircuitosResponse {

    private int status;
    private String message;
    private CircuitoMask item;
    private List<CircuitoMask> list;

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

    public CircuitoMask getItem() {
        return item;
    }

    public void setItem(CircuitoMask item) {
        this.item = item;
    }

    public List<CircuitoMask> getList() {
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

    public void setList(List<CircuitoMask> list) {
        this.list = list;
    }

}
