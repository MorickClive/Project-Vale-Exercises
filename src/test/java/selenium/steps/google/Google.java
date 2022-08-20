package selenium.steps.google;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenium.pom.google.GooglePortalPage;
import selenium.utils.SeleniumUtils;

public class Google {

	private static WebDriver driver;
	private static GooglePortalPage google;
	
	@Given("I can load google")
	public void i_can_load_google() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/selenium/chromedriver.exe");
		driver = new ChromeDriver(SeleniumUtils.chromeCfg(false));
		driver.manage().window().fullscreen();
		
		google = PageFactory.initElements(driver, GooglePortalPage.class);
		google.homePage();
	}
	@When("I search for {string}")
	public void i_search_for_animal(String string) {
		google.searchTerm(string);
	}
	@When("I navigate to images")
	public void when_i_navigate_to_images() {
		google.imageTab.navigate();
	}
	@Then("I should be able to see pictures of {string}")
	public void i_should_be_able_to_see_pictures_of_kittens(String string) throws InterruptedException {
		String result = "";
		
		google.imageTab.clickImage(1);
		result = google.imageTab.imageTitle().toLowerCase();
		
		assertTrue(result.contains(string));
	}
	
	@After
	public void afterEach() {
		driver.close();
		driver.quit();
	}
	
}
