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
import javax.ejb.Stateless;

/**
 *
 * @author НР
 */
@Stateless
public class Storekeeper implements StorekeeperInt{
private Dao dao;
    @Override
    public void createOperation(Operation operation, int[] materials) {
        Operation oper=dao.createOperation(operation);
        List<Material> opers=(List<Material>)oper.getMaterialCollection();
        for(int i:materials)
        {
            Material material=dao.selectMaterial(i);
            opers.add(material);
        }
    }

    @Override
    public void updateMaterial(Material material) {
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
             Materialorder mr=new Materialorder();
               mr=dao.selectMaterialorder(material.getName());
               List<Orders> orders=(List<Orders>)mr.getOrdersCollection();
               orders.add(o);
               mr.setOrdersCollection(orders);
        }
        material.setQuantity(material.getQuantity()+10000);
        dao.updateMaterial(material);
    }

    @Override
    public List<Material> selectMaterials() {
        return dao.selectMaterials();
    }

    @Override
    public Material selectMaterial(int id_material) {
        return dao.selectMaterial(id_material);
    }
    
}
