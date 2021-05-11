package com.employee.management.system.enums;

/**
 * @author ancil.andathodantiri
 *
 */
public enum EmployeeState {

	ADDED {
		@Override
		public EmployeeState nextState() {
			return IN_CHECK;
		}
	},

	IN_CHECK {
		@Override
		public EmployeeState nextState() {
			return APPROVED;
		}
	},

	APPROVED {
		@Override
		public EmployeeState nextState() {
			return ACTIVE;
		}
	},

	ACTIVE {
		@Override
		public EmployeeState nextState() {
			return this;
		}
	};

	public abstract EmployeeState nextState();
}
