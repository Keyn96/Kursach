/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.ejb.Local;
import modelDB1.Material;
import modelDB1.Operation;
import modelDB1.Worker;

/**
 *
 * @author НР
 */
@Local
public interface StorekeeperInt {
    void createOperation(Operation operation, int[] materials);
    void updateMaterial(Material material);
    List<Material> selectMaterials();
    Material selectMaterial(int idMaterial);
    Worker selectWorker(int idWorker);
    
}
