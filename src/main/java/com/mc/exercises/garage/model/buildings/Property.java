package com.mc.exercises.garage.model.buildings;

import java.util.ArrayList;

public class Property {
	
	private String addressTitle;
	private String address;
	
	private ArrayList<Garage> garageUnits;
	
	public Property() {
		super();
		garageUnits = new ArrayList<>();
		addressTitle = "???";
		address = "???";
	}
	
	public Property(String name, String address) {
		this();
		this.addressTitle = name;
		this.address = address;
	}

	// ========================================

	public String getName() {
		return addressTitle;
	}

	public void setName(String name) {
		this.addressTitle = name;
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
	
	public void addGarageUnit(Integer limit) {
		garageUnits.add(new Garage(limit));
	}

	// ========================================
	@Override
	public String toString() {
		return String.format("Property: \"%s, %s\" %n%s", addressTitle, address, garageUnits);
	}
	
}
