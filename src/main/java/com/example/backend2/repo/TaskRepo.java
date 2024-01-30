package com.example.backend2.repo;

import com.example.backend2.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task,Integer> {
@Query(value = "SELECT * FROM Task where  emp_id= ?1",nativeQuery = true)
List<Task> getTasksByEmpId(String empId);

}
