package com.mba.springbootapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mba.springbootapp.model.Department;
import com.mba.springbootapp.model.Employee;
import com.mba.springbootapp.repository.DepartmentRepository;
import com.mba.springbootapp.repository.EmployeeRepository;

/**
 * Employee Service
 * 
 * @author MBA
 *
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	/**
	 * Get all employee by department code.
	 * 
	 * @return employees
	 */
	public List<Employee> getAllEmployeeByDeptCode(String deptCode) {
		return employeeRepository.findByDepartmentDeptCode(deptCode);
	}

	/**
	 * Get employee by department code and employee code.
	 * 
	 * @param deptCode
	 * @param empCode
	 * @return employee
	 */
	public Employee getEmployeeByDepartmentDeptCodeAndEmpCode(String deptCode, String empCode) {
		return employeeRepository.findByDepartmentDeptCodeAndEmpCode(deptCode, empCode);
	}

	/**
	 * Get employee by empCode.
	 * 
	 * @param empCode
	 * @return employee
	 */
	public Optional<Employee> getEmployee(String empCode) {
		return employeeRepository.findById(empCode);
	}

	/**
	 * Add employee.
	 * 
	 * @param deptCode
	 * @param employee
	 */
	public void addEmployee(String deptCode, Employee employee) {
		Department department = departmentRepository.findByDeptCode(deptCode);
		employee.setDepartment(department);
		employeeRepository.save(employee);
	}

	/**
	 * Update employee.
	 * 
	 * @param deptCode
	 * @param empCode
	 * @param employee
	 */
	public void updateEmployee(String deptCode, String empCode, Employee employee) {
		Department department = departmentRepository.findByDeptCode(deptCode);
		Employee emp = employeeRepository.findByEmpCode(empCode);

		if (!employee.getFirstName().equals("")) {
			emp.setFirstName(employee.getFirstName());
		}

		if (!employee.getLastName().equals("")) {
			emp.setLastName(employee.getLastName());
		}

		if (employee.getAge() > 0) {
			emp.setAge(employee.getAge());
		}

		if (employee.getDateOfJoining() != null && employee.getDateOfJoining().isBefore(LocalDate.now())) {
			emp.setDateOfJoining(employee.getDateOfJoining());
		}

		if (!employee.getDesignation().equals("")) {
			emp.setDesignation(employee.getDesignation());
		}

		if (department != null) {
			emp.setDepartment(department);
		}
		employeeRepository.save(emp);
	}

	/**
	 * Delete employee.
	 * 
	 * @param empCode
	 */
	public void deleteEmployee(String empCode) {
		employeeRepository.deleteById(empCode);
	}
}
