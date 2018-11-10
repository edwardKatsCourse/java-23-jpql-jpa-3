package com.example.jpqldemo.reposiotry;

import com.example.jpqldemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
