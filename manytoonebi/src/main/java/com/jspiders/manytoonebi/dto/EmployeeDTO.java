package com.jspiders.manytoonebi.dto;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class EmployeeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String email;
    private long mobile;
    
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyDTO company;

}
