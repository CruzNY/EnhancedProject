@run 
Feature: Create a new user 
Scenario: Navigate to page and create a new user 
	Given User navigates to the login page 
	And User enters login id 
	And User enters password 
	And User clicks on the login button 
	And User verifies login page is displayed 
	And User click on "New Customer" link 
	Then User enters name 
	And User selects gender 
	And User enteres date of birth 
	And User enters address 
	And User enteres city 
	And User enteres state 
	And User enteres pin 
	And User enteres mobile number 
	And User enteres email 
	And User enteres password 
	And User click on "Submit" button 