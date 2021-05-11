package com.employee.management.system.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import com.employee.management.system.vo.Employee;



@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@SuppressWarnings("deprecation")
	@Test
    public void testSave() 
    {
		Employee firstEmployee = new Employee();
		firstEmployee.setId(1);
         
        employeeRepository.save(firstEmployee);
        Assert.notNull(firstEmployee.getId(), "");
    }

	

	@Test
	public void whenFindAllById() {
		// given
		Employee Employee = new Employee();
		Employee.setId(1);
		entityManager.persist(Employee);
		entityManager.flush();

		// when
		Employee testEmployee = employeeRepository.findById(Employee.getId()).orElse(null);

		// then
		assertThat(testEmployee.getId()).isEqualTo(Employee.getId());
	}
}