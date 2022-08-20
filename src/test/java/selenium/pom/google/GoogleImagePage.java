package selenium.pom.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.utils.SeleniumUtils;

public class GoogleImagePage {
	
	@FindBy(css = "#hdtb-msb > div:nth-child(1) > div > div:nth-child(2) > a")
	private WebElement imageTab;

	private WebDriver driver;
	private WebElement tabImage;
	
	public GoogleImagePage(WebDriver driver) {
		super();
		
		this.driver = driver;
	}
	
	public void navigate() {
		imageTab.click();
	}
	
	public void clickImage(int index) {
		String selector = String.format("//*[@id=\"islrg\"]/div[1]/div[%d]", index);
		
		new WebDriverWait(driver, 0).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(selector))).click();
	}
	
	public String imageTitle() {
		String selector = "//*[@id=\"Sva75c\"]/div/div/div[3]/div[2]/c-wiz/div/div[1]/div[3]/div[1]/a[1]/h1";
		
		return new WebDriverWait(driver, 0).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(selector))).getText();
	}

}
