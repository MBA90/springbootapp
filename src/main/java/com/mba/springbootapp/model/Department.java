package com.mba.springbootapp.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Department class.
 * 
 * @author MBA
 *
 */
@Entity
@Table(name = "department")
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	@Id
	@Column(name = "dept_code", nullable = false, unique = true)
	private String deptCode;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "location", nullable = false)
	private String location;

	/**
	 * Constructors
	 */

	public Department() {
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
