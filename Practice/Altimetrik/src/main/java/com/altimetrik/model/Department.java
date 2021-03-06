package com.altimetrik.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Department {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="deptId")
	private String deptId;
	
	@Column(name="dept_name" ,length=50, nullable = false)
	private String deptName;
	
	
	 @ManyToMany(mappedBy = "deptSet")
	    private Set<Employee> employees = new HashSet<>();
	 
	 public void addEmployee(Employee emp) {
	        this.employees.add(emp);
	        emp.getDeptSet().add(this);
	    }
	 
	    public void removeEmp(Employee emp) {
	        this.employees.remove(emp);
	        emp.getDeptSet().remove(this);
	    }
}