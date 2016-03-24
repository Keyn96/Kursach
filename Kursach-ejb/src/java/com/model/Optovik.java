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
public class Optovik implements Serializable{
    private int id_opt;
    private String name;
    private int telephoneNumber;

    public int getId_opt() {
        return id_opt;
    }

    public void setId_opt(int id_opt) {
        this.id_opt = id_opt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
