package com.jspiders.manytoonebi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jspiders.manytoonebi.dto.EmployeeDTO;

import java.util.List;

public class EmployeeDAO4 {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static EntityTransaction entityTransaction;

    public static void main(String[] args) {
        openConnection();

        // Display all employees
        displayEmployees();

        closeConnection();
    }

    private static void displayEmployees() {
        entityTransaction.begin();

        // Create a query to fetch all employees
        TypedQuery<EmployeeDTO> query = entityManager.createQuery("SELECT e FROM EmployeeDTO e", EmployeeDTO.class);

        // Execute the query to get the list of employees
        List<EmployeeDTO> employees = query.getResultList();

        // Print the details of each employee
        for (EmployeeDTO employee : employees) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("Employee Email: " + employee.getEmail());
            System.out.println("Employee Mobile: " + employee.getMobile());
            System.out.println("Employee Company Name: " + employee.getCompany().getName());
            System.out.println("---------------------------------------");
        }

        entityTransaction.commit();
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
