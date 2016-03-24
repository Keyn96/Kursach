/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Material;
import com.model.Operation;
import com.model.Order;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author НР
 */
@Local
public interface HeadInt {
    List<Operation> selectOperations();
    List<Operation> selectOperation(int id_operation);
    List<Order> selectOrders();
    List<Order> selectOrder(int id_order);
    boolean updateOrder(Order order);
    List<Material> selectOperation_Material(int id_operation);
    List<Material> selectOrder_Material(int id_order);
}
