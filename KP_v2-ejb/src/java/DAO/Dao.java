/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelDB1.Material;
import modelDB1.Operation;
import modelDB1.Worker;
import modelDB2.Materialorder;
import modelDB2.Orders;
import modelDB2.Supplier;

/**
 *
 * @author НР
 */
//@Stateless
public class Dao {

    private EntityManager em;
    private EntityManager em1;
    public Dao(EntityManager em,EntityManager em1) {
    this.em=em;
    this.em1=em1;
    }
    
    /*@PersistenceContext(unitName = "Kursach_v2PU")
    private EntityManager em;
    @PersistenceContext(unitName = "Kursach_v2PU2")
    private EntityManager em1;*/
    public void flush()
    {
        em.flush();
    }
    public void createMaterial(Material material) {
        em.persist(material);
    }
    public void updateMaterial(Material material) {
        em.merge(material);
    }
    public List<Material> selectMaterials() {
         TypedQuery<Material> namedQuery=em.createNamedQuery("Material.findAll", Material.class);
        return namedQuery.getResultList();
    }

    public Material selectMaterial(int id_material) {
       return em.find(Material.class, id_material);
    }
    public void deleteMaterial(int id_material) {
        em.remove(em.getReference(Material.class, id_material));
    }
    public void createSupplier(Supplier supplier) {
        em1.persist(supplier);
        em1.flush();
    }
    public void updateSupplier(Supplier supplier) {
        em1.merge(supplier);
    }
    public List<Supplier> selectSuppliers() {
         TypedQuery<Supplier> namedQuery=em1.createNamedQuery("Supplier.findAll", Supplier.class);
        return namedQuery.getResultList();
    }

    public Supplier selectSupplier(int id_supplier) {
       return em1.find(Supplier.class, id_supplier);
    }
    public void deleteSupplier(int id_supplier) {
        em1.remove(em1.getReference(Supplier.class, id_supplier));
    }
    public void createWorker(Worker worker) {
        em.persist(worker);
        em.flush();
    }
    public void updateWorker(Worker worker) {
        em.merge(worker);
    }
    public List<Worker> selectWorkers() throws Exception {
        TypedQuery<Worker> namedQuery=em.createNamedQuery("Worker.findAll", Worker.class);
        return namedQuery.getResultList();
    }

    public Worker selectWorker(int id_worker) {
       return em.find(Worker.class, id_worker);
    }
    public void deleteWorker(int id_worker) {
        em.remove(em.getReference(Worker.class, id_worker));
    }
    public Operation createOperation(Operation operation) {
       Operation oper = em.merge(operation);
       return oper;
    }
    public List<Operation> selectOperations() {
         TypedQuery<Operation> namedQuery=em.createNamedQuery("Operation.findAll", Operation.class);
        return namedQuery.getResultList();
    }

    public Operation selectOperation(int id_operation) {
       return em.find(Operation.class, id_operation);
    }
    public Orders createOrder(Orders order) {
       Orders ord = em1.merge(order);
       return ord;
    }
    public void updateOrder(Orders order) {
        em1.merge(order);
    }
    public List<Orders> selectOrders() {
         TypedQuery<Orders> namedQuery=em1.createNamedQuery("Orders.findAll", Orders.class);
        return namedQuery.getResultList();
    }

    public Orders selectOrder(int id_order) {
       return em1.find(Orders.class, id_order);
    }
    public Orders selectOrderDate(Date date) {
       Query namedQuery=em1.createNamedQuery("Orders.findByDateCreate", Materialorder.class);
        namedQuery.setParameter("dateCreate", date);
        return (Orders)namedQuery.getSingleResult();
    }
    public void createMaterialorder(Materialorder material) {
        em1.persist(material);
        em1.flush();
    }
    public Materialorder selectMaterialorder(String nam) {
        Query namedQuery=em1.createNamedQuery("Materialorder.findByName", Materialorder.class);
        namedQuery.setParameter("name", nam);
        return (Materialorder)namedQuery.getSingleResult();
    }
}
