package com.employee.management.system.enums;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class EmployeeStateTest {

	@Test
	public void test_state_transition_from_ADDED_to_CHECKIN() {
		EmployeeState employeeState = EmployeeState.ADDED;
		Assert.isTrue(EmployeeState.IN_CHECK.equals(employeeState.nextState()),
				"Validate state transition from ADDED to CHECK_IN");
	}
	
	
	@Test
	public void test_state_transition_from_IN_CHECK_to_APPROVE() {
		EmployeeState employeeState = EmployeeState.IN_CHECK;
		Assert.isTrue(EmployeeState.APPROVED.equals(employeeState.nextState()),
				"Validate state transition from ADDED to IN_CHECK");
	}
	
	@Test
	public void test_state_transition_from_APPROVED_to_ACTIVE() {
		EmployeeState employeeState = EmployeeState.APPROVED;
		Assert.isTrue(EmployeeState.ACTIVE.equals(employeeState.nextState()),
				"Validate state transition from APPROVED to ACTIVE");
	}
	
	@Test
	public void test_state_transition_from_ACTIVE_to_ACTIVE() {
		EmployeeState employeeState = EmployeeState.ACTIVE;
		Assert.isTrue(EmployeeState.ACTIVE.equals(employeeState.nextState()),
				"Validate state transition from ACTIVE to ACTIVE");
	}

}
