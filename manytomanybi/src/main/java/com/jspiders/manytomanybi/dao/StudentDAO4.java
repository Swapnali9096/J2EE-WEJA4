package com.jspiders.manytomanybi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jspiders.manytomanybi.dto.CourseDTO;
import com.jspiders.manytomanybi.dto.StudentDTO;

public class StudentDAO4 {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        openConnection();

        displayAllRecords();

        closeConnection();
    }

    private static void displayAllRecords() {
        TypedQuery<StudentDTO> query = entityManager.createQuery("SELECT s FROM StudentDTO s", StudentDTO.class);
        List<StudentDTO> students = query.getResultList();

        for (StudentDTO student : students) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Mobile: " + student.getMobile());

            List<CourseDTO> courses = student.getCourses();
            for (CourseDTO course : courses) {
                System.out.println("Course Name: " + course.getName());
                System.out.println("Fees: " + course.getFees());
            }

            System.out.println("---------------------");
        }
    }

    private static void openConnection() {
        entityManagerFactory = Persistence.createEntityManagerFactory("student");
        entityManager = entityManagerFactory.createEntityManager();
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
