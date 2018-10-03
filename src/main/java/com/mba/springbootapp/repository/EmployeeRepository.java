package com.mba.springbootapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mba.springbootapp.model.Employee;

/**
 * Employee repository.
 *
 * @author MBA
 *
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

	/**
	 * Find by department code.
	 * 
	 * @param deptCode
	 * @return Employees
	 */
	public List<Employee> findByDepartmentDeptCode(String deptCode);

	/**
	 * Find by department code and employee code.
	 * 
	 * @param deptCode
	 * @param empCode
	 * @return employee
	 */
	public Employee findByDepartmentDeptCodeAndEmpCode(String deptCode, String empCode);

	/**
	 * Find by employee code.
	 * 
	 * @param empCode
	 * @return employee
	 */
	public Employee findByEmpCode(String empCode);
}
