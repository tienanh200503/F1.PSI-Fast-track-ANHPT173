package com.tienanh.anhpt173.employee.repository;

import com.tienanh.anhpt173.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
