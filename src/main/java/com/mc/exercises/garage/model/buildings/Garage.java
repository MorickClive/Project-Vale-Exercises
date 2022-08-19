package com.mc.exercises.garage.model.buildings;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mc.exercises.garage.model.vehicles.Car;
import com.mc.exercises.garage.model.vehicles.interfaces.Vehicle;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Garage {

	private static int idIncrementer = 0;

	@Getter
	private Integer capacity;
	private HashMap<Integer, Vehicle> myContents;
	
	public Garage() {
		super();
		this.myContents = new HashMap<>();
		this.capacity = 20;
	}
	
	public Garage(Integer vehicleCapacity) {
		super();
		this.myContents = new HashMap<>();
		this.capacity = vehicleCapacity;
	}
	
	public Garage(HashMap<Integer, Vehicle> contentsMap, Integer vehicleCapacity) {
		super();
		this.myContents = contentsMap;
		this.capacity = vehicleCapacity;
	}
	
	// ========================================

	public boolean add(Vehicle vehicle) {
		if (myContents.size() - 1 < capacity && !myContents.containsKey(idIncrementer + 1)) {
			myContents.put(++idIncrementer, vehicle);
			return true;
		} else {
			return false;
		}
	}

	public Vehicle getVehicle(Integer id) {
		return myContents.get(id);
	}

	public String displayVehicle(Integer id) {
		String message = 
				myContents.containsKey(id) ? 
				myContents.get(id).toString() :
				String.format("Display Failed: Vehicle id:[%d] not found!", id);
		
		System.out.println(message);
		
		return message;
	}

	public String displayContents() {
		StringBuilder sb;
		String message = "";
		
		if (myContents.size() > 0) {
			sb = new StringBuilder();
			myContents.values().stream().forEach(x -> sb.append(x+"\n"));
			message = sb.toString();
		} else {
			message = "Garage is empty!";
		}
		
		System.out.println(message);
		
		return message;
	}

	public boolean editVehicle(Integer id, Vehicle vehicle) {
		if(myContents.containsKey(id)) {
			myContents.replace(id, vehicle);
			return true;
		} else {
			System.out.format("Edit Failed: Vehicle id:[%d] not found!%n", id);
		}
		return false;
	}

	public boolean remove(Integer id) {
		return myContents.remove(id) != null;
	}

	// ========================================

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		myContents.values().stream()
		.forEach( x -> sb.append(String.format("\t- %s%n", x.toString())) );
		
		return String.format("Garage[%d LIMIT]:%n%s", 
					capacity, myContents.size() > 0 ?
					sb.toString() : 
					"[Empty]"
				);
		
	}

}
