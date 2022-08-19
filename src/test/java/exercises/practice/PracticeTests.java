package exercises.practice;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class PracticeTests {
	
	@Test
	public void printDuplicate() {
		printDuplicates("howtodoinjava dot com".toCharArray());
	}
	
	@Test
	public void primeTest() {
		for (int i = 1; i < 100; i++) {
			if (isPrime(i))
				System.out.format("%d, ", i);
		}
		System.out.println("");
	}
	
	@Test
	public void fizzBuzz_1() {
		fizzBuzzLOOP(50);
	}
	
	@Test
	public void fizzBuzz_2() {
		fizzBuzzStream(50);
	}
	
	private void printDuplicates(char[] charArray) {

		HashMap<Character, Integer> uniqueChars = new HashMap<>();
		
		for(char item : charArray) {
			if(!uniqueChars.containsKey(item) && item != '\s') {
				uniqueChars.put(item, 0);
			}
		}
		
		for(Entry<Character, Integer> set : uniqueChars.entrySet()) {
			for(char item : charArray) {
				if(set.getKey().equals(item)) {
					set.setValue(set.getValue() + 1);
				}
			}
		}
		
		for(Character set : uniqueChars.keySet()) {
			if(uniqueChars.get(set) > 1) {
				System.out.println("[Double]: " + set);
			}
		}
	}
	
	public boolean isPrime(float n) {
		if (n <= 1)
			return false;

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	public void fizzBuzzLOOP(int maxRange) {
		for (int i = 2; i <= maxRange; i++) {
			fizzBuzz(i);
		}
	}

	public void fizzBuzzStream(int maxRange) {
		IntStream.rangeClosed(1, maxRange).mapToObj(
				i -> (i % 5 == 0) ? (i % 7 == 0 ? "fizzBuzz" : "fizz") : (i % 7 == 0 ? "Buzz" : String.valueOf(i)))
				.forEach(System.out::println);
	}

	public void fizzBuzz(float n) {

		if (n % 7 == 0 && n % 5 == 0) {
			System.out.println("fizzBuzz");
		} else if (n % 5 == 0) {
			System.out.println("fizz");
		} else if (n % 7 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println((int) n);
		}
	}

}
