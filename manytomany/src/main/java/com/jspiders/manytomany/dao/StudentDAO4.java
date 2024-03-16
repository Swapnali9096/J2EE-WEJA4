package com.jspiders.manytomany.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

import com.jspiders.manytomany.dto.CourseDTO;
import com.jspiders.manytomany.dto.StudentDTO;

public class StudentDAO4 {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        openConnection();

        List<StudentDTO> students = getAllStudents();

        displayStudents(students);

        closeConnection();
    }

    private static void openConnection() {
        entityManagerFactory = Persistence.createEntityManagerFactory("course");
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

    private static List<StudentDTO> getAllStudents() {
        TypedQuery<StudentDTO> query = entityManager.createQuery("SELECT s FROM StudentDTO s", StudentDTO.class);
        return query.getResultList();
    }

    private static void displayStudents(List<StudentDTO> students) {
        for (StudentDTO student : students) {
            System.out.println("Student ID: " + student.getId());
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student Email: " + student.getEmail());
            System.out.println("Student Mobile: " + student.getMobile());
            System.out.println("Courses:");
            for (CourseDTO course : student.getCourses()) {
                System.out.println(" - Course ID: " + course.getId());
                System.out.println("   Course Name: " + course.getName());
                System.out.println("   Course Fees: " + course.getFees());
            }
            System.out.println();
        }
    }
}
