package com.employee.management.system.vo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.employee.management.system.enums.EmployeeState;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ancil.andathodantiri
 *
 */
@ApiModel(description = "All the information about an employee.")
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Size(min = 2, message = "Name should be minimum 2 characters.")
	@ApiModelProperty(notes = "Name should be minimum 2 characters.")
	private String name;

	private Integer age;

	@Past(message = "Birth date should be past.")
	@ApiModelProperty(notes = "Birth date should be past.")
	private Date dateOfBirth;

	@Enumerated(EnumType.STRING)
	private EmployeeState employeeState;

	@NotNull
	@ApiModelProperty(notes = "Contract information cannot be empty.")
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
	private Contract contract;

	public Employee() {

	}

	public Employee(Integer id, String name, Integer age, Date dateOfBirth, Contract contract) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		// this.contract = contract;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public EmployeeState getEmployeeState() {
		return employeeState;
	}

	public void setEmployeeState(EmployeeState employeeState) {
		this.employeeState = employeeState;
	}

	public Contract getcontract() {
		return contract;
	}

	public void setcontract(Contract contract) {
		this.contract = contract;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", contract=");
		builder.append(contract);
		builder.append(", employeeState=");
		builder.append(employeeState);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
