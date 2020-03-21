package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.driver.DriverFactory;


public class MasterHooks extends DriverFactory{
	
	@Before
	public void setUp() {
		driver = getDriver();
	}
	
	@After
	public void tearDown() {
		if(driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}
}
