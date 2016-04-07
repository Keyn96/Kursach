/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Material;
import com.modelDB2.Supplier;
import com.model.Worker;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author НР
 */
@Local
public interface AdminInt {
    void createMaterial(Material material);
    void createSupplier(Supplier supplier);
    void createStorekeeper(Worker worker);
    void updateMaterial(Material material);

    void updateWorker(Worker worker);

    void updateSupplier(Supplier supplier);

    List<Material> selectMaterials();

    Material selectMaterial(int id_material);

    List<Supplier> selectSuppliers();

    Supplier selectSupplier(int id_opt);

    List<Worker> selectWorkers();

    Worker selectWorker(int id_worker);
    void deleteMaterial(int id_material);
    void deleteSupplier(int id_optovik);
    void deleteStorekeeper(int id_worker);
}
