package com.jspiders.manytomany.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomany.dto.StudentDTO;

public class StudentDAO3 {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static EntityTransaction entityTransaction;

    public static void main(String[] args) {
        openConnection();
        entityTransaction.begin();

        // Retrieve the student you want to update
        StudentDTO student = entityManager.find(StudentDTO.class, 1);

        // Modify the student's properties
        student.setName("swara");
        student.setEmail("swara@gmail.com");

        // Update the student
        updateStudent(student);

        entityTransaction.commit();
        closeConnection();
    }

    private static void openConnection() {
        entityManagerFactory = Persistence.createEntityManagerFactory("course");
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
        if (entityTransaction != null) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
        }
    }

    private static void updateStudent(StudentDTO student) {
        // Check if the student is detached, and if so, merge it to make it managed
        if (!entityManager.contains(student)) {
            entityManager.merge(student);
        }
    }
}
