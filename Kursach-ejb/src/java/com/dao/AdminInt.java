/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Material;
import com.model.Optovik;
import com.model.Worker;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author НР
 */
@Local
public interface AdminInt {
    boolean createMaterial(Material material);
    boolean createOptovik(Optovik optovik);
    boolean createStorekeeper(Worker worker);
    boolean updateMaterial(Material material);

    boolean updateWorker(Worker worker);

    boolean updateOptovik(Optovik optovik);

    List<Material> selectMaterials();

    List<Material> selectMaterial(int id_material);

    List<Optovik> selectOptoviks();

    List<Optovik> selectOptovik(int id_opt);

    List<Worker> selectWorkers();

    List<Worker> selectWorker(int id_worker);
    boolean deleteMaterial(int id_material);
    boolean deleteOptovik(int id_optovik);
    boolean deleteStorekeeper(int id_worker);
}
