package com.altimetrik.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

	private String empId;
	
	private String firstName;
	
	private String lastName;
	
	private String address1;
	
	private String address2;
	
	private long contactNum;
	
	
    

	public EmployeeDTO() {
		super();
	}
	
	
}
