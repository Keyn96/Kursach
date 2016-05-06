/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

//import com.dao.*;
//import com.model.*;
import DAO.HeadInt;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import modelDB1.Operation;
import modelDB2.Orders;

/**
 *
 * @author НР
 */
@Named(value="headSelectBean")
@RequestScoped
public class HeadSelectBean implements Serializable{

   @EJB
           private  HeadInt hdm;

    /**
     * Creates a new instance of HeadSelectBean
     */
    public HeadSelectBean() {
    }

    public List<Orders> selectOrders() {
        return hdm.selectOrders();
    }

    public List<Operation> selectOperations() {
        return hdm.selectOperations();
    }

}
