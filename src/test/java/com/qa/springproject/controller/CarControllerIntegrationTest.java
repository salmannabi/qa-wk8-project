package com.qa.springproject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springproject.domain.Car;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:car-schema.sql", 
"classpath:car-data.sql"}, executionPhase=ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("Test")
public class CarControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Car testCar = new Car(null, "Lexus", "IS250", "Saloon", "Manual", "Petrol");
		String testCarAsJson = this.mapper.writeValueAsString(testCar);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testCarAsJson);
		
		Car testCreateCar = new Car(3, "Lexus", "IS250", "Saloon", "Manual", "Petrol");
		String testCreatedCarAsJson = this.mapper.writeValueAsString(testCreateCar);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedCarAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	

	@Test
	void getAllTest() throws Exception {
		RequestBuilder req = get("/getAll");
		
		List<Car> testCars = List.of(new Car(1, "Toyota", "Avensis", "Saloon", "Automatic", "Petrol"), 
				new Car(2, "Lexus", "IS250", "Saloon", "Automatic", "Petrol"));
		String json = this.mapper.writeValueAsString(testCars);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void getByIdTest() throws Exception {
		RequestBuilder req = get("/get/2");
		String json = this.mapper.writeValueAsString(new Car(2, "Lexus", "IS250", "Saloon", "Automatic", "Petrol"));
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void getByMakeTest() throws Exception {
		RequestBuilder req = get("/getByMake/Lexus");
		
		List<Car> testCars = List.of(new Car(2, "Lexus", "IS250", "Saloon", "Automatic", "Petrol"));
		String json = this.mapper.writeValueAsString(testCars);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
				
	}
	
	@Test
	void getByModelTest() throws Exception {
		RequestBuilder req = get("/getByModel/IS250");
		
		List<Car> testCars = List.of(new Car(2, "Lexus", "IS250", "Saloon", "Automatic", "Petrol"));
		String json = this.mapper.writeValueAsString(testCars);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testReplace() throws Exception {
		
		Car testCar = new Car(1, "Lexus", "IS250", "Saloon", "Manual", "Petrol");
		String json = this.mapper.writeValueAsString(testCar);
		
		RequestBuilder req = put("/replace/1").contentType(MediaType.APPLICATION_JSON).content(json);
		
		Car testUpdatedCar = new Car(1, "Lexus", "IS250", "Saloon", "Manual", "Petrol");
		String testUpdatedCarAsJson = this.mapper.writeValueAsString(testUpdatedCar);
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testUpdatedCarAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testRemove() throws Exception {
		this.mvc.perform(delete("/remove/1")).andExpect(status().isNoContent());
	}
}
