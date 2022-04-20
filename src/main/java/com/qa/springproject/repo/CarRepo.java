package com.qa.springproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.springproject.domain.Car;

public interface CarRepo extends JpaRepository<Car, Integer> {

}
