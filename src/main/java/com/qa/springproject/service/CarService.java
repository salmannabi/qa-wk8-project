package com.qa.springproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.springproject.domain.Car;
import com.qa.springproject.repo.CarRepo;

@Service
public class CarService implements ServiceIF<Car> {
	
	private CarRepo repo;
	
	@Autowired
	public CarService(CarRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Car create(Car car) {
		Car newCar = this.repo.save(car);
		return newCar;
	}

	@Override
	public List<Car> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Car getOne(Integer id) {
		Optional<Car> data = this.repo.findById(id);
		return data.get();
	}

	@Override
	public Car replace(Integer id, Car car) {
		Car currentCar = this.repo.findById(id).get();
		
		currentCar.setMake(car.getMake());
		currentCar.setModel(car.getModel());
		currentCar.setGearbox(car.getGearbox());
		currentCar.setFuelType(car.getFuelType());
		currentCar.setBodyType(car.getBodyType());
		
		Car updated = this.repo.save(currentCar);
		return updated;
	}

	@Override
	public void remove(@PathVariable Integer id) {
		this.repo.deleteById(id);		
	}

	public List<Car> getCarsByMake(String make) {
		List<Car> data = this.repo.findByMakeIgnoreCase(make);
		return data;
	}
	
	public List<Car> getCarsByModel(String model) {
		List<Car> data = this.repo.findByModelIgnoreCase(model);
		return data;
	}
	
	public List<Car> getCarsByBodyType(String bodyType) {
		List<Car> data = this.repo.findByBodyTypeIgnoreCase(bodyType);
		return data;
	}
	
	public List<Car> getCarsByFuelType(String fuelType) {
		List<Car> data = this.repo.findByFuelTypeIgnoreCase(fuelType);
		return data;
	}
	
	public List<Car> getCarsByGearbox(String gearbox) {
		List<Car> data = this.repo.findByGearboxIgnoreCase(gearbox);
		return data;
	}
}
