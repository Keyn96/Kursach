/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

//import com.dao.*;
//import com.model.*;
import com.dao.AdminInt;
import com.model.Material;
import com.model.Worker;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author НР
 */
@Named(value="selectAdminBean")

public class SelectAdminBean implements Serializable{

   @EJB
         private  AdminInt adm;

    /**
     * Creates a new instance of SelectAdminBean
     */
    public SelectAdminBean() {
    }

    public List<Worker> selectWorkers() {
        return adm.selectWorkers();
    }

    public List<Material> selectMaterials() {
        return adm.selectMaterials();
    }

}
