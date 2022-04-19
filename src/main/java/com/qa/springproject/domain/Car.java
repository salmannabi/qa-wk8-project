package com.qa.springproject.domain;

public class Car {
	private Integer id;
	private String make;
	private String model;
	private String bodyType;
	private String gearbox;
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
