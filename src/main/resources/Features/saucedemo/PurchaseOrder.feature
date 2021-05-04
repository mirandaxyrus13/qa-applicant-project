Feature: Purchase Order

@PurchaseOrder
Scenario: Purchase order with user information details
	Description: Able to purchase order with user information details
	
	Given I am an End User accessing SauceDemo
	And I login with my Valid Credentials
	When the "Sauce Labs Backpack" product is added to cart
	And the product is checked out
	And I enter the User Information
	Then I am able to purchase order with user information details

