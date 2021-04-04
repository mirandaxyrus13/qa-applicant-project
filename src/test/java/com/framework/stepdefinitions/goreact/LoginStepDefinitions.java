package com.framework.stepdefinitions.goreact;

import com.framework.core.Browser;
import com.framework.pageobjects.LoginPage;

import cucumber.api.java.en.Then;

public class LoginStepDefinitions {
	
	@Then("^I am not able to login with invalid credentials$")
	public static void I_am_not_able_to_login_with_invalid_credentials() throws Exception{
		LoginPage.LoginSection.verifyErrorCheckUsernameAndPassword();
		Browser.closeBrowser();
	}
}
