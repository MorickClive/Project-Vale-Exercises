package exercises.strings;

import org.junit.jupiter.api.Test;

import exercises.utils.OPTIONS;

public class StringTest {

	@Test
	public void displayMenu_Enums() {
		int increment = 0;
		System.out.format("%1$s%n%2$s%n%1$s%n", "=".repeat(40), "Menu");

		for (OPTIONS value : OPTIONS.values()) {
			++increment;
			System.out.format("\t%d) %s%n", increment, value);
		}

	}

	@Test
	public void contains() {
		System.out.println("FRIEND".toLowerCase().contains("end"));
	}

	@Test
	public void reverse() {
		System.out.println(new StringBuilder().append("word").reverse());
	}
}