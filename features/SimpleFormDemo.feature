@SimpleFormDemo
Feature: Fill in simple forms
Scenario Outline: Single Field Input
Given User navigates to simple form webpage
And User enters "<Message>" into message 	textbox
And User clicks on show message button
Then User verifies message is displayed as "<Message>"


Examples: 
	|Message|
	|This is a message|