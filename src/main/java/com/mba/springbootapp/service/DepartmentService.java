package com.mba.springbootapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mba.springbootapp.model.Department;
import com.mba.springbootapp.repository.DepartmentRepository;

/**
 * Department Service.
 * 
 * @Service: annotation define 'EmployeeService' class as business service.
 * 
 *           Business service: in spring are typically singleton's when the
 *           application start up ,spring create instance of this service and
 *           its keep thats in its memory , where other services or controller
 *           depends on this, it declare a dependency where it can injected.
 * 
 * @author MBA
 *
 */
@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	/**
	 * Get all department.
	 * 
	 * @return departments
	 */
	public List<Department> getAllDepartment() {
		return (List<Department>) departmentRepository.findAll();
	}

	/**
	 * Get department by id.
	 * 
	 * @param deptCode
	 * @return department
	 */
	public Optional<Department> getDepartmentById(String deptCode) {
		return departmentRepository.findById(deptCode);
	}

	/**
	 * Add department.
	 * 
	 * @param department
	 */
	public void addDepartment(Department department) {
		departmentRepository.save(department);
	}

	/**
	 * Update department.
	 * 
	 * @param department
	 */
	public void updateDEpartment(Department department) {
		departmentRepository.save(department);
	}

	/**
	 * Delete department.
	 * 
	 * @param deptCode
	 */
	public void deleteDepartment(String deptCode) {
		departmentRepository.deleteById(deptCode);
	}
}
