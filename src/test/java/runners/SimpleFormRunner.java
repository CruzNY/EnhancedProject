package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"features/"},
		glue = {"stepDefinitions"},
		tags = "@SimpleFormDemo",
		plugin = {"pretty", "html:target/cucumber-reports/newCustomer"},
		monochrome = true
		)
public class SimpleFormRunner {

}
