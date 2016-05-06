/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelDB1.Material;
import modelDB1.Operation;
import modelDB2.Materialorder;
import modelDB2.Orders;

/**
 *
 * @author НР
 */
@Stateless
public class Head implements HeadInt{

    @PersistenceContext(unitName = "KP_v2-ejbPU")
    private EntityManager em;
    @PersistenceContext(unitName = "KP_v2-ejbPU2")
    private EntityManager em1;
    
    private Dao dao;
    
    public void initial()
    {
    dao=new Dao(em,em1);
    }

    @Override
    public List<Operation> selectOperations() {
        initial();
        return dao.selectOperations();
    }

    @Override
    public Operation selectOperation(int id_operation) {
        initial();
        return dao.selectOperation(id_operation);
    }

    @Override
    public List<Orders> selectOrders() {
        initial();
        return dao.selectOrders();
    }

    @Override
    public Orders selectOrder(int id_order) {
        initial();
        return dao.selectOrder(id_order);
    }

    @Override
    public void updateOrder(Orders order) {
        initial();
        dao.updateOrder(order);
    }

    @Override
    public List<Material> selectOperation_Material(int id_operation) {
        initial();
        Operation oper=dao.selectOperation(id_operation);
        List<Material> mats=(List<Material>)oper.getMaterialCollection();
        return mats;
    }

    @Override
    public List<Materialorder> selectOrder_Material(int id_order ) {
        initial();
        Orders ord=dao.selectOrder(id_order);
        List<Materialorder> mats=(List<Materialorder>)ord.getMaterialorderCollection();
        return mats;
    }
    @Override
    public void insertOrder(Orders order)
    {
        initial();
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
