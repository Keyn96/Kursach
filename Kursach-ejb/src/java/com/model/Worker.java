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
public class Worker implements Serializable{

    private int id_worker;
    private String fio;
    private int work_exp;
    private int salary;
    private String login;
    private String password;
    private String position;

    public Worker() {

    }

    public Worker(int id_worker, String fio, int work_exp, int salary, String login, String password, String position) {
        this.id_worker = id_worker;
        this.fio = fio;
        this.work_exp = work_exp;
        this.salary = salary;
        this.login = login;
        this.password = password;
        this.position = position;
    }

    public int getId_worker() {
        return id_worker;
    }

    public void setId_worker(int id_worker) {
        this.id_worker = id_worker;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getWork_exp() {
        return work_exp;
    }

    public void setWork_exp(int work_exp) {
        this.work_exp = work_exp;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
