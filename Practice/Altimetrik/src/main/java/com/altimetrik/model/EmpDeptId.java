package com.altimetrik.model;

import java.io.Serializable;

public class EmpDeptId implements Serializable{
	
	private String empId;
	
	private String deptId;

	public EmpDeptId(String empId, String deptId) {
		super();
		this.empId = empId;
		this.deptId = deptId;
	}
	
	

}
