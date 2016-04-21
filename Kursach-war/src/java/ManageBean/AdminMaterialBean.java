/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import com.dao.AdminInt;
import com.model.Material;
import com.modelDB2.Supplier;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author НР
 */
@Named(value="adminMaterialBean")
@RequestScoped
public class AdminMaterialBean implements Serializable{

   @EJB
          private AdminInt adm;

    /**
     * Creates a new instance of AdminMaterialBean
     */
    public AdminMaterialBean() {
        m = new Material();
    }
    private Material m;

    public Material getM() {
        return m;
    }

    public void setM(Material m) {
        this.m = m;
    }
    private int idMaterial;

    public int getId_material() {
        return idMaterial;
    }

    public void setId_material(int idMaterial) {
        this.idMaterial = idMaterial;
    }
    private int id_opt;
    private Supplier opt;

    public int getId_opt() {
        return id_opt;
    }

    public void setId_opt(int id_opt) {
        this.id_opt = id_opt;
    }

    public Supplier getOpt() {
        return opt;
    }

    public void setOpt(Supplier opt) {
        this.opt = opt;
    }
    public String insertMaterial() throws SQLException {

        adm.createMaterial(this.m);
            return "/AdminSelectMaterial.xhtml";
    }

    public String viewSelectMaterial(int idMaterial) {
        this.m = adm.selectMaterial(idMaterial);
        return "/AdminEditMaterial.xhtml";
    }

    public Material selectMaterial(int idMaterial) {
       return adm.selectMaterial(idMaterial);
    }

    public String updateMaterial() throws SQLException {
        adm.updateMaterial(getM(),getId_material()); 
            return "/AdminSelectMaterial.xhtml";
        
    }

    public String deleteMaterial(int idMaterial) {
       adm.deleteMaterial(idMaterial);
            return "/AdminSelectMaterial.xhtml";
        
    }
    public String createOpt() throws SQLException {

        adm.createSupplier(opt);
            return "/AdminSelectOptovik.xhtml";
        
    }
    public String selectOpt(int id) {
        this.id_opt = id_opt;
        return "/AdminEditOptovik.xhtml";
    }

    public Supplier selectOptt(int id) {
       return adm.selectSupplier(id);
    }

    public String updateOpt() throws SQLException {
        adm.updateSupplier(opt);
            return "/AdminSelectOptovik.xhtml";
        
    }
    public String deleteOpt(int id) {
       adm.deleteSupplier(id);
            return "/AdminSelectOptovik.xhtml";
        
    }
    
    public List<Supplier> selectOpts() {
        return adm.selectSuppliers();
    }
}
