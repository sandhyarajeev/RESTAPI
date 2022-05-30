package com.altimetrik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.altimetrik.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
	
	Department findByDeptId(@Param("deptId") String deptId);

}
