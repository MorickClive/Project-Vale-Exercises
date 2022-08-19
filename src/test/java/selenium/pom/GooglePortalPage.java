package selenium.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePortalPage {

	@FindBy(name = "q")
	private WebElement search;

	public GooglePortalPage() {
		super();
	}

	public void searchTerm(String term) {
		search.sendKeys(term);
		search.submit();
	};

}