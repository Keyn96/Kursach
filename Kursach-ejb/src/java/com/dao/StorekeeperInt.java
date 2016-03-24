/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Material;
import com.model.Operation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author НР
 */
@Local
public interface StorekeeperInt {
    boolean createOperation(Operation operation, int[] materials);
    boolean updateMaterial(Material material);
    List<Material> selectMaterials();
    List<Material> selectMaterial(int id_material);
    
}
