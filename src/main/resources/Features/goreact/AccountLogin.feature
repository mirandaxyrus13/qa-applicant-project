Feature: Account Login

@AccountLoginRegressionTesting
Scenario: Account Login successful with valid credentials
	Description: Able to login successfully with valid credentials
	
	Given I am an End User in Go React
	When I login with "Valid credentials"
	Then I am able to login successfully with valid credentials

@AccountLoginRegressionTesting
Scenario: Account Login failed with invalid credentials
	Description: Not able to login with invalid credentials
	
	Given I am an End User in Go React
	When I login with "Invalid credentials"
	Then I am not able to login with invalid credentials
