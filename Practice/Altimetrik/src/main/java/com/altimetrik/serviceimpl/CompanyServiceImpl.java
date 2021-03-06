package com.altimetrik.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.altimetrik.controller.ResponseHandler;
import com.altimetrik.dto.EmployeeDTO;
import com.altimetrik.model.EmpDeptProject;
import com.altimetrik.model.EmpDeptProjectId;
import com.altimetrik.model.Employee;
import com.altimetrik.repository.DepartmentRepo;
import com.altimetrik.repository.EmpDeptProjectRepo;
import com.altimetrik.repository.EmployeeRepo;
import com.altimetrik.repository.ProjectDeptRepo;
import com.altimetrik.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	ProjectDeptRepo prjtDeptRepo;
	
	@Autowired
	DepartmentRepo deptRepo;
	
	@Autowired
	EmployeeRepo empRepo;
		
	@Autowired
	EmpDeptProjectRepo empDeptProjectRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	MessageSource msgSource;

	@Override
	public ResponseEntity<Object> getEmployeesInProject(String prjtId, String deptId) {
		List<Employee>empList = empRepo.getEmployeesInProject( prjtId,  deptId); 
		List<EmployeeDTO> empDtoList = null ;
		HttpStatus status;
		String message;
		if(!empList.isEmpty()) {
			empDtoList = empList.stream().map(this::convert).collect(Collectors.toList());
			status = HttpStatus.OK;
			message = msgSource.getMessage("project.employees.success", null, "", LocaleContextHolder.getLocale());
			return ResponseHandler.generateSuccessResponse(message, status,empDtoList);
		}else {
					
			status = HttpStatus.NOT_FOUND;
			message = msgSource.getMessage("project.employees.error", null, "", LocaleContextHolder.getLocale());
			
		}
		return ResponseHandler.generateResponse(message, status,null);
	}

	@Override
	public ResponseEntity<Object> getEmployeesInDept(String deptId) {
		List<Employee> empList = empRepo.getEmployeesInDept(deptId);
		List<EmployeeDTO> empDtoList = null ;
		HttpStatus status;
		String message;
		if(!empList.isEmpty()) {
			empDtoList = empList.stream().map(this::convert).collect(Collectors.toList());
			status = HttpStatus.OK;
			message =msgSource.getMessage("dept.employees.success", null, "", LocaleContextHolder.getLocale());
			return ResponseHandler.generateSuccessResponse(message, status, empDtoList);
		}else {
			message =msgSource.getMessage("dept.employees.error", null, "", LocaleContextHolder.getLocale());		
			status = HttpStatus.NOT_FOUND;
		}
		return ResponseHandler.generateResponse(message, status, null);
	}

	private EmployeeDTO convert(Employee emp) {
		EmployeeDTO empDto = modelMapper.map(emp, EmployeeDTO.class);
		return empDto;
	}

	@Override
	public ResponseEntity<Object> deleteEmpFrmPrjt(String prjtId, String empId,String deptId) {
		EmpDeptProjectId empDeptProjectId = new EmpDeptProjectId(deptId, prjtId, empId);
		Optional<EmpDeptProject> empDeptPrjt = empDeptProjectRepo.findById(empDeptProjectId);
		HttpStatus status = null;
		String message;
		if(empDeptPrjt.isPresent()) {
			empDeptProjectRepo.deleteById(empDeptProjectId);
			message =msgSource.getMessage("employee.delete.success", null, "", LocaleContextHolder.getLocale());
			status =  HttpStatus.OK;
		}else {
			status = HttpStatus.NOT_FOUND;
			message =msgSource.getMessage("employee.delete.failure", null, "", LocaleContextHolder.getLocale());
		}
		return ResponseHandler.generateResponse(message, status, null);
	}

}
