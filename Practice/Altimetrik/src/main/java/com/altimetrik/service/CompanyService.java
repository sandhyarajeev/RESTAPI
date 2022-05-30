package com.altimetrik.service;

import org.springframework.http.ResponseEntity;

public interface CompanyService {

	ResponseEntity<Object> getEmployeesInProject(String prjtId, String deptId);

	ResponseEntity<Object> getEmployeesInDept(String empId);

	ResponseEntity<Object> deleteEmpFrmPrjt(String prjtId, String empId, String deptId);


}
