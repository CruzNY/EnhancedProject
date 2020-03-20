package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.driver.DriverFactory;


public class BasePageObject extends DriverFactory{
	protected WebDriverWait wait;
	protected JavascriptExecutor jsExecutor;
	public PropertyReader prop; 
	public BasePageObject() {
		this.wait = new WebDriverWait(driver, 15);
		jsExecutor = ((JavascriptExecutor) driver);
		prop = new PropertyReader();
	}

	//Click Methods
	public void waitAndClickElement(WebElement element)throws InterruptedException {
		boolean clicked = false;
		int attempts = 0;
		while(!clicked && attempts < 4) {
			try {
				this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
//				System.out.println("Successfully clicked " + "<" + element.toString() + ">");
				logger.info("Successfully clicked " + "<" + element.toString() + ">");
				clicked = true;
			}catch(Exception e) {
//				System.out.println("Unsuccessfully clicked. Exception: " +e.getMessage());
				logger.info("Unsuccessfully clicked. Exception: " +e.getMessage());
				Assert.fail("Unable to wait and click on the WebElement, using locator: " + "<" + element.toString() + ">");
			}
			attempts++;			
		}
	}
	// Send Keys Methods
	public void sendKeysToWebElement(WebElement element, String text) {
		try {
			this.WaitUntilWebElementIsVisible(element);
			element.clear();
			element.sendKeys(text);
			System.out.println(text + " Successfully entered");		
		}catch(Exception e) {
			System.out.println("Unable to locate WebElement: " + "<" + element.toString() + "> and send the following keys: " + text);
			Assert.fail("Unable to send keys to WebElement, Exception: " + e.getMessage());
		}
	}
	// Waiting Methods
	public boolean WaitUntilWebElementIsVisible(WebElement element) {
		try {
			this.wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println(element.toString());
			return true;
		}catch(Exception e) {
			System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
			Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
			return false;
		}
	}
	
	// Page Methods
	public void waitTillPageIsCompletelyLoaded() {
		this.wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}
}
