package exercises.utils;

import java.util.Scanner;

public class Console {

	private static Scanner input;

	private Console() {
		super();
	}

	public static Scanner getScanner() {
		if (input == null) {
			input = new Scanner(System.in);
		}

		return input;
	}

	public static String input() {
		return getScanner().nextLine();
	}

	public static String askInput(String str) {
		System.out.format("%s:%n", str);
		return input();
	}

	public static boolean closeScanner() {
		try {
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("[RESOURCE]: Scanner closed Successfully!");
		return true;
	}

}