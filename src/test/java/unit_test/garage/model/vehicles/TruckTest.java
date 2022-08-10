package unit_test.garage.model.vehicles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mc.exercises.garage.model.vehicles.Truck;
import com.mc.exercises.garage.model.vehicles.Truck;

public class TruckTest {
	
	private static Truck testTruck;
	
	private final String testModel = "Volvo";
	private final Float testMilage = 15000.0f;
	private final Integer testNumWheels = 4;
	
	@BeforeEach
	public void testSetup() {
		testTruck = new Truck(testModel, testMilage, testNumWheels);
	}
	
	@Test
	public void defaultConstructor() {
		testTruck = new Truck();
		
		assertNotNull(testTruck);
		assertTrue(testTruck instanceof Truck);
		assertEquals(testTruck.getModel(), "???");
		assertEquals(testTruck.getMilage(), 0.0f);
		assertEquals(testTruck.getNumWheels(), 4);
	}
	
	@Test
	public void constructorParams1() {
		testTruck = new Truck(testModel, testMilage, testNumWheels);

		assertNotNull(testTruck);
		assertTrue(testTruck instanceof Truck);
		assertEquals(testTruck.getModel(), testModel);
		assertEquals(testTruck.getMilage(), testMilage);
		assertEquals(testTruck.getNumWheels(), testNumWheels);
	}
	
	@Test
	public void methodDescription() {
		String expected = "[Truck]: Model: Volvo, Milage: 15000.0, Number of Wheels: 4";
		String actual;
		
		actual = testTruck.description();
				
		assertEquals(expected, actual);
	}
	
	@Test
	public void methodToString() {
		String expected = "[Truck]: Model: Volvo, Milage: 15000.0, Number of Wheels: 4";
		String actual;
		
		actual = testTruck.toString();
				
		assertEquals(expected, actual);
	}
	
	@Test
	public void methodHashCode() {
		Truck localInstance = new Truck(testModel, testMilage, testNumWheels);

		assertTrue(localInstance.hashCode() == testTruck.hashCode());
	}
	
	@Test
	public void methodHashCode_Failure() {
		Truck localInstance = new Truck();

		assertTrue(localInstance.hashCode() != testTruck.hashCode());
	}
	
	@Test
	public void methodEqualsTo() {
		Truck localInstance = new Truck(testModel, testMilage, testNumWheels);

		assertTrue(localInstance.equals(testTruck) && testTruck.equals(localInstance));
	}
	
	@Test
	public void methodEqualsTo_Failure() {
		Truck localInstance = new Truck();

		assertTrue(!localInstance.equals(testTruck));
	}
}
