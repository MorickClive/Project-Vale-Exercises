package com.mc.exercises.garage.model.buildings;

import java.util.ArrayList;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class Property {
	
	@Getter	@Setter
	private String name;
	@Getter	@Setter
	private String address;
	
	private ArrayList<Garage> garageUnits;
	
	public Property() {
		super();
		name = "???";
		address = "???";
		garageUnits = new ArrayList<>();
	}
	
	public Property(String name, String address, ArrayList<Garage> garage) {
		this();
		this.name = name;
		this.address = address;
		this.garageUnits = garage;
	}

	// ========================================
	
	public ArrayList<Garage> getGarageUnits() {
		return garageUnits;
	}
	
	public boolean addGarageUnit(Integer limit) {
		return garageUnits.add(new Garage(limit));
	}

	// ========================================
	@Override
	public String toString() {
		return String.format("Property: \"%s, %s\" %n%s", name, address, garageUnits);
	}
	
}
