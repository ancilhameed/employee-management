package com.employee.management.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.management.system.vo.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
