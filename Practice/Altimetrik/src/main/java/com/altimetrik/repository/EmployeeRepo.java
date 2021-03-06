package com.altimetrik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.altimetrik.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e where e.empId in (select empId from EmployeeDept d where d.deptId=:deptId)")
	List<Employee> getEmployeesInDept(String deptId);

	@Query("select e from Employee e where e.empId in (select empId from EmpDeptProject d where d.deptId=:deptId and d.projId=:projId)")
	List<Employee> getEmployeesInProject(String projId, String deptId);

}
