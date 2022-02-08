package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employeesList = employeeService.getEmployees();
		return ResponseEntity.ok(employeesList);
	}
}
