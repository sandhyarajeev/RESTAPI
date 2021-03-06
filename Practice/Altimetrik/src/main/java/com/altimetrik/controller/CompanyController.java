package com.altimetrik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.service.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/empsInPrjt/{prjtId}/{deptId}")
	public ResponseEntity<Object> getEmployeesInProject(@PathVariable("prjtId") String prjtId, @PathVariable("deptId") String deptId) {
		return companyService.getEmployeesInProject(prjtId,deptId);
	}
	
	@GetMapping("/empsInDept/{deptId}")
	public ResponseEntity<Object> getEmployeesInDept( @PathVariable("deptId") String deptId) {
		return companyService.getEmployeesInDept(deptId);
	}
	
	@DeleteMapping("/deleteEmpFrmPrjt/{empId}/{prjtId}/{deptId}")
	public ResponseEntity<Object> deleteEmpFrmPrjt(@PathVariable("prjtId") String prjtId, @PathVariable("empId") String empId, @PathVariable("deptId") String deptId){
		return companyService.deleteEmpFrmPrjt(prjtId,empId,deptId);	
	}

}
