package com.jspiders.manytoonebi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoonebi.dto.EmployeeDTO;

public class EmployeeDAO3 {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static EntityTransaction entityTransaction;

    public static void main(String[] args) {
        openConnection();
        entityTransaction.begin();

        // Retrieve the employee you want to delete by ID
        EmployeeDTO employee = entityManager.find(EmployeeDTO.class, 1);

        // Check if the employee exists
        if (employee != null) {
            // Delete the employee
            entityManager.remove(employee);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }

        entityTransaction.commit();
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
