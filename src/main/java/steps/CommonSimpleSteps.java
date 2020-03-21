package steps;

import org.openqa.selenium.WebElement;

import pages.CommonPage;

public class CommonSimpleSteps {
	CommonPage commonPage = new CommonPage();
	public void clickElement(String element) 	{
		WebElement webElement = commonPage.getWebElement(element);
		webElement.click();
	}
}
