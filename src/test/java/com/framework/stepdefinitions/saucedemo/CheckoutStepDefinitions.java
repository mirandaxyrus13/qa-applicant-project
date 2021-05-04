package com.framework.stepdefinitions.saucedemo;

import com.framework.core.Browser;
import com.framework.pageobjects.saucedemo.CheckoutPage;

import cucumber.api.java.en.Then;

public class CheckoutStepDefinitions {
	
	@Then("^I am able to purchase order with user information details")
	public static void i_am_able_to_purchase_order_with_user_information_details() throws Exception{
		CheckoutPage.Overview.verifyTitle();
		Browser.closeBrowser();
	}
}
