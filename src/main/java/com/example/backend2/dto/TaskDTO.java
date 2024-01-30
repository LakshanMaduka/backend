package com.example.backend2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDTO {
    private int taskId;
    private String task;
    private String createdDate;
    private String dueDate;
    private String state;
    private String empId;
}
