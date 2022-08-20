package selenium.pom.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.utils.SeleniumUtils;

public class GooglePortalPage {
	
	private static final String URL = "https://www.google.com";

	@FindBy(name = "q")
	private WebElement search;
	
	private WebDriver driver;
	
	public GoogleImagePage imageTab;

	public GooglePortalPage(WebDriver driver) {
		super();
		
		this.driver = driver;
		imageTab = PageFactory.initElements(driver, GoogleImagePage.class);
	}
	
	public void homePage() {
		driver.get("https://www.google.com");
	}

	public void searchTerm(String term) {
		search.sendKeys(term);
		search.submit();
	};

}