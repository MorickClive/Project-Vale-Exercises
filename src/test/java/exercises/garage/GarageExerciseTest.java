package exercises.garage;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.mc.exercises.garage.model.buildings.Garage;
import com.mc.exercises.garage.model.buildings.Property;
import com.mc.exercises.garage.model.vehicles.Car;
import com.mc.exercises.garage.model.vehicles.MotorBike;
import com.mc.exercises.garage.model.vehicles.Truck;

public class GarageExerciseTest {
	
	private static String DIV = "=".repeat(40);

	@Test
	public void test() {

		Garage myGarage;
		Property myHouse = new Property("23 GreenTest road", "town, county, region", new ArrayList<>());
		myHouse.addGarageUnit(20);
		
		myGarage = myHouse.getGarageUnits().get(0);

		// CREATE
		// ========================================
		myGarage.add(new Car("Volvo", 15000f, 4));
		myGarage.add(new Truck("BMW", 13500f, 4));
		myGarage.add(new MotorBike("Honda", 1570f, 4));
		myGarage.add(new MotorBike("Honda", 1570f, 4));
		
		// DISPLAY
		// ========================================
		System.out.format("%n%1$s %n%2$s %n%1$s %n", DIV, "Garage Contents");
		myGarage.displayContents();

		// EDIT
		// ========================================
		myGarage.editVehicle(3, new Car("+Honda+", 1570f, 4));
		
		System.out.format("%n%1$s %n%2$s %n%1$s %n", DIV, "POST-EDIT: Garage Contents");
		myGarage.displayContents();
		
		// REMOVAL
		// ========================================
		myGarage.remove(4);
		
		System.out.format("%n%1$s %n%2$s %n%1$s %n", DIV, "POST-REMOVAL: Garage Contents");
		myGarage.displayContents();
		
		// OVERVIEW
		// ========================================
		System.out.format("%n%1$s %n%2$s %n%1$s %n", DIV, "House Print");
		System.out.println(myHouse);
	}
	
}
