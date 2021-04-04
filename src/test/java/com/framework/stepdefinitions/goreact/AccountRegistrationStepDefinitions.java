package com.framework.stepdefinitions.goreact;

import com.framework.core.Browser;
import com.framework.dataobjects.GoReactData;
import com.framework.pageobjects.AccountRegistrationPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class AccountRegistrationStepDefinitions{
	
	@And("^I enter the Instructor Account details for \"(.*)\"$")
	public static void And_I_enter_the_Instructor_Account_details(String value) throws Exception{
		AccountRegistrationPage.CreateInstructorAccount.enterFirstName(GoReactData.RegistrationDetails.getFirstName(value));
		AccountRegistrationPage.CreateInstructorAccount.enterLastName(GoReactData.RegistrationDetails.getLastName(value));
		AccountRegistrationPage.CreateInstructorAccount.enterPhoneNumber(GoReactData.RegistrationDetails.getPhoneNumber(value));
		AccountRegistrationPage.CreateInstructorAccount.enterEmail(GoReactData.RegistrationDetails.getEmail(value));
		AccountRegistrationPage.CreateInstructorAccount.enterPassword(GoReactData.RegistrationDetails.getPassword(value));
		AccountRegistrationPage.CreateInstructorAccount.enterConfirmPassword(GoReactData.RegistrationDetails.getPassword(value));
		AccountRegistrationPage.CreateInstructorAccount.checkTermsAndPrivacy(GoReactData.RegistrationDetails.getTermsAndPrivacy(value));
		AccountRegistrationPage.CreateInstructorAccount.clickContinue();
	}
	
	@And("^I configure the Account Setup for \"(.*)\"$")
	public static void I_configure_the_Account_Setup(String value) throws Exception{
		AccountRegistrationPage.AccountSetupDetails.selectGoReactInstructorType(value);
		AccountRegistrationPage.AccountSetupDetails.enterInstitutionNameOrganizationName(value, GoReactData.RegistrationDetails.getInstitutionName(value));
		AccountRegistrationPage.AccountSetupDetails.selectYourRole(value, GoReactData.RegistrationDetails.getYourRole(value));
		AccountRegistrationPage.AccountSetupDetails.selectType(value, GoReactData.RegistrationDetails.getType(value));
		AccountRegistrationPage.AccountSetupDetails.selectCourseFormat(GoReactData.RegistrationDetails.getCourseFormat(value));
		AccountRegistrationPage.AccountSetupDetails.clickContinue();
	}

	@And("^I enter the \"(.*)\" in the Instructor Account details$")
	public static void I_enter_the_invalid_field_values_in_the_Instructor_Account_details(String value) throws Exception{
		AccountRegistrationPage.CreateInstructorAccount.enterFirstName(GoReactData.RegistrationDetails.getFirstName(value));
		AccountRegistrationPage.CreateInstructorAccount.enterLastName(GoReactData.RegistrationDetails.getLastName(value));
		AccountRegistrationPage.CreateInstructorAccount.enterPhoneNumber(GoReactData.RegistrationDetails.getPhoneNumber(value));
		AccountRegistrationPage.CreateInstructorAccount.enterEmail(GoReactData.RegistrationDetails.getEmail(value));
		AccountRegistrationPage.CreateInstructorAccount.enterPassword(GoReactData.RegistrationDetails.getPassword(value));
		AccountRegistrationPage.CreateInstructorAccount.enterConfirmPassword(GoReactData.RegistrationDetails.getPassword(value));
		
		if((GoReactData.RegistrationDetails.getFirstName(value)).equals("") && (GoReactData.RegistrationDetails.getLastName(value)).equals("") && (GoReactData.RegistrationDetails.getPhoneNumber(value)).equals("") && (GoReactData.RegistrationDetails.getEmail(value)).equals("") && (GoReactData.RegistrationDetails.getPassword(value)).equals("") && (GoReactData.RegistrationDetails.getPassword(value)).equals("")) {
			AccountRegistrationPage.CreateInstructorAccount.checkTermsAndPrivacy(GoReactData.RegistrationDetails.getTermsAndPrivacy(value));
		}else {
			AccountRegistrationPage.CreateInstructorAccount.checkTermsAndPrivacy(GoReactData.RegistrationDetails.getTermsAndPrivacy(value));
		}

		Browser.scrollDown();
		
		AccountRegistrationPage.CreateInstructorAccount.clickJSContinue();
		

	}
	
	@Then("^I am not able to sign up with invalid field values as an Instructor$")
	public static void I_am_not_able_to_sign_up_with_invalid_field_values_as_an_Instructor() throws Exception{
		AccountRegistrationPage.CreateInstructorAccount.verifyErrorInvalidEmail();
		AccountRegistrationPage.CreateInstructorAccount.verifyErrorInvalidPassword();
		AccountRegistrationPage.CreateInstructorAccount.verifyErrorInvalidConfirmPassword();
		Browser.closeBrowser();
	}
	
	@Then("^I am not able to sign up with empty field values as an Instructor$")
	public static void I_am_not_able_to_sign_up_with_empty_field_values_as_an_Instructor() throws Exception{
		AccountRegistrationPage.CreateInstructorAccount.verifyErrorEmptyFirstName();
		AccountRegistrationPage.CreateInstructorAccount.verifyErrorEmptyLastName();
		AccountRegistrationPage.CreateInstructorAccount.verifyErrorEmptyEmail();
		AccountRegistrationPage.CreateInstructorAccount.verifyErrorEmptyPassword();
		AccountRegistrationPage.CreateInstructorAccount.verifyErrorEmptyConfirmPassword();
		AccountRegistrationPage.CreateInstructorAccount.verifyErrorUncheckedTermsAndPrivacy();
		Browser.closeBrowser();
	}
	
}
