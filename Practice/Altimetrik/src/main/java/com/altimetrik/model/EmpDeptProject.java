package com.altimetrik.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@IdClass(EmpDeptProjectId.class)
public class EmpDeptProject {


	@Id
	@Column(name="deptId",nullable=false)
	private String deptId;

	@Id
	@Column(name="projId" , nullable = false)
	private String projId;

	@Id
	@Column(name="empId",nullable=false)
	private String empId;

	public EmpDeptProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmpDeptProject(String deptId, String projId, String empId) {
		super();
		this.deptId = deptId;
		this.projId = projId;
		this.empId = empId;
	}


}
