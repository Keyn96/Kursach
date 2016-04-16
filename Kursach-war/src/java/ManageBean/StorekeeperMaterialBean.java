/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

//import com.dao.StorekeeperDAO;
//import com.model.*;
import com.dao.StorekeeperInt;
import com.model.Material;
import com.model.Operation;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author НР
 */
@Named(value="storekeeperMaterialBean")
@RequestScoped
public class StorekeeperMaterialBean implements Serializable{

    @EJB
          private  StorekeeperInt sda;

    /**
     * Creates a new instance of StorekeeperMaterialBean
     */
    public StorekeeperMaterialBean() {
        m = new Material();
       op = new Operation();
    }
    private int[] mat;

    public int[] getMat() {
        return mat;
    }

    public void setMat(int[] mat) {
        this.mat = mat;
    }

    private Material m;

    public Material getM() {
        return m;
   }

   public void setM(Material m) {
       this.m = m;
   }
    private int id_material;

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }
    private Operation op;

    public Operation getOp() {
      return op;
    }

    public void setOp(Operation op) {
        this.op = op;
    }
   

    public List<Material> selectMaterials() {
        return sda.selectMaterials();
    }

    public String viewSelectMaterial(int id_material) {
        this.id_material = id_material;
        return "/StorekeeperEditMaterial.xhtml";
    }

    public Material selectMaterial(int id_material) {
        return sda.selectMaterial(id_material);
    }

    public String updateMaterial() throws SQLException {
        sda.updateMaterial(m);
            return "/StorekeeperSelectMaterial.xhtml";
        
    }

    public String insertOperation() throws SQLException {
        sda.createOperation(op, mat);
            return "/HomeStorekeeper.xhtml";
        
    }

}
