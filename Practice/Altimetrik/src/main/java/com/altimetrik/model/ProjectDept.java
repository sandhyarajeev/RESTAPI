package com.altimetrik.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@IdClass(ProjectDeptId.class)
public class ProjectDept {


	@Id
	@ManyToOne   
	@JoinColumn(name="deptId",nullable=false)
	private Department dept;
	
	@Id
	@Column(name="projId" , nullable = false)
	private String projId;
	
	@Column(name="project_Name" ,length=50, nullable = false)
	private String prjtName;
	
	
	 @ManyToMany(mappedBy = "empDeptPrjtSet")
	    private Set<Employee> employees = new HashSet<>();
	 
	 public void addEmployee(Employee emp) {
	        this.employees.add(emp);
	        emp.getEmpDeptPrjtSet().add(this);
	    }
	 
	    public void removeEmp(Employee emp) {
	        this.employees.remove(emp);
	        emp.getEmpDeptPrjtSet().remove(this);
	    }
	
}
