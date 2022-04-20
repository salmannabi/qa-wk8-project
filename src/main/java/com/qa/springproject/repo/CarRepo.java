package com.qa.springproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springproject.domain.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {

}
