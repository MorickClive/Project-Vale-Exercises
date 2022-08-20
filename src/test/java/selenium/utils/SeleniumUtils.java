package selenium.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	// Designed to return ChromeOptions to configure new ChromeDrivers in Selenium
	public static ChromeOptions chromeCfg(boolean headless) {
		Map<String, Object> prefs = new HashMap<String, Object>();
		ChromeOptions cOptions = new ChromeOptions();

		// Settings
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", true);
		prefs.put("profile.block_third_party_cookies", true);

		// Create ChromeOptions to disable Cookies pop-up
		cOptions.setExperimentalOption("prefs", prefs);
		cOptions.setHeadless(headless);
	    
		return cOptions;
	}

	// Designed to return FirefoxOptions to configure new FirefoxDriver in Selenium
	public static FirefoxOptions firefoxCfg() {
		FirefoxOptions cOptions = new FirefoxOptions();
		cOptions.addPreference("profile.default_content_setting_values.cookies", 2);
		cOptions.addPreference("network.cookie.cookieBehavior", 2);
		cOptions.addPreference("profile.block_third_party_cookies", true);

		return cOptions;
	}

	// @^4 Selenium
	// insert ref here
	public static EdgeOptions edgeCfg() {
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		EdgeOptions eOptions = new EdgeOptions();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", true);
		eOptions.setCapability("prefs", prefs);
		return eOptions;
	}
	
	public static void jsClick(WebDriver driver, String xpathString) {
		WebElement targ = driver.findElement(By.xpath(xpathString));

		JavascriptExecutor jsExe = (JavascriptExecutor) driver;
		jsExe.executeScript("arguments[0].click()", targ);
	}
	
	public static WebElement waitForVisibility(WebDriver driver, WebElement element) throws Error {
	       return new WebDriverWait(driver, 30)
	            .until(ExpectedConditions.visibilityOf(element));
	}

}
