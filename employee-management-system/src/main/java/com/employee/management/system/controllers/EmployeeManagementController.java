package com.employee.management.system.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employee.management.system.services.EmployeeService;
import com.employee.management.system.vo.Employee;

/**
 * @author ancil.andathodantiri
 *
 */
@RestController
public class EmployeeManagementController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employees")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.findById(id);
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.update(employee);
	}

	@DeleteMapping("/employees/{id}")
	public void getEmployee(@PathVariable int id) {
		employeeService.deleteById(id);
	}
}
