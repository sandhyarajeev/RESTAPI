package com.altimetrik.model;

import java.io.Serializable;

public class EmpDeptProjectId implements Serializable{
	
	private String deptId;
	
	private String projId;
	
	private String empId;
	
	

	public EmpDeptProjectId() {
		super();
	}



	public EmpDeptProjectId(String deptId, String projId, String empId) {
		super();
		this.deptId = deptId;
		this.projId = projId;
		this.empId = empId;
	}
	
	
}
