package com.mba.springbootapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mba.springbootapp.model.Employee;
import com.mba.springbootapp.service.EmployeeService;

/**
 * Employee Controller
 * 
 * @author MBA
 *
 */
@RestController
@RequestMapping("v1/")
public class EmployeeServiceController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * Get all employee by department code.
	 * 
	 * @param deptCode
	 * @return
	 */
	@RequestMapping(value = "/departments/{deptCode}/employees", method = RequestMethod.GET)
	public List<Employee> getAllEmployee(@PathVariable("deptCode") String deptCode) {
		return employeeService.getAllEmployeeByDeptCode(deptCode);
	}

	/**
	 * Get employee by department code and employee code.
	 * 
	 * @param deptCode
	 * @param empCode
	 * @return employees
	 */
	@RequestMapping(value = "/departments/{deptCode}/employees/{empCode}", method = RequestMethod.GET)
	public Employee getEmployeeByDeptCodeAndEmpCode(@PathVariable("deptCode") String deptCode,
			@PathVariable("empCode") String empCode) {
		return employeeService.getEmployeeByDepartmentDeptCodeAndEmpCode(deptCode, empCode);
	}

	/**
	 * Add employee.
	 * 
	 * @param employee
	 */
	@RequestMapping(value = "/departments/{deptCode}/employees", method = RequestMethod.POST)
	public void addEmployee(@PathVariable("deptCode") String deptCode, @RequestBody Employee employee) {
		employeeService.addEmployee(deptCode, employee);

	}

	/**
	 * Update employee.
	 * 
	 * @param deptCode
	 * @param empCode
	 * @param employee
	 */
	@RequestMapping(value = "/departments/{deptCode}/employees/{empCode}", method = RequestMethod.PUT)
	public void updateEmployee(@PathVariable("deptCode") String deptCode, @PathVariable("empCode") String empCode,
			@RequestBody Employee employee) {
		employeeService.updateEmployee(deptCode, empCode, employee);
	}

	/**
	 * Get employee by code.
	 * 
	 * @param empCode
	 * @return employee
	 */
	@RequestMapping(value = "/employees/{empCode}", method = RequestMethod.GET)
	public Optional<Employee> getEmployee(@PathVariable("empCode") String empCode) {
		return employeeService.getEmployee(empCode);
	}

	/**
	 * Delete employee.
	 * 
	 * @param empCode
	 */
	@RequestMapping(value = "/employees/{empCode}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("empCode") String empCode) {
		employeeService.deleteEmployee(empCode);
	}

}
