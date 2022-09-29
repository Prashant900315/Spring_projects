package com.dept.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dept.entity.Department;
import com.dept.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	DepartmentRepository deptrepository;
	
	
	public Department saveDepartment(Department dept) {
		log.info("inside save DepartmentService="+dept);
		return deptrepository.save(dept);
	}


	public Department findDepartmentById(Long deptId) {
		
		return deptrepository.findById(deptId).orElse(null);
	}

}
