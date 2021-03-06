package com.altimetrik.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="empId")
	private String empId;
	
	@Column(name="first_name" ,length=50, nullable = false)
	private String firstName;
	
	@Column(name="last_name" ,length=50, nullable = false)
	private String lastName;
	
	private String address1;
	
	private String address2;
	
	@Column(name="contact_number", length=10)
	private long contactNum;
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "EmployeeDept", 
        joinColumns = { @JoinColumn(name = "empId") }, 
        inverseJoinColumns = { @JoinColumn(name = "deptId") }
    )
    Set<Department> deptSet = new HashSet<>();

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "EmpDeptProject", 
        joinColumns = { @JoinColumn(name = "empId") }, 
        inverseJoinColumns = { @JoinColumn(name = "deptId") , @JoinColumn(name = "projId")}
    )
    Set<ProjectDept> empDeptPrjtSet = new HashSet<>();

	
}
