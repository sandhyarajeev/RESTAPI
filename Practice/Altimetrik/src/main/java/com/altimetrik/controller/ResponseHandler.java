package com.altimetrik.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.altimetrik.dto.EmployeeDTO;

public class ResponseHandler {
	
	
	
	 private ResponseHandler() {
		super();
		// TODO Auto-generated constructor stub
	}


	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object response) {
	        Map<String, Object> map = new HashMap<String, Object>();
	            map.put("message", message);
	            map.put("status", status.value());
	            map.put("data", response);
	            return new ResponseEntity<Object>(map,status);
	    }

	 
	 public static ResponseEntity<Object> generateSuccessResponse(String message, HttpStatus status, List<EmployeeDTO> empList) {
	        Map<String, Object> map = new HashMap<String, Object>();
	            map.put("message", message);
	            map.put("status", status.value());
	            map.put("data", empList);

	            return new ResponseEntity<Object>(map,status);
	    }
	

}
