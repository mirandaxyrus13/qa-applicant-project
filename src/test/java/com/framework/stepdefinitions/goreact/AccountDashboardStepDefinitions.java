package com.framework.stepdefinitions.goreact;

import com.framework.core.Browser;
import com.framework.pageobjects.DashboardPage;
import com.framework.pageobjects.LoginPage;

import cucumber.api.java.en.Then;

public class AccountDashboardStepDefinitions {
	
	@Then("^I am able to sign up as an Instructor for \"(.*)\"$")
	public static void I_am_able_to_sign_up_as_an_Instructor_for(String value) throws Exception{
		DashboardPage.WelcomeSection.verifyWelcomeText(value);
		DashboardPage.DashboardHeader.clickLogOut();
		LoginPage.LoginSection.verifyLoginSection();
		Browser.closeBrowser();
	}
	
	@Then("^I am able to login successfully with valid credentials$")
	public static void I_am_able_to_login_successfully_with_valid_credentials() throws Exception{
		DashboardPage.WelcomeSection.verifyWelcomeText();
		DashboardPage.DashboardHeader.clickLogOut();
		LoginPage.LoginSection.verifyLoginSection();
		Browser.closeBrowser();
	}
}
