package com.mc.exercises.garage.model.vehicles;

import com.mc.exercises.garage.model.vehicles.interfaces.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car implements Vehicle {
	
	private String model;
	private Float milage;
	private Integer numWheels;
	
	public Car() {
		super();
		this.model = "???";
		this.milage = 0.0f;
		this.numWheels = 4;
	}
	
	// ========================================

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
