/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author НР
 */
public class Order implements Serializable{

    private int id_order;
    private Date data_create;
    private int id_worker;
    private String status;

    public Order() {
    }

    public Order(int id_order, Date data_create, int id_worker, String status) {
        this.id_order = id_order;
        this.data_create = data_create;
        this.id_worker = id_worker;
        this.status = status;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public Date getData_create() {
        return data_create;
    }

    public void setData_create(Date data_create) {
        this.data_create = data_create;
    }

    public int getId_worker() {
        return id_worker;
    }

    public void setId_worker(int id_worker) {
        this.id_worker = id_worker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
