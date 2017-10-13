/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;

import entities.Departamentos;
import java.util.ArrayList;
import java.util.List;
import mask.DepartamentoMask;

/**
 *
 * @author Diego
 */
public class DepartamentosResponse {

    private int status;
    private String message;
    private DepartamentoMask item;
    private List<DepartamentoMask> list;

    public DepartamentosResponse() {
    }

    public DepartamentosResponse(int status, String message, DepartamentoMask item, List<DepartamentoMask> list) {
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

    public DepartamentoMask getItem() {
        return item;
    }

    public void setItem(DepartamentoMask item) {
        this.item = item;
    }

    public List<DepartamentoMask> getList() {
        if (list == null) {
            list = new ArrayList();
        }
        return list;
    }

    public void setList(List<DepartamentoMask> list) {
        this.list = list;
    }

}
