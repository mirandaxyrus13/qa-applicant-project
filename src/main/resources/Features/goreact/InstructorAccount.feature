Feature: Instructor Account

@InstructorAccountRegressionTesting
Scenario: Instructor Account Creation for Higher Education Institution Instructor
	Description: Able to sign up as an Instructor for Higher Education Institution
	
	Given I am an End User in Go React
	When I create an account as an "Instructor"
	And I enter the Instructor Account details for "Higher Education Institution"
	And I configure the Account Setup for "Higher Education Institution"
	Then I am able to sign up as an Instructor for "Higher Education Institution"
