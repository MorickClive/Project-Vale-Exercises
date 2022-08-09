package com.mc.exercises.garage.model.buildings;

import java.util.HashMap;
import java.util.stream.Collectors;

import com.mc.exercises.garage.model.vehicles.interfaces.Vehicle;

public class Garage {

	private static int idIncrementer = 0;

	private HashMap<Integer, Vehicle> myContents;
	private Integer capacity;

	public Garage(Integer vehicleCapacity) {
		super();
		this.myContents = new HashMap<>();
		this.capacity = vehicleCapacity;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public boolean add(Vehicle vehicle) {
		if (myContents.size() - 1 < capacity && !myContents.containsKey(idIncrementer + 1)) {
			myContents.put(idIncrementer++, vehicle);
			return true;
		} else {
			return false;
		}
	}

	public Vehicle getVehicle(Integer id) {
		return myContents.get(id);
	}

	public void displayVehicle(Integer id) {
		if (myContents.containsKey(id)) {
			System.out.println(myContents.get(id));
		} else {
			System.out.format("Display Failed: Vehicle id:[%d] not found!%n", id);
		}
	}

	public void displayContents() {
		if (myContents.size() > 0) {
			myContents.values().stream().forEach(x -> System.out.println(x));
		} else {
			System.out.println("Garage is empty!");
		}
	}

	public void editVehicle(Integer id, Vehicle vehicle) {
		if(myContents.containsKey(id)) {
			myContents.replace(id, vehicle);
		} else {
			System.out.format("Edit Failed: Vehicle id:[%d] not found!%n", id);
		}
	}

	public boolean remove(Integer id) {
		return myContents.remove(id) != null;
	}

	// ========================================

	@Override
	public String toString() {
		return String.format("Garage[%d LIMIT]:\n %s", 
				capacity, 
					myContents.size() > 0 ? 
					myContents.values().stream().collect(Collectors.toList()).toString() :
					"[Empty]"
				);
	}

}
