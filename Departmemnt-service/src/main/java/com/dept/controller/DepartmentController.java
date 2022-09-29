package com.dept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dept.entity.Department;
import com.dept.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/dept")
@Slf4j
public class DepartmentController {
	
	@Autowired
	DepartmentService deptservice;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department dept) {
		log.info("inside save DepartmentController");
		return deptservice.saveDepartment(dept);
	}
	
	@GetMapping("/{Id}")
	public Department findDepartmentById(@PathVariable("Id") Long deptId) {
		log.info("inside save DepartmentController");
		return deptservice.findDepartmentById(deptId);
	}

}
