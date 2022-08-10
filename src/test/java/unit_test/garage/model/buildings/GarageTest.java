package unit_test.garage.model.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mc.exercises.garage.model.buildings.Garage;
import com.mc.exercises.garage.model.vehicles.Car;
import com.mc.exercises.garage.model.vehicles.interfaces.Vehicle;

@ExtendWith(MockitoExtension.class)
public class GarageTest {

	private static final Vehicle testVehicle = new Car();
	private static final Integer defaultLimit = 20;
	
	@Mock
	private static HashMap<Integer, Vehicle> mockVehicleMap;
	
	@InjectMocks
	private Garage testStructure = new Garage(defaultLimit);
	
	@Test
	public void defaultConstructor() {
		testStructure = new Garage();
		
		assertNotNull(testStructure);
		assertTrue(testStructure instanceof Garage);
		assertEquals(testStructure.getCapacity(), defaultLimit);
	}
	
	@Test
	public void constructor_variant1() {
		assertNotNull(testStructure);
		assertTrue(testStructure instanceof Garage);
		assertEquals(testStructure.getCapacity(), defaultLimit);
	}
	
	@Test
	public void allArgsConstructor() {
		testStructure = new Garage(new HashMap<>(), defaultLimit);
		
		assertNotNull(testStructure);
		assertTrue(testStructure instanceof Garage);
		assertEquals(testStructure.getCapacity(), defaultLimit);	
	}

	@Test
	public void method_add() {
		// RULE
		Mockito.when(mockVehicleMap.size()).thenReturn(1);
		Mockito.when(mockVehicleMap.containsKey(1)).thenReturn(false);
		Mockito.when(mockVehicleMap.put(Mockito.any(), Mockito.any(Vehicle.class))).thenReturn(GarageTest.testVehicle);
		
		// ACTION
		boolean actual = testStructure.add(GarageTest.testVehicle);
		
		// RESULT
		assertTrue(actual);
		Mockito.verify(mockVehicleMap, Mockito.times(1)).size();
		Mockito.verify(mockVehicleMap, Mockito.times(1)).containsKey(1);
		Mockito.verify(mockVehicleMap, Mockito.times(1)).put(Mockito.any(), Mockito.any(Vehicle.class));
	}

	@Test
	public void method_get() {
		// RULE
		Mockito.when(mockVehicleMap.get(1)).thenReturn(testVehicle);
		
		// ACTION
		Vehicle actual = testStructure.getVehicle(1);
		
		// RESULT
		assertEquals(testVehicle, actual);
		Mockito.verify(mockVehicleMap, Mockito.times(1)).get(1);
	}

	@Test
	public void method_displayVehicle() {
		// RESOURCES
		String expected = testVehicle.toString();
		
		// RULE
		Mockito.when(mockVehicleMap.containsKey(1)).thenReturn(true);
		Mockito.when(mockVehicleMap.get(1)).thenReturn(testVehicle);
		
		// ACTION
		String actual = testStructure.displayVehicle(1);
		
		// RESULT
		assertEquals(expected, actual);
		Mockito.verify(mockVehicleMap, Mockito.times(1)).containsKey(1);
		Mockito.verify(mockVehicleMap, Mockito.times(1)).get(1);
	}

	@Test
	public void method_displayVehicle_failurePath() {
		// RESOURCES
		String expected = "Display Failed: Vehicle id:[1] not found!";
		
		// RULE
		Mockito.when(mockVehicleMap.containsKey(1)).thenReturn(false);
		
		// ACTION
		String actual = testStructure.displayVehicle(1);
		
		// RESULT
		assertEquals(expected, actual);
		Mockito.verify(mockVehicleMap, Mockito.times(1)).containsKey(1);
	}

	@Test
	public void method_displayContents() {
		// RESOURCES
		String expected = testVehicle.toString();
		ArrayList<Vehicle> testArray = new ArrayList<>();
		testArray.add(testVehicle);
		
		// RULE
		Mockito.when(mockVehicleMap.size()).thenReturn(1);
		Mockito.when(mockVehicleMap.values()).thenReturn(testArray);
		
		// ACTION
		String actual = testStructure.displayContents();
		
		// RESULT
		assertEquals(expected, actual);
		Mockito.verify(mockVehicleMap, Mockito.times(1)).size();
		Mockito.verify(mockVehicleMap, Mockito.times(1)).values();
	}
	
	@Test
	public void method_displayContents_failurePath() {
		// RESOURCES
		String expected = "Garage is empty!";
		
		// RULE
		Mockito.when(mockVehicleMap.size()).thenReturn(0);
		
		// ACTION
		String actual = testStructure.displayContents();
		
		// RESULT
		assertEquals(expected, actual);
		Mockito.verify(mockVehicleMap, Mockito.times(1)).size();
	}
	
	@Test
	public void method_editVehicle() {		
		// RULE
		Mockito.when(mockVehicleMap.containsKey(1)).thenReturn(true);
		Mockito.when(mockVehicleMap.replace(1, testVehicle)).thenReturn(testVehicle);
		
		// ACTION
		boolean actual = testStructure.editVehicle(1, testVehicle);
		
		// RESULT
		assertTrue(actual);
		Mockito.verify(mockVehicleMap, Mockito.times(1)).containsKey(1);
		Mockito.verify(mockVehicleMap, Mockito.times(1)).replace(1, testVehicle);
	}
	
	@Test
	public void method_editVehicle_failurePath() {		
		// RULE
		Mockito.when(mockVehicleMap.containsKey(1)).thenReturn(false);
		
		// ACTION
		boolean actual = testStructure.editVehicle(1, testVehicle);
		
		// RESULT
		assertFalse(actual);
		Mockito.verify(mockVehicleMap, Mockito.times(1)).containsKey(1);
	}

	@Test
	public void method_remove() {
		// RULE
		Mockito.when(mockVehicleMap.remove(1)).thenReturn(testVehicle);
		
		// ACTION
		boolean actual = testStructure.remove(1);
		
		// RESULT
		assertTrue(actual);
		Mockito.verify(mockVehicleMap, Mockito.times(1)).remove(1);
	}
	
	@Test
	public void method_remove_failurePath() {
		// RULE
		Mockito.when(mockVehicleMap.remove(1)).thenReturn(null);
		
		// ACTION
		boolean actual = testStructure.remove(1);
		
		// RESULT
		assertFalse(actual);
		Mockito.verify(mockVehicleMap, Mockito.times(1)).remove(1);
	}
	
	@Test
	public void method_add_failureRoute() {
		// RULE
		Mockito.when(mockVehicleMap.size()).thenReturn(1);
		Mockito.when(mockVehicleMap.containsKey(1)).thenReturn(true);
		
		// ACTION
		boolean actual = testStructure.add(GarageTest.testVehicle);
		
		// RESULT
		assertFalse(actual);
		Mockito.verify(mockVehicleMap, Mockito.times(1)).size();
		Mockito.verify(mockVehicleMap, Mockito.times(1)).containsKey(1);
	}
	
	@Test
	public void method_toString() {
		// RULE
		Mockito.when(mockVehicleMap.size()).thenReturn(0);
		
		// ACTION
		String expected = "Garage[20 LIMIT]:\r\n[Empty]";
		String actual = testStructure.toString();
		
		//RESULT
		assertEquals(expected, actual);
		Mockito.verify(mockVehicleMap, Mockito.times(1)).size();
	}
	
	@Test
	public void method_toString_filledArrayPath() {
		// RESOURCES
		ArrayList<Vehicle> testArray = new ArrayList<>();
		testArray.add(testVehicle);
		
		// RULE
		Mockito.when(mockVehicleMap.size()).thenReturn(1);
		Mockito.when(mockVehicleMap.values()).thenReturn(testArray);
		
		// ACTION
		String expected = "Garage[20 LIMIT]:\r\n[[Car]: Model: ???, Milage: 0.0, Number of Wheels: 4]";
		String actual = testStructure.toString();
		
		//RESULT
		assertEquals(expected, actual);
		Mockito.verify(mockVehicleMap, Mockito.times(1)).size();
		Mockito.verify(mockVehicleMap, Mockito.times(1)).values();
	}
	
	@Test
	public void methodHashCode() {
		Garage localInstance1 = new Garage(defaultLimit);
		Garage localInstance2 = new Garage(defaultLimit);

		assertTrue(localInstance1.hashCode() == localInstance2.hashCode());
	}
	
	@Test
	public void methodHashCode_Failure() {
		Garage localInstance = new Garage(mockVehicleMap, defaultLimit+1);

		assertTrue(localInstance.hashCode() != testStructure.hashCode());
	}
	
	@Test
	public void methodEqualsTo() {
		Garage localInstance1 = new Garage(defaultLimit);
		Garage localInstance2 = new Garage(defaultLimit);

		assertTrue(localInstance1.equals(localInstance2) && localInstance2.equals(localInstance1));
	}
	
	@Test
	public void methodEqualsTo_Failure() {
		Garage localInstance = new Garage(defaultLimit+1);

		assertFalse(localInstance.equals(testStructure));
	}
}
