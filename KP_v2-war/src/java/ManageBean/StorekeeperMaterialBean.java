/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

//import com.dao.StorekeeperDAO;
//import com.model.*;
import DAO.StorekeeperInt;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import modelDB1.Material;
import modelDB1.Operation;
import modelDB1.Worker;

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
    private int idWorker;

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
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
    private int idMaterial;

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
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

    public String viewSelectMaterial(int idMaterial) {
        this.m = selectMaterial(idMaterial);
        return "/StorekeeperEditMaterial.xhtml";
    }

    public Material selectMaterial(int idMaterial) {
        return sda.selectMaterial(idMaterial);
    }

    public String updateMaterial() throws SQLException {
        sda.updateMaterial(m);
            return "/StorekeeperSelectMaterial.xhtml";
        
    }

    public String insertOperation() throws SQLException {
        op.setIdWorker(selectStorekeeper(idWorker));
        sda.createOperation(op, mat);
            return "/HomeStorekeeper.xhtml";
        
    }
    public Worker selectStorekeeper(int idWorker) {
        return sda.selectWorker(idWorker);
    }
}
