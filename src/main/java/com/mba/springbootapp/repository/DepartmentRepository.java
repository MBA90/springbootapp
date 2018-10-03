package com.mba.springbootapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mba.springbootapp.model.Department;

/**
 * Department repository.
 * 
 * @Repository: Teams implementing traditional Java EE patterns such as "Data
 *              Access Object" may also apply this stereotype to DAO classes,
 *              though care should be taken to understand the distinction
 *              between Data Access Object and DDD-style repositories before
 *              doing so. This annotation is a general-purpose stereotype and
 *              individual teams may narrow their semantics and use as
 *              appropriate.
 * 
 * @author MBA
 *
 */
@Repository
public interface DepartmentRepository extends CrudRepository<Department, String> {
	
	/**
	 * Find by department code.
	 * 
	 * @param deptCode
	 * @return department
	 */
	public Department findByDeptCode(String deptCode);
}
