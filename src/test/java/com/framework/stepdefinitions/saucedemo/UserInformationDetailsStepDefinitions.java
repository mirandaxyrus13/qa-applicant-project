package com.framework.stepdefinitions.saucedemo;

import com.framework.dataobjects.SauceDemoData;
import com.framework.pageobjects.saucedemo.CheckoutPage;

import cucumber.api.java.en.And;

public class UserInformationDetailsStepDefinitions{

	@And("^I enter the User Information")
	public static void i_enter_the_user_information() throws Exception{
		CheckoutPage.YourInformation.enterYourInformation(SauceDemoData.UserDetails.getFirstName(), SauceDemoData.UserDetails.getLastName(), SauceDemoData.UserDetails.getZipPostalCode());
		CheckoutPage.YourInformation.clickContinue();
	}
	
	
}
