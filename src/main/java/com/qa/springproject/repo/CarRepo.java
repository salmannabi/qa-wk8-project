package com.qa.springproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springproject.domain.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {
	
	List<Car> findByMakeIgnoreCase(String make);
	List<Car> findByModelIgnoreCase(String model);
	List<Car> findByBodyTypeIgnoreCase(String bodyType);
	List<Car> findByFuelTypeIgnoreCase(String fuelType);
	List<Car> findByGearboxIgnoreCase(String gearbox);
}
