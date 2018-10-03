package com.mba.springbootapp.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Employee class.
 * 
 * @author MBA
 *
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name = "emp_code", nullable = false, unique = true)
	@Id
	private String empCode;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "age", nullable = false)
	private int age;

	@Column(name = "date_of_joining", nullable = false)
	private LocalDate dateOfJoining;

	@Column(name = "designation", nullable = false)
	private String designation;

	@ManyToOne 
	@JoinColumn(name = "dept_code")
	//@JsonIgnore
	private Department department;

	/**
	 * Constructors
	 */

	public Employee() {
		department = new Department();
	}

	public Employee(BigInteger id, String empCode, String firstName, String lastName, int age, LocalDate dateOfJoining,
			String designation) {
		this.id = id;
		this.empCode = empCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dateOfJoining = dateOfJoining;
		this.designation = designation;
	}

	/**
	 * Setters & Getters
	 */

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empCode=" + empCode + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", dateOfJoining=" + dateOfJoining + ", designation=" + designation + "]";
	}
}
