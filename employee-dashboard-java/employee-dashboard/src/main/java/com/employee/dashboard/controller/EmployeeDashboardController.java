package com.employee.dashboard.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employee.dashboard.model.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("employees")
public class EmployeeDashboardController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployeeData() {
		ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:9000/employees", String.class);
		List<Employee> employees = null;
		try {
			employees = mapper.readValue(entity.getBody().getBytes(), new TypeReference<List<Employee>>() {});
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!employees.isEmpty()) {
			return ResponseEntity.ok(employees);
		}
		return ResponseEntity.noContent().build();
	}
}
