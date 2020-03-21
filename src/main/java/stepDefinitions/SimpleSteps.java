package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import steps.CommonSimpleSteps;

public class SimpleSteps {
	CommonSimpleSteps CommonSimpleSteps = new CommonSimpleSteps();
	@Given("^User clicks on \"([^\"]*)\" button$")
	public void user_clicks_on_button(String element){
		
	}
}
