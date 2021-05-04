package com.framework.stepdefinitions.saucedemo;

import com.framework.core.Browser;
import com.framework.dataobjects.SauceDemoData;
import com.framework.pageobjects.saucedemo.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class CommonStepDefinitions{
	
	@Given("^I am an End User accessing SauceDemo$")
	public static void i_am_an_End_User_accessing_SauceDemo() throws Exception{
		// Navigate to GoReact
		Browser.openBrowser();
		Browser.setEnvironmentAndNavigateToURL("saucedemo_test");
		LoginPage.LoginSection.verifyLogo();
	}

	
	@And("^I login with my Valid Credentials$")
	public static void I_login_with_my_valid_credentials() throws Exception{
		LoginPage.LoginSection.loginUser(SauceDemoData.UserDetails.getUsername(), SauceDemoData.UserDetails.getPassword());
	}
	
}


