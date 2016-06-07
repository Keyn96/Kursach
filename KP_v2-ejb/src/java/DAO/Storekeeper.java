/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelDB1.Material;
import modelDB1.Operation;
import modelDB1.Worker;
import modelDB2.Materialorder;
import modelDB2.Orders;

/**
 *
 * @author НР
 */
@Stateless
public class Storekeeper implements StorekeeperInt{
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
    public void createOperation(Operation operation, int[] materials) {
        initial();
        Operation oper=dao.createOperation(operation);
        List<Material> opers=(List<Material>)oper.getMaterialCollection();
        for(int i:materials)
        {
            Material material=dao.selectMaterial(i);
            opers.add(material);
        }
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateMaterial(Material material) {
        initial();
        if(material.getQuantity()<100)
        {
            Orders o=new Orders();
             List<Orders> or=dao.selectOrders();
             for(Orders ord:or)
             {
                 if(ord.getStatus()=="Не просмотрен")
                 {
                     o=ord;
                 }
             }
             o=dao.selectOrder(2);
             if(o.getIdOrder()==null){
             o.setIdSupplier(dao.selectSupplier(2));
             Date d=new Date(System.currentTimeMillis());
             o.setDateCreate(d);
             o.setStatus("Не просмотрен");
             dao.createOrder(o);
             o=dao.selectOrderDate(d);
             }
             Materialorder mr=new Materialorder();
               mr=dao.selectMaterialorder(material.getName());
               List<Orders> orders=(List<Orders>)mr.getOrdersCollection();
               orders.add(o);
               mr.setOrdersCollection(orders);
        }
        material.setQuantity(material.getQuantity()+150000);
        dao.updateMaterial(material);
    }

    @Override
    public List<Material> selectMaterials() {
        initial();
        return dao.selectMaterials();
    }

    @Override
    public Material selectMaterial(int id_material) {
        initial();
        return dao.selectMaterial(id_material);
    }
    @Override
    public Worker selectWorker(int idWorker) {
        initial();
        return dao.selectWorker(idWorker);
    }
}
