package com.mc.exercises.garage.model.buildings;

import java.util.ArrayList;

public class Property {
	
	private String name;
	private String address;
	
	private ArrayList<Garage> garageUnits;
	
	public Property() {
		super();
		garageUnits = new ArrayList<>();
		name = "???";
		address = "???";
	}
	
	public Property(String name, String address) {
		this();
		this.name = name;
		this.address = address;
	}

	// ========================================

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Garage> getGarageUnits() {
		return garageUnits;
	}

	public void setGarageUnits(ArrayList<Garage> garageUnits) {
		this.garageUnits = garageUnits;
	}

	// ========================================
	@Override
	public String toString() {
		return "Property [name=" + name + ", address=" + address + ", garageUnits=" + garageUnits + "]";
	}
	
}
