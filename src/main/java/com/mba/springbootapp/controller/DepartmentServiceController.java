package com.mba.springbootapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mba.springbootapp.model.Department;
import com.mba.springbootapp.service.DepartmentService;

/**
 * Department Service Controller.
 * 
 * In Spring’s approach to building RESTful web services, HTTP requests are
 * handled by a controller. These components are easily identified by
 * the @RestController annotation
 * 
 * @RestController: A convenience annotation that is itself annotated
 *                  with @Controller and @ResponseBody.
 * @author MBA
 *
 */
@RestController
@RequestMapping("v1/")
public class DepartmentServiceController {

	@Autowired
	private DepartmentService departmentService;

	/**
	 * Get all department.
	 * 
	 * @return departments
	 */
	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public List<Department> getAllDepartment() {
		return departmentService.getAllDepartment();
	}

	/**
	 * Get department by id.
	 * 
	 * @param deptCode
	 * @return department
	 */
	@RequestMapping(value = "/departments/{deptCode}", method = RequestMethod.GET)
	public Optional<Department> getDepartmentById(@PathVariable("deptCode") String deptCode) {
		return departmentService.getDepartmentById(deptCode);
	}

	/**
	 * Add department.
	 * 
	 * @param department
	 */
	@RequestMapping(value = "/departments", method = RequestMethod.POST)
	public void addDepartment(@RequestBody Department department) {
		departmentService.addDepartment(department);
	}

	/**
	 * Update department.
	 * 
	 * @param department
	 * @param depCode
	 */
	@RequestMapping(value = "/departments/{deptCode}", method = RequestMethod.PUT)
	public void updateDepartment(@RequestBody Department department, @PathVariable("deptCode") String depCode) {
		departmentService.updateDEpartment(department);
	}
	
	/**
	 * Delete department.
	 * 
	 * @param deptCode
	 */
	@RequestMapping(value="/departments/{deptCode}",method=RequestMethod.DELETE)
	public void deleteDepartment(@PathVariable("deptCode") String deptCode) {
		departmentService.deleteDepartment(deptCode);
	}
}
