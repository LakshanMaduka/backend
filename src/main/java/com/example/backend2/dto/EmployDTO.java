package com.example.backend2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployDTO {

    private int empId;
    private String name;
private String role;
    private String email;
    private String password;
}
