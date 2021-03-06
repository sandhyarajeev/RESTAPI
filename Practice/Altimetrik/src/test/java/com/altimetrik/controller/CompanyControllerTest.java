package com.altimetrik.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest (classes = {com.altimetrik.AltimetrikApplication.class})
public class CompanyControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private WebApplicationContext context;
	
	@BeforeAll
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		assertNotNull(mockMvc);
	}
	
	@Test
	public void getEmployeesInPrjt() throws Exception {
		ResultActions ra = mockMvc.perform(MockMvcRequestBuilders.get("/empsInPrjt/"+"P001/"+"D001"));
		ra.andExpect(status().is(200));
		
		ra = mockMvc.perform(MockMvcRequestBuilders.get("/empsInPrjt/"+"P001/"+"D005"));
		ra.andExpect(status().is(404));
		
	}
	
	
	@Test
	public void deleteEmployeeFromPjt() throws Exception {
		ResultActions ra = mockMvc.perform(MockMvcRequestBuilders.delete("/deleteEmpFrmPrjt/"+"E002/"+"P001/"+"D001"));
		ra.andExpect(status().is(200));
		
		ra = mockMvc.perform(MockMvcRequestBuilders.delete("/deleteEmpFrmPrjt/"+"E001/"+"P001/"+"D001"));
		ra.andExpect(status().is(404));
		
	}

}
