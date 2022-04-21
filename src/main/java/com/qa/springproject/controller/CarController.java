package com.qa.springproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springproject.domain.Car;
import com.qa.springproject.service.CarService;

@RestController
public class CarController {
	private CarService service;
	
	public CarController(CarService service) {
		this.service = service;
	}
	
	// Create
	@PostMapping("/create")
	public ResponseEntity<Car> createCar(@RequestBody Car car) {
		Car newCar = this.service.create(car);
		ResponseEntity<Car> response = new ResponseEntity<Car>(newCar, HttpStatus.CREATED);
		return response;
	}
	
	// ReadAll
	@GetMapping("/getAll")
	public ResponseEntity<List<Car>> getAllCars() {
		return ResponseEntity.ok(service.getAll());
	}
	
	// Read by id
	@GetMapping("/get/{id}")
	public Car getCar(@PathVariable Integer id) {
		return this.service.getOne(id);
	}
	
	// Update by id
	@PutMapping("/replace/{id}")
	public ResponseEntity<Car> replaceCar(@PathVariable Integer id, @RequestBody Car car) {
		Car updateCar = this.service.replace(id, car);
		ResponseEntity<Car> response = new ResponseEntity<Car>(updateCar, HttpStatus.ACCEPTED);
		return response;
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeCar(@PathVariable Integer id) {
		this.service.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/getByMake/{make}")
	public ResponseEntity<List<Car>> getCarsByMake(@PathVariable String make) {
		List<Car> data = this.service.getCarsByMake(make);
		return ResponseEntity.ok(data);
	}
	
	@GetMapping("/getByModel/{model}")
	public ResponseEntity<List<Car>> getCarsByModel(@PathVariable String model) {
		List<Car> data = this.service.getCarsByModel(model);
		return ResponseEntity.ok(data);
	}
	
	@GetMapping("/getByFuelType/{fuelType}")
	public ResponseEntity<List<Car>> getCarsByFuelType(@PathVariable String fuelType) {
		List<Car> data = this.service.getCarsByFuelType(fuelType);
		return ResponseEntity.ok(data);
	}
	
	@GetMapping("/getByBodyType/{bodyType}")
	public ResponseEntity<List<Car>> getCarsByBodyType(@PathVariable String bodyType) {
		List<Car> data = this.service.getCarsByBodyType(bodyType);
		return ResponseEntity.ok(data);
	}
	
	@GetMapping("/getByGearbox/{gearbox}")
	public ResponseEntity<List<Car>> getCarsByGearbox(@PathVariable String gearbox) {
		List<Car> data = this.service.getCarsByGearbox(gearbox);
		return ResponseEntity.ok(data);
	}
}