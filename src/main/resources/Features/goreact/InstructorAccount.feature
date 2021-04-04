Feature: Instructor Account

@InstructorAccountRegressionTesting
Scenario: Instructor Account Creation for Higher Education Institution Instructor
	Description: Able to sign up as an Instructor for Higher Education Institution
	
	Given I am an End User in Go React
	When I create an account as an "Instructor"
	And I enter the Instructor Account details for "Higher Education Institution"
	And I configure the Account Setup for "Higher Education Institution"
	Then I am able to sign up as an Instructor for "Higher Education Institution"
	
@InstructorAccountRegressionTesting
Scenario: Instructor Account Creation for K-12 Education Institution Instructor
	Description: Able to sign up as an Instructor for K-12 Education Institution
	
	Given I am an End User in Go React
	When I create an account as an "Instructor"
	And I enter the Instructor Account details for "K-12 Education Institution"
	And I configure the Account Setup for "K-12 Education Institution"
	Then I am able to sign up as an Instructor for "K-12 Education Institution"
	
@InstructorAccountRegressionTesting
Scenario: Instructor Account Creation for Professional Organization Instructor
	Description: Able to sign up as an Instructor for Professional Organization
	
	Given I am an End User in Go React
	When I create an account as an "Instructor"
	And I enter the Instructor Account details for "Professional Organization"
	And I configure the Account Setup for "Professional Organization"
	Then I am able to sign up as an Instructor for "Professional Organization"
	
@InstructorAccountRegressionTesting
Scenario: Instructor Account Creation for Personal Use Instructor
	Description: Able to sign up as an Instructor for Personal Use
	
	Given I am an End User in Go React
	When I create an account as an "Instructor"
	And I enter the Instructor Account details for "Personal Use"
	And I configure the Account Setup for "Personal Use"
	Then I am able to sign up as an Instructor for "Personal Use"

@InstructorAccountRegressionTesting
Scenario: Instructor Account Creation failed with invalid field values in the Instructor Account details
	Description: Not able to sign up with invalid field values as an Instructor 
	
	Given I am an End User in Go React
	When I create an account as an "Instructor"
	And I enter the "Invalid Instructor field values" in the Instructor Account details
	Then I am not able to sign up with invalid field values as an Instructor
	
@InstructorAccountRegressionTesting
Scenario: Instructor Account Creation failed with empty field values in the Instructor Account details
	Description: Not able to sign up with empty field values as an Instructor 
	
	Given I am an End User in Go React
	When I create an account as an "Instructor"
	And I enter the "Empty Instructor field values" in the Instructor Account details
	Then I am not able to sign up with empty field values as an Instructor
