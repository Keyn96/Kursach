/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import com.dao.AdminInt;
import com.model.Material;
import com.model.Optovik;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author НР
 */
@Named(value="adminMaterialBean")

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
    private int id_material;

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }
    private int id_opt;
    private Optovik opt;

    public int getId_opt() {
        return id_opt;
    }

    public void setId_opt(int id_opt) {
        this.id_opt = id_opt;
    }

    public Optovik getOpt() {
        return opt;
    }

    public void setOpt(Optovik opt) {
        this.opt = opt;
    }
    public String insertMaterial() throws SQLException {

        if (adm.createMaterial(this.m)) {
            return "/AdminSelectMaterial.xhtml";
        } else {
            return "/Error.xhtml";
        }
    }

    public String viewSelectMaterial(int id_material) {
        this.id_material = id_material;
        return "/AdminEditMaterial.xhtml";
    }

    public List<Material> selectMaterial(int id_material) {
       return adm.selectMaterial(id_material);
    }

    public String updateMaterial() throws SQLException {
        if (adm.updateMaterial(m)) {
            return "/AdminSelectMaterial.xhtml";
        } else {
            return "/Error.xhtml";
        }
    }

    public String deleteMaterial(int id_material) {
       if (adm.deleteMaterial(id_material)) {
            return "/AdminSelectMaterial.xhtml";
        } else {
          return "/Error.xhtml";
       }
    }
    public String createOpt() throws SQLException {

        if (adm.createOptovik(opt)) {
            return "/AdminSelectOptovik.xhtml";
        } else {
            return "/Error.xhtml";
        }
    }
    public String selectOpt(int id_opt) {
        this.id_opt = id_opt;
        return "/AdminEditOptovik.xhtml";
    }

    public List<Optovik> selectOptt(int id_opt) {
       return adm.selectOptovik(id_opt);
    }

    public String updateOpt() throws SQLException {
        if (adm.updateOptovik(opt)) {
            return "/AdminSelectOptovik.xhtml";
        } else {
            return "/Error.xhtml";
       }
    }
    public String deleteOpt(int id_opt) {
       if (adm.deleteOptovik(id_material)) {
            return "/AdminSelectOptovik.xhtml";
        } else {
           return "/Error.xhtml";
       }
    }
    
    public List<Optovik> selectOpts() {
        return adm.selectOptoviks();
    }
}
