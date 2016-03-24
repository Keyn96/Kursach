/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

//import com.dao.*;
//import com.model.*;
import com.dao.HeadInt;
import com.model.Operation;
import com.model.Order;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author НР
 */
@Named(value="headSelectBean")

public class HeadSelectBean implements Serializable{

   @EJB
           private  HeadInt hdm;

    /**
     * Creates a new instance of HeadSelectBean
     */
    public HeadSelectBean() {
    }

    public List<Order> selectOrders() {
        return hdm.selectOrders();
    }

    public List<Operation> selectOperations() {
        return hdm.selectOperations();
    }

}
