/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Material;
import com.modelDB2.Supplier;
import com.model.Worker;
import com.modelDB2.Materialorder;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author НР
 */
@Stateless
public class Admin implements AdminInt {

    private Dao dao;
    @Override
    public void createMaterial(Material material) {
        dao.createMaterial(material);
        Materialorder mat=new Materialorder();
        mat.setName(material.getName());
        mat.setCost(material.getCost());
        mat.setQuantity(10000);
        dao.createMaterialorder(mat);
    }

    @Override
    public void createSupplier(Supplier supplier) {
        dao.createSupplier(supplier);
    }

    @Override
    public void createStorekeeper(Worker worker) {
        dao.createWorker(worker);
    }

    @Override
    public void updateMaterial(Material material) {
        dao.updateMaterial(material);
    }

    @Override
    public void updateWorker(Worker worker) {
        dao.updateWorker(worker);
    }

    @Override
    public List<Material> selectMaterials() {
        return dao.selectMaterials();
    }

    @Override
    public Material selectMaterial(int id_material) {
        return dao.selectMaterial(id_material);
    }

    @Override
    public List<Worker> selectWorkers() {
        return dao.selectWorkers();
    }

    @Override
    public Worker selectWorker(int id_worker) {
       return dao.selectWorker(id_worker);
    }

    @Override
    public void deleteMaterial(int id_material) {
        dao.deleteMaterial(id_material);
    }

    @Override
    public void deleteStorekeeper(int id_worker) {
        dao.deleteWorker(id_worker);
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        dao.updateSupplier(supplier);
    }

    @Override
    public List<Supplier> selectSuppliers() {
        return dao.selectSuppliers();
    }

    @Override
    public Supplier selectSupplier(int id_opt) {
        return dao.selectSupplier(id_opt);
    }

    @Override
    public void deleteSupplier(int id_optovik) {
        dao.deleteSupplier(id_optovik);
    }

}
