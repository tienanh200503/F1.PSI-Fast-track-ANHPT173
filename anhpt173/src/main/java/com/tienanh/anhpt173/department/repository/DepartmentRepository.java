package com.tienanh.anhpt173.department.repository;

import com.tienanh.anhpt173.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
