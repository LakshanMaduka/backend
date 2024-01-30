package com.example.backend2.repo;

import com.example.backend2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployRepo extends JpaRepository<Employee,Integer> {
}
