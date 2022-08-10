package unit_test.garage.model.vehicles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mc.exercises.garage.model.vehicles.Car;

public class CarTest {
	
	private static Car testCar;
	
	private final String testModel = "Volvo";
	private final Float testMilage = 15000.0f;
	private final Integer testNumWheels = 4;
	
	@BeforeEach
	public void testSetup() {
		testCar = new Car(testModel, testMilage, testNumWheels);
	}
	
	@Test
	public void defaultConstructor() {
		testCar = new Car();
		
		assertNotNull(testCar);
		assertTrue(testCar instanceof Car);
		assertEquals(testCar.getModel(), "???");
		assertEquals(testCar.getMilage(), 0.0f);
		assertEquals(testCar.getNumWheels(), 4);
	}
	
	@Test
	public void constructorParams1() {
		testCar = new Car(testModel, testMilage, testNumWheels);

		assertNotNull(testCar);
		assertTrue(testCar instanceof Car);
		assertEquals(testCar.getModel(), testModel);
		assertEquals(testCar.getMilage(), testMilage);
		assertEquals(testCar.getNumWheels(), testNumWheels);
	}
	
	@Test
	public void methodDescription() {
		String expected = "[Car]: Model: Volvo, Milage: 15000.0, Number of Wheels: 4";
		String actual;
		
		actual = testCar.description();
				
		assertEquals(expected, actual);
	}
	
	@Test
	public void methodToString() {
		String expected = "[Car]: Model: Volvo, Milage: 15000.0, Number of Wheels: 4";
		String actual;
		
		actual = testCar.toString();
				
		assertEquals(expected, actual);
	}
	
	@Test
	public void methodHashCode() {
		Car localInstance = new Car(testModel, testMilage, testNumWheels);

		assertTrue(localInstance.hashCode() == testCar.hashCode());
	}
	
	@Test
	public void methodHashCode_Failure() {
		Car localInstance = new Car();

		assertTrue(localInstance.hashCode() != testCar.hashCode());
	}
	
	@Test
	public void methodEqualsTo() {
		Car localInstance = new Car(testModel, testMilage, testNumWheels);

		assertTrue(localInstance.equals(testCar) && testCar.equals(localInstance));
	}
	
	@Test
	public void methodEqualsTo_Failure() {
		Car localInstance = new Car();

		assertTrue(!localInstance.equals(testCar));
	}
}
