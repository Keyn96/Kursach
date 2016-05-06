/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDB2;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author НР
 */
@Entity
@Table(name = "materialorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materialorder.findAll", query = "SELECT m FROM Materialorder m"),
    @NamedQuery(name = "Materialorder.findByIdMaterial", query = "SELECT m FROM Materialorder m WHERE m.idMaterial = :idMaterial"),
    @NamedQuery(name = "Materialorder.findByName", query = "SELECT m FROM Materialorder m WHERE m.name = :name"),
    @NamedQuery(name = "Materialorder.findByCost", query = "SELECT m FROM Materialorder m WHERE m.cost = :cost"),
    @NamedQuery(name = "Materialorder.findByQuantity", query = "SELECT m FROM Materialorder m WHERE m.quantity = :quantity")})
public class Materialorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_material")
    private Integer idMaterial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private int cost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @JoinTable(name = "order_material", joinColumns = {
        @JoinColumn(name = "id_material", referencedColumnName = "id_material")}, inverseJoinColumns = {
        @JoinColumn(name = "id_order", referencedColumnName = "id_order")})
    @ManyToMany
    private Collection<Orders> ordersCollection;

    public Materialorder() {
    }

    public Materialorder(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Materialorder(Integer idMaterial, String name, int cost, int quantity) {
        this.idMaterial = idMaterial;
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterial != null ? idMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materialorder)) {
            return false;
        }
        Materialorder other = (Materialorder) object;
        if ((this.idMaterial == null && other.idMaterial != null) || (this.idMaterial != null && !this.idMaterial.equals(other.idMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelDB2.Materialorder[ idMaterial=" + idMaterial + " ]";
    }
    
}
