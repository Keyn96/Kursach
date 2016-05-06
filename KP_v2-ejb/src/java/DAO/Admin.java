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
import modelDB1.Worker;
import modelDB2.Materialorder;
import modelDB2.Supplier;

/**
 *
 * @author НР
 */
@Stateless
public class Admin implements AdminInt {
    @PersistenceContext(unitName = "KP_v2-ejbPU")
    private EntityManager em;
    @PersistenceContext(unitName = "KP_v2-ejbPU2")
    private EntityManager em1;
    
    private Dao dao;
    
    public void initial()
    {
    dao=new Dao(em,em1);
    }
    /*@EJB
    private Dao dao;*/
    @Override
    public void createMaterial(Material material) {
        initial();
        dao.createMaterial(material);
        Materialorder mat=new Materialorder();
        mat.setName(material.getName());
        mat.setCost(material.getCost());
        mat.setQuantity(10000);
        dao.flush();
        dao.createMaterialorder(mat);
    }

    @Override
    public void createSupplier(Supplier supplier) {
        initial();
        dao.createSupplier(supplier);
    }

    @Override
    public void createStorekeeper(Worker worker) {
        initial();
        dao.createWorker(worker);
    }

    @Override
    public void updateMaterial(Material material) {
        initial();
        dao.updateMaterial(material);
    }

    @Override
    public void updateWorker(Worker worker) {
        initial();
        dao.updateWorker(worker);
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
    public List<Worker> selectWorkers() throws Exception{
        initial();
        return dao.selectWorkers();
    }

    @Override
    public Worker selectWorker(int id_worker) {
        initial();
       return dao.selectWorker(id_worker);
    }

    @Override
    public void deleteMaterial(int id_material) {
        initial();
        dao.deleteMaterial(id_material);
    }

    @Override
    public void deleteStorekeeper(int id_worker) {
        initial();
        dao.deleteWorker(id_worker);
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        initial();
        dao.updateSupplier(supplier);
    }

    @Override
    public List<Supplier> selectSuppliers() {
        initial();
        return dao.selectSuppliers();
    }

    @Override
    public Supplier selectSupplier(int id_opt) {
        initial();
        return dao.selectSupplier(id_opt);
    }

    @Override
    public void deleteSupplier(int id_optovik) {
        initial();
        dao.deleteSupplier(id_optovik);
    }

}
