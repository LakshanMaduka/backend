package com.example.backend2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity

@Data
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int empId;
    private String name;
    private String role;
    private String email;
    private String password;


}
