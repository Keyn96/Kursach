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
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author НР
 */
@Stateless
public class Head implements HeadInt{


    private Dao dao;
    @Override
    public List<Operation> selectOperations() {
        return dao.selectOperations();
    }

    @Override
    public Operation selectOperation(int id_operation) {
        return dao.selectOperation(id_operation);
    }

    @Override
    public List<Orders> selectOrders() {
        return dao.selectOrders();
    }

    @Override
    public Orders selectOrder(int id_order) {
        return dao.selectOrder(id_order);
    }

    @Override
    public void updateOrder(Orders order) {
        dao.updateOrder(order);
    }

    @Override
    public List<Material> selectOperation_Material(int id_operation) {
        Operation oper=dao.selectOperation(id_operation);
        List<Material> mats=(List<Material>)oper.getMaterialCollection();
        return mats;
    }

    @Override
    public List<Materialorder> selectOrder_Material(int id_order ) {
        Orders ord=dao.selectOrder(id_order);
        List<Materialorder> mats=(List<Materialorder>)ord.getMaterialorderCollection();
        return mats;
    }
    @Override
    public void insertOrder(Orders order)
    {
        Orders ord=dao.createOrder(order);
        List<Material> mat=dao.selectMaterials();
        for(Material m:mat)
        {
            if(m.getQuantity()<500)
            {
               Materialorder mr=new Materialorder();
               mr=dao.selectMaterialorder(m.getName());
               List<Orders> orders=(List<Orders>)mr.getOrdersCollection();
               orders.add(ord);
               mr.setOrdersCollection(orders);               
            }
        }
    }
}
