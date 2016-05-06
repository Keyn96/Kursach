/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelDB1.Material;
import modelDB1.Operation;
import modelDB2.Materialorder;
import modelDB2.Orders;

/**
 *
 * @author НР
 */
@Local
public interface HeadInt {
    List<Operation> selectOperations();
    Operation selectOperation(int id_operation);
    List<Orders> selectOrders();
    Orders selectOrder(int id_order);
    void updateOrder(Orders order);
    List<Material> selectOperation_Material(int id_operation);
    List<Materialorder> selectOrder_Material(int id_order);
    void insertOrder(Orders order);
}
