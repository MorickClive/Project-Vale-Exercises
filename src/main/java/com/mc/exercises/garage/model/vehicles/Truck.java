package com.mc.exercises.garage.model.vehicles;

import com.mc.exercises.garage.model.vehicles.interfaces.Vehicle;

public class Truck implements Vehicle {
	
	private String model;
	private Float milage;
	private Integer numWheels;
	
	public Truck() {
		super();
		this.model = "???";
		this.milage = 0.0f;
		this.numWheels = 4;
	}
	
	public Truck(String model, Float milage, Integer numWheels) {
		this();
		this.model = model;
		this.milage = milage;
		this.numWheels = numWheels;
	}
	
	// ========================================

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Float getMilage() {
		return milage;
	}

	public void setMilage(Float milage) {
		this.milage = milage;
	}

	public Integer getNumWheels() {
		return numWheels;
	}

	public void setNumWheels(Integer numWheels) {
		this.numWheels = numWheels;
	}

	@Override
	public String description() {
		return String.format("[%s]: Model: %s, Milage: %s, Number of Wheels: %s",
				this.getClass().getSimpleName(),
				model, milage, numWheels);
	}

	@Override
	public String toString() {
		return description();
	}

}
