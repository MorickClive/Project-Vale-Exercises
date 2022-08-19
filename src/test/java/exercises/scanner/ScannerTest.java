package exercises.scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import exercises.utils.Console;
import exercises.utils.OPTIONS;

public class ScannerTest {

	private static OPTIONS activeOptions;
	private static String value;

	@Test
	public void runMenu_Path_1() {
		value = "1";
	}

	@Test
	public void runMenu_Path_2() {
		value = "2";
	}

	@Test
	public void runMenu_Path_3() {
		value = "3";
	}

	@Test
	public void runMenu_Path_4() {
		value = "4";
	}

	@Test
	public void runMenu_Path_null() {
		value = null;
	}

	@Test
	public void runMenu_Path_empty() {
		value = "";
	}

	@Test
	public void runMenu_Path_default() {
		value = "default1";
	}

	@AfterEach
	public void runMenu() {
		try {
		switch (value) {
		case "1":
			activeOptions = OPTIONS.CREATE;
			break;
		case "2":
			activeOptions = OPTIONS.READ;
			break;

		case "3":
			activeOptions = OPTIONS.UPDATE;
			break;

		case "4":
			activeOptions = OPTIONS.DELETE;
			break;

		default:
			activeOptions = null;
		}
		}catch (Exception e) {
			activeOptions = null;
			System.out.format("\t[EXCEPTION]: %1$s", e.getMessage());
		}

		System.out.format("[Input]: %s%n", value);
		System.out.format("[OPTION CHOICE]: %s%n", activeOptions);
	}

	public void scanner() {
		// MENU
		// ========================================
		String value = Console.askInput("Please enter number");
		Console.closeScanner();
	}
}