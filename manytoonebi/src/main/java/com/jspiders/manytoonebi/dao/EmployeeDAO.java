package com.jspiders.manytoonebi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoonebi.dto.CompanyDTO;
import com.jspiders.manytoonebi.dto.EmployeeDTO;

public class EmployeeDAO {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static EntityTransaction entityTransaction;

    public static void main(String[] args) {
        openConnection();
        entityTransaction.begin();

        CompanyDTO company = new CompanyDTO();
        company.setName("Fujitsu");
        company.setLocation("Pune");

        EmployeeDTO employee = new EmployeeDTO();
        employee.setName("Ram");
        employee.setEmail("ramh@gmail.com");
        employee.setMobile(9096230441L);
        employee.setCompany(company);

        entityManager.persist(company);
        entityManager.persist(employee);

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
