package unit_test.garage.model.vehicles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mc.exercises.garage.model.vehicles.MotorBike;
import com.mc.exercises.garage.model.vehicles.MotorBike;

public class MotorBikeTest {
	
	private static MotorBike testBike;
	
	private final String testModel = "Volvo";
	private final Float testMilage = 15000.0f;
	private final Integer testNumWheels = 4;
	
	@BeforeEach
	public void testSetup() {
		testBike = new MotorBike(testModel, testMilage, testNumWheels);
	}
	
	@Test
	public void defaultConstructor() {
		testBike = new MotorBike();
		
		assertNotNull(testBike);
		assertTrue(testBike instanceof MotorBike);
		assertEquals(testBike.getModel(), "???");
		assertEquals(testBike.getMilage(), 0.0f);
		assertEquals(testBike.getNumWheels(), 2);
	}
	
	@Test
	public void constructorParams1() {
		testBike = new MotorBike(testModel, testMilage, testNumWheels);

		assertNotNull(testBike);
		assertTrue(testBike instanceof MotorBike);
		assertEquals(testBike.getModel(), testModel);
		assertEquals(testBike.getMilage(), testMilage);
		assertEquals(testBike.getNumWheels(), testNumWheels);
	}
	
	@Test
	public void methodDescription() {
		String expected = "[MotorBike]: Model: Volvo, Milage: 15000.0, Number of Wheels: 4";
		String actual;
		
		actual = testBike.description();
				
		assertEquals(expected, actual);
	}
	
	@Test
	public void methodToString() {
		String expected = "[MotorBike]: Model: Volvo, Milage: 15000.0, Number of Wheels: 4";
		String actual;
		
		actual = testBike.toString();
				
		assertEquals(expected, actual);
	}
	
	@Test
	public void methodHashCode() {
		MotorBike localInstance = new MotorBike(testModel, testMilage, testNumWheels);

		assertTrue(localInstance.hashCode() == testBike.hashCode());
	}
	
	@Test
	public void methodHashCode_Failure() {
		MotorBike localInstance = new MotorBike();

		assertTrue(localInstance.hashCode() != testBike.hashCode());
	}
	
	@Test
	public void methodEqualsTo() {
		MotorBike localInstance = new MotorBike(testModel, testMilage, testNumWheels);

		assertTrue(localInstance.equals(testBike) && testBike.equals(localInstance));
	}
	
	@Test
	public void methodEqualsTo_Failure() {
		MotorBike localInstance = new MotorBike();

		assertTrue(!localInstance.equals(testBike));
	}
}
