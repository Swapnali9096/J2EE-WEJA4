package com.jspiders.manytoonebi.dto;

import java.util.List;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "companies")
public class CompanyDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String location;
    
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<EmployeeDTO> employees;

}
