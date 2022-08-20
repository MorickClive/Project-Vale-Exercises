package selenium.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import selenium.pom.google.GooglePortalPage;

public class InitialTest {

	@Test
	public void seleniumRefresher() throws InterruptedException {
			seleniumDriver();
	}

	private static void seleniumDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/selenium/chrome/chromedriver.exe");
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

}
