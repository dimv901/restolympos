/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;

import java.util.ArrayList;
import java.util.List;
import mask.ProductoMask;

/**
 *
 * @author Diego
 */
public class ProductosResponse {

    private int status;
    private String message;
    private ProductoMask item;
    private List<ProductoMask> list;

    public ProductosResponse() {
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

    public ProductoMask getItem() {
        return item;
    }

    public void setItem(ProductoMask item) {
        this.item = item;
    }

    public List<ProductoMask> getList() {
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

    public void setList(List<ProductoMask> list) {
        this.list = list;
    }

}
