package com.framework.stepdefinitions.goreact;

import com.framework.core.Browser;
import com.framework.dataobjects.GoReactData;
import com.framework.pageobjects.AccountRegistrationPage;
import com.framework.pageobjects.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CommonStepDefinitions{
	
	@Given("^I am an End User in Go React$")
	public static void I_am_an_End_User_in_Go_React() throws Exception{
		// Navigate to GoReact
		Browser.openBrowser();
		Browser.setEnvironmentAndNavigateToURL("goreact_test");
		LoginPage.LoginSection.verifyLoginHeader();
		
	}
	
	@When("^I create an account as an \"(.*)\"$")
	public static void I_create_an_account_as_an(String value) throws Exception{
		LoginPage.LoginSection.clickCreateAccount();
		AccountRegistrationPage.AccountTypeSection.clickStudentOrInstructor(value);
	}
	
	@When("^I login with \"(.*)\"$")
	public static void I_login_with_credentials(String value) throws Exception{
		LoginPage.LoginSection.loginUser(GoReactData.RegistrationDetails.getEmail(value), GoReactData.RegistrationDetails.getPassword(value));
	}
	
}
