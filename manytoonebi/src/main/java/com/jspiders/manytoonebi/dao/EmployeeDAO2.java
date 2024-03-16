package com.jspiders.manytoonebi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoonebi.dto.EmployeeDTO;

public class EmployeeDAO2 {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static EntityTransaction entityTransaction;

    public static void main(String[] args) {
        openConnection();
        entityTransaction.begin();

        // Retrieve the employee you want to update
        EmployeeDTO employee = entityManager.find(EmployeeDTO.class, 1);

        // Modify the employee's properties
        employee.setName("Swara");
        employee.setEmail("swara@gmail.com");
        employee.setMobile(9876543211L);

        // Since the company is also updated, no need to explicitly update it
        // Because of the CascadeType.ALL, company will be updated automatically

        // Commit the transaction
        entityTransaction.commit();

        // Close the EntityManager and EntityManagerFactory
        closeConnection();
    }

    private static void openConnection() {
        entityManagerFactory = Persistence.createEntityManagerFactory("employee");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    private static void closeConnection() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
