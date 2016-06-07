/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;


import DAO.HeadInt;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import modelDB1.Material;
import modelDB1.Operation;

/**
 *
 * @author НР
 */
@Named(value="headOperationBean")
@RequestScoped
public class HeadOperationBean implements Serializable{
@EJB
    private HeadInt hdm;

    /**
     * Creates a new instance of HeadOperationBean
     */

    public HeadOperationBean() {
        op = new Operation();
    }
    private Operation op;

    public Operation getOp() {
        return op;
    }

    public void setOp(Operation op) {
        this.op = op;
    }
    private  int idOperation;

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public String viewSelectOperation(int idOperation) {
        this.op=hdm.selectOperation(idOperation);
        return "/HeadDetailsOperation.xhtml";
    }

    public List<Operation> selectOperations() {
        return hdm.selectOperations();
    }

    public Operation selectOperation(int idOperation) {
        return hdm.selectOperation(idOperation);
    }

    public List<Material> selectMaterial(int idOperation) {
        return hdm.selectOperation_Material(idOperation);
    }

}
