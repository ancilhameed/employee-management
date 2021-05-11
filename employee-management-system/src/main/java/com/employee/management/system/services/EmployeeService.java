package com.employee.management.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.system.dao.EmployeeRepository;
import com.employee.management.system.enums.EmployeeState;
import com.employee.management.system.exceptions.EmployeeNotFoundException;
import com.employee.management.system.vo.Employee;

/**
 * Below class is a @Service, which includes business service logic.
 * 
 * @author ancil.andathodantiri
 *
 */
@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee save(Employee employee) {
		employee.setEmployeeState(EmployeeState.ADDED);
		return employeeRepository.save(employee);
	}

	public Employee update(Employee employee) {
		Employee emp = employeeRepository.findById(employee.getId()).orElseThrow(
				() -> new EmployeeNotFoundException(employee.getId()));
		employee.setEmployeeState(emp.getEmployeeState().nextState());
		return employeeRepository.save(employee);
	}

	public Employee findById(int empId) {
		return employeeRepository.findById(empId)
				.orElseThrow(() -> new EmployeeNotFoundException(empId));
	}

	public void deleteById(int empId) {
		employeeRepository.deleteById(empId);
	}

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

}
