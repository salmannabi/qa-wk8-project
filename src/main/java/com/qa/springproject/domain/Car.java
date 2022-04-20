package com.qa.springproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String make;
	
	@Column(nullable = false)
	private String model;
	
	@Column(nullable = false)
	private String bodyType;
	
	@Column(nullable = false)
	private String gearbox;
	
	@Column(nullable = false)
	private String fuelType;
	
	public Car(Integer id, String make, String model, String bodyType, String gearbox, String fuelType) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.bodyType = bodyType;
		this.gearbox = gearbox;
		this.fuelType = fuelType;
	}
	
	public Car() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model + ", bodyType=" + bodyType + ", gearbox="
				+ gearbox + ", fuelType=" + fuelType + "]";
	}
}
