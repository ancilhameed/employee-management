package com.employee.management.system.controller;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.employee.management.system.controllers.EmployeeManagementController;
import com.employee.management.system.dao.EmployeeRepository;
import com.employee.management.system.services.EmployeeService;
import com.employee.management.system.vo.Contract;
import com.employee.management.system.vo.Employee;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = EmployeeManagementController.class)
public class EmployeeManagementControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	EmployeeManagementController employeeController;

	@Mock
	EmployeeRepository employeeRepository;

	@MockBean
	private EmployeeService employeeService;

	@Test
	public void testFindAll() throws Exception {
		when(employeeService.findAll()).thenReturn(Arrays.asList(new Employee(1, "Ancil", 28, new Date(), new Contract())));

		mockMvc.perform(MockMvcRequestBuilders.get("/employees")).andExpect(MockMvcResultMatchers.status().is(200));
	}


}