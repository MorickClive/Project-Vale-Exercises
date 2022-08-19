package com.mc.exercises.garage.model.vehicles;

import com.mc.exercises.garage.model.vehicles.interfaces.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MotorBike implements Vehicle {
	
	private String model;
	private Float milage;
	private Integer numWheels;
	
	public MotorBike() {
		super();
		this.model = "???";
		this.milage = 0.0f;
		this.numWheels = 2;
	}

	public MotorBike(String model, Float milage, Integer numWheels) {
		super();
		this.model = model;
		this.milage = milage;
		this.numWheels = numWheels <= 2 ? numWheels : 2;
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
