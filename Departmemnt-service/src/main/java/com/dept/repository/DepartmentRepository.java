package com.dept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dept.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
