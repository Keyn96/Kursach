/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Material;
import com.model.Operation;
import com.modelDB2.Materialorder;
import com.modelDB2.Orders;
import java.util.List;
import javax.ejb.Local;

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
