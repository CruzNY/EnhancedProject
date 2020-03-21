package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonPage extends BasePageObject{
	public WebElement getWebElement(String key) {
		String[] elementLocator;
		String webLocatorType = elementLocator[0];
		String webElementValu = elementLocator[1];
		
		WebElement element = null;
		
		boolean retry = true;
		int counter = 0;
		while(retry && counter < 4) {
			try {
				switch(webLocatorType) {
					case "xpath": wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElementValu)));
					break;
					
					case "id": wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(webElementValu)));
					break;
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return element;
	}
}
	