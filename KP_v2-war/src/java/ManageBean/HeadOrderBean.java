/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

//import com.dao.HeadDAO;
//import com.model.*;
import DAO.HeadInt;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import modelDB2.Materialorder;
import modelDB2.Orders;

/**
 *
 * @author НР
 */
@Named(value="headOrderBean")
@RequestScoped
public class HeadOrderBean implements Serializable{
@EJB
    private HeadInt hdm;

    /**
     * Creates a new instance of HeadOrderBean
     */
    public HeadOrderBean() {
        ord = new Orders();
    }
    private Orders ord;

    public Orders getOrd() {
        return ord;
    }

   public void setOrd(Orders ord) {
       this.ord = ord;
    }
    private  int id_order;

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public String viewSelectOrder(int id_order) {
        this.ord=selectOrder(id_order);
        return "/HeadEditOrder.xhtml";
    }

    public List<Orders> selectOrders() {
        return hdm.selectOrders();
    }

    public Orders selectOrder(int id_order) {
        return hdm.selectOrder(id_order);
    }

    public List<Materialorder> selectMaterial(int id_order) {
        return hdm.selectOrder_Material(id_order);
   }

    public String updateOrder() {
        hdm.updateOrder(ord);
            return "HeadSelectOrders.xhtml";
        
    }

}
