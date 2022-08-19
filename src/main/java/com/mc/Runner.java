package com.mc;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class Runner {

	public static void main(String[] args) {
		System.out.format("Hello World!%n");
		
		printDuplicates("howtodoinjava dot com".toCharArray());
		
	}
	
	// ========================================
	
	private static void printDuplicates(char[] charArray) {

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
	
	private static void seleniumRefresher() {
		try {
			seleniumDriver();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void seleniumDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/selenium/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver(chromeConfig());

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
		driver.manage().window().fullscreen();
		driver.get("https://www.google.com/");
		
		GooglePortalPage googlePage = PageFactory.initElements(driver, GooglePortalPage.class);
		
		googlePage.searchTerm("Kittens");
		driver.navigate().back();
		
		
		driver.quit();
	}
	
	private static ChromeOptions chromeConfig() {
		 Map<String, Object> prefs = new HashMap<String, Object>();
		 ChromeOptions cOptions = new ChromeOptions();
		  
		 // Settings
		 prefs.put("profile.default_content_setting_values.cookies", 2);
		 prefs.put("network.cookie.cookieBehavior", 2);
		 prefs.put("profile.block_third_party_cookies", true);

		 // Create ChromeOptions to disable Cookies pop-up
		 cOptions.setExperimentalOption("prefs", prefs);

		 return cOptions;
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
	
	public void primes() {
		for (int i = 1; i < 100; i++) {
			if (isPrime(i))
				System.out.format("%d, ", i);
		}
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
