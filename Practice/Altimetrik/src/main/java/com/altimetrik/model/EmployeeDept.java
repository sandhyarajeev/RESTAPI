package com.altimetrik.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@IdClass(EmpDeptId.class)
public class EmployeeDept {

	@Id
	private String empId;
	@Id
	private String deptId;
	
	   
	
}
