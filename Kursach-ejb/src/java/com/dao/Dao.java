/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Material;
import com.model.Operation;
import com.model.Worker;
import com.modelDB2.Materialorder;
import com.modelDB2.Orders;
import com.modelDB2.Supplier;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author НР
 */
public class Dao {
    @PersistenceContext(unitName = "LabJPA4-ejbPU2")
    private EntityManager em;
    
    
    public void createMaterial(Material material) {
        em.persist(material);
        em.flush();
    }
    public void updateMaterial(Material material) {
        em.getTransaction().begin();
        em.merge(material);
        em.getTransaction().commit();
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
        em.persist(supplier);
        em.flush();
    }
    public void updateSupplier(Supplier supplier) {
        em.getTransaction().begin();
        em.merge(supplier);
        em.getTransaction().commit();
    }
    public List<Supplier> selectSuppliers() {
         TypedQuery<Supplier> namedQuery=em.createNamedQuery("Supplier.findAll", Supplier.class);
        return namedQuery.getResultList();
    }

    public Supplier selectSupplier(int id_supplier) {
       return em.find(Supplier.class, id_supplier);
    }
    public void deleteSupplier(int id_supplier) {
        em.remove(em.getReference(Supplier.class, id_supplier));
    }
    public void createWorker(Worker worker) {
        em.persist(worker);
        em.flush();
    }
    public void updateWorker(Worker worker) {
        em.getTransaction().begin();
        em.merge(worker);
        em.getTransaction().commit();
    }
    public List<Worker> selectWorkers() {
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
       em.getTransaction().begin();
       Operation oper = em.merge(operation);
       em.getTransaction().commit();
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
         em.getTransaction().begin();
       Orders ord = em.merge(order);
       em.getTransaction().commit();
       return ord;
    }
    public void updateOrder(Orders order) {
        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
    }
    public List<Orders> selectOrders() {
         TypedQuery<Orders> namedQuery=em.createNamedQuery("Orders.findAll", Orders.class);
        return namedQuery.getResultList();
    }

    public Orders selectOrder(int id_order) {
       return em.find(Orders.class, id_order);
    }
    public void createMaterialorder(Materialorder material) {
        em.persist(material);
        em.flush();
    }
    public Materialorder selectMaterialorder(String nam) {
        Query namedQuery=em.createNamedQuery("Materialorder.findByName", Materialorder.class);
        namedQuery.setParameter("name", nam);
        return (Materialorder)namedQuery.getSingleResult();
    }
}
