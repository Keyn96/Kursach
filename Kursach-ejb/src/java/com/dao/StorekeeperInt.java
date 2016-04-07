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
    void createOperation(Operation operation, int[] materials);
    void updateMaterial(Material material);
    List<Material> selectMaterials();
    Material selectMaterial(int id_material);
    
}
