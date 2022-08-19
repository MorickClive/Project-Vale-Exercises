package unit_test.garage.model.buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mc.exercises.garage.model.buildings.Garage;
import com.mc.exercises.garage.model.buildings.Property;

@ExtendWith(MockitoExtension.class)
public class PropertyTest {
	
	private static final String addressTitle = "testName";
	private static final String address = "testLocation";
	
	@Mock
	private static ArrayList<Garage> garageList;
	
	@InjectMocks
	private Property testStructure = new Property(addressTitle, address, null);
	
	@Test
	public void defaultConstructor() {
		testStructure = new Property();
		
		assertNotNull(testStructure);
		assertTrue(testStructure instanceof Property);
		assertEquals(testStructure.getName(), "???");
		assertEquals(testStructure.getAddress(), "???");
		assertEquals(testStructure.getGarageUnits(), new ArrayList<>());	
	}
	
	@Test
	public void allArgsConstructor() {
		assertNotNull(testStructure);
		assertTrue(testStructure instanceof Property);
		assertEquals(testStructure.getName(), addressTitle);
		assertEquals(testStructure.getAddress(), address);
		assertEquals(testStructure.getGarageUnits(), garageList);	
	}
	
	@Test
	public void method_getGarageUnits() {
		ArrayList<Garage> actual = testStructure.getGarageUnits();
		
		assertEquals(garageList, actual);		
	}
	
	@Test
	public void method_addGarageUnit() {
		// RULE
		Mockito.when(garageList.add(Mockito.any(Garage.class))).thenReturn(true);
		
		// ACTION
		boolean actual = testStructure.addGarageUnit(20);
		
		// RESULT
		assertEquals(true, actual);
		Mockito.verify(garageList, Mockito.times(1)).add(Mockito.any(Garage.class));
	}
	
	@Test
	public void method_toString() {
		String expected = "Property: \"testName, testLocation\" \r\ngarageList";
		String actual = testStructure.toString();

		assertEquals(expected, actual);
	}
	
	@Test
	public void methodHashCode() {
		Property localInstance1 = new Property(addressTitle, address, garageList);
		Property localInstance2 = new Property(addressTitle, address, garageList);

		assertTrue(localInstance1.hashCode() == localInstance2.hashCode());
	}
	
	@Test
	public void methodHashCode_Failure() {
		Property localInstance = new Property();

		assertTrue(localInstance.hashCode() != testStructure.hashCode());
	}
	
	@Test
	public void methodEqualsTo() {
		Property localInstance1 = new Property(addressTitle, address, garageList);
		Property localInstance2 = new Property(addressTitle, address, garageList);

		assertTrue(localInstance1.equals(localInstance2) && localInstance2.equals(localInstance1));
	}
	
	@Test
	public void methodEqualsTo_Failure() {
		Property localInstance = new Property();

		assertTrue(!localInstance.equals(testStructure));
	}
}
