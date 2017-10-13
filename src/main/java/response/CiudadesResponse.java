/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;

import java.util.ArrayList;
import java.util.List;
import mask.CiudadMask;

/**
 *
 * @author Diego
 */
public class CiudadesResponse {

    private int status;
    private String message;
    private CiudadMask item;
    private List<CiudadMask> list;

    public CiudadesResponse(int status, String message, CiudadMask item, List<CiudadMask> list) {
        this.status = status;
        this.message = message;
        this.item = item;
        this.list = list;
    }

    public CiudadesResponse() {
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

    public CiudadMask getItem() {
        return item;
    }

    public void setItem(CiudadMask item) {
        this.item = item;
    }

    public List<CiudadMask> getList() {
        if (list == null) {
            list = new ArrayList();
        }
        return list;
    }

    public void setList(List<CiudadMask> list) {
        this.list = list;
    }

}
