package util.driver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.PageFactory;

//import pageObjects.Login;
//import pageObjects.NewCustomer;
//import pageObjects.SimpleForm;
//import steps.common.CommonSteps;
import util.config.Constant;
import util.io.ReadConfigFile;

public class DriverFactory {
	public static WebDriver driver;
//	public static Login login;
//	public static NewCustomer newCustomer;
//	public static CommonSteps commonSteps;
//	public static SimpleForm simpleForm;
	public static Logger logger = Logger.getLogger("DriverFactory");
	public WebDriver getDriver() {
		try {
			ReadConfigFile file = new ReadConfigFile();
			String browserName = file.getBrowser();

			switch (browserName) {
			case "chrome":
				if (null == driver) {
					logger.info("Opening chrome browesr ");
					System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				break;
			case "firefox":
				if (null == driver) {
					System.setProperty("webdriver.gecko.driver", Constant.FIREFOX_DRIVER_DIRECTORY);
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver();
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Unable to load browser"+ e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//			login = PageFactory.initElements(driver, Login.class);
//			newCustomer = PageFactory.initElements(driver,NewCustomer.class);
//			simpleForm = PageFactory.initElements(driver, SimpleForm.class);
		}
		return driver;
	}
}
