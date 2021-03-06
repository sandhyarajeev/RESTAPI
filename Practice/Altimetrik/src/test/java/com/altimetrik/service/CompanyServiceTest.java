package com.altimetrik.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.altimetrik.dto.EmployeeDTO;
import com.altimetrik.model.EmpDeptProject;
import com.altimetrik.model.EmpDeptProjectId;
import com.altimetrik.model.Employee;
import com.altimetrik.repository.EmpDeptProjectRepo;
import com.altimetrik.repository.EmployeeRepo;

@SpringBootTest(classes= {com.altimetrik.AltimetrikApplication.class})
public class CompanyServiceTest {

	@Autowired
	private CompanyService companyService;
	
	@MockBean
	private EmployeeRepo empRepo;
	
	@Mock
	ModelMapper modelMapper;
	
	private List<Employee> empList = new ArrayList<Employee>();	

	private List<EmployeeDTO> empDtoList = new ArrayList<EmployeeDTO>();	
	
	private Employee emp1,emp2;
	
	private EmployeeDTO empDTO1,empDTO2;
	
	EmpDeptProjectId empDeptProjectId;

	@MockBean
	EmpDeptProjectRepo empDeptProjectRepo;
	
	@BeforeEach
	public void setUp() {
		emp1 = new Employee();
		emp1.setContactNum(43432L);
		emp1.setFirstName("sandhya");
		emp1.setLastName("rajeev");
		emp1.setEmpId("E001");
		
		emp2 = new Employee();
		emp1.setContactNum(43432L);
		emp1.setFirstName("sandhya");
		emp1.setLastName("rajeev");
		emp1.setEmpId("E001");
		
		empList.add(emp1);
		empList.add(emp2);
		
		empDTO1 = new EmployeeDTO();
		empDTO1.setContactNum(43432L);
		empDTO1.setFirstName("sandhya");
		empDTO1.setLastName("rajeev");
		empDTO1.setEmpId("E001");
		
		empDTO2 = new EmployeeDTO();
		empDTO2.setContactNum(43432L);
		empDTO2.setFirstName("sandhya");
		empDTO2.setLastName("rajeev");
		empDTO2.setEmpId("E001");
		empDtoList.add(empDTO1);
		empDtoList.add(empDTO2);
		
	}
	
	@Test
	public void getEmployeesInProject() {
		
		when(empRepo.getEmployeesInProject("P001", "D001")).thenReturn(new ArrayList<Employee>());
		
		ResponseEntity<Object> response = companyService.getEmployeesInProject("P001", "D001");
		Assertions.assertThat(response.getStatusCode()).isSameAs(HttpStatus.NOT_FOUND);

		when(empRepo.getEmployeesInProject("P001", "D001")).thenReturn(empList);
		when(modelMapper.map(emp1, EmployeeDTO.class)).thenReturn(empDTO1);
		when(modelMapper.map(emp2, EmployeeDTO.class)).thenReturn(empDTO2);
		
		response = companyService.getEmployeesInProject("P001", "D001");
		Assertions.assertThat(response.getStatusCode()).isSameAs(HttpStatus.OK);
		

	}
	
	@Test
	public void deleteEmpFromPrjt() {
		//empDeptProjectId = new EmpDeptProjectId("D001", "P001", "E002");
		Optional<EmpDeptProject> empDep = Optional.of(new EmpDeptProject("D001", "P001", "E002"));
		when(empDeptProjectRepo.findById(any())).thenReturn(empDep);
		ResponseEntity<Object> response = companyService.deleteEmpFrmPrjt("D001", "P001", "E002");
		Assertions.assertThat(response.getStatusCode()).isSameAs(HttpStatus.OK);
		
		
		when(empDeptProjectRepo.findById(any())).thenReturn(Optional.empty());
		response = companyService.deleteEmpFrmPrjt("D001", "P001", "E001");
		Assertions.assertThat(response.getStatusCode()).isSameAs(HttpStatus.NOT_FOUND);
		
		
		
	}
}
