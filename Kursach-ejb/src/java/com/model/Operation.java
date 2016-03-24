
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;

/**
 *
 * @author НР
 */
public class Operation implements Serializable{

    private int id_operation;
    private String type;
    private int numberInvoice;
    private int cost;
    private int id_worker;

    public Operation() {
    }

    public Operation(int id_operation, String type, int numberInvoice, int cost, int id_worker) {
        this.id_operation = id_operation;
        this.type = type;
        this.numberInvoice = numberInvoice;
        this.cost = cost;
        this.id_worker = id_worker;
    }

    public int getId_operation() {
        return id_operation;
    }

    public void setId_operation(int id_operation) {
        this.id_operation = id_operation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberInvoice() {
        return numberInvoice;
    }

    public void setNumberInvoice(int numberInvoice) {
        this.numberInvoice = numberInvoice;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getId_worker() {
        return id_worker;
    }

    public void setId_worker(int id_worker) {
        this.id_worker = id_worker;
    }
}
