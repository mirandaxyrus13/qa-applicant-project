package com.framework.pageobjects;

import org.openqa.selenium.By;

import com.framework.webelements.Button;
import com.framework.webelements.CheckBox;
import com.framework.webelements.Element;
import com.framework.webelements.ListBox;
import com.framework.webelements.TextBox;

public class AccountRegistrationPage {
	
	public static class CreateInstructorAccount {
		
		private final static TextBox textBoxFirstName = new TextBox("First Name", By.xpath("//*[@id='first-name']"));
		private final static TextBox textBoxLastName  = new TextBox("Last Name", By.xpath("//*[@id='last-name']"));
		private final static TextBox textBoxPhoneNumber = new TextBox("Phone Number", By.xpath("//*[@id='phone-number']"));
		private final static TextBox textBoxEmail = new TextBox("Email", By.xpath("//*[@id='email']"));
		private final static TextBox textBoxPassword = new TextBox("Password", By.xpath("//*[@id='password']"));
		private final static TextBox textBoxConfirmPassword = new TextBox("Confirm Password", By.xpath("//*[@id='confirm-password']"));
		
		private final static CheckBox checkboxTermsAndPrivacy = new CheckBox("Terms and Privacy Policy", By.xpath("//*[@id='terms']"));
		
		private final static Button buttonContinue = new Button("Continue", By.xpath("//*[text()='Continue']//parent::button"));
		private final static Button buttonCancel = new Button("Cancel", By.xpath("//*[text()='Cancel']"));		
		private final static Element buttonWebElementContinue = new Element("Continue", By.xpath("//*[text()='Continue']//parent::button"));
		
		
		private final static Element errorMessageInvalidEmail = new Element("Invalid Email", By.xpath("//div//ng-message[@id='email-invalid-error']"));		
		private final static Element errorMessageInvalidPassword = new Element("Invalid Password", By.xpath("//div//ng-message[@id='password-invalid-error']"));		
		private final static Element errorMessageInvalidConfirmPassword = new Element("Invalid Confirm Password", By.xpath("//div//ng-message[@id='confirm-password-invalid-error']"));	
		
		private final static Element errorMessageEmptyFirstName = new Element("First name is required.", By.xpath("//div//ng-message[@id='first-name-required-error']"));		
		private final static Element errorMessageEmptyLastName = new Element("Last name is required.", By.xpath("//div//ng-message[@id='last-name-required-error']"));		
		private final static Element errorMessageEmptyEmail = new Element("Email is required.", By.xpath("//div//ng-message[@id='email-required-error']"));	
		private final static Element errorMessageEmptyPassword = new Element("Password is required.", By.xpath("//div//ng-message[@id='password-required-error']"));		
		private final static Element errorMessageEmptyConfirmPassword = new Element("Re-type the new password", By.xpath("//div//ng-message[@id='confirm-password-required-error']"));		
		private final static Element errorMessageUncheckedTermsAndPrivacy = new Element("Please accept terms and privacy policy.", By.xpath("//div//ng-message[@id='terms-required-error']"));	

		
		
		public static void enterFirstName(String firstName) {
			textBoxFirstName.setText(firstName);
		}
		
		public static void enterLastName(String lastName) {
			textBoxLastName.setText(lastName);
		}
		
		public static void enterPhoneNumber(String phoneNumber) {
			textBoxPhoneNumber.setText(phoneNumber);
		}
		
		public static void enterEmail(String email) {
			textBoxEmail.setText(email);
		}
		
		public static void enterPassword(String password) {
			textBoxPassword.setPassword(password);
		}
		
		public static void enterConfirmPassword(String password) {
			textBoxConfirmPassword.setPassword(password);
		}
		
		public static void checkTermsAndPrivacy(String value) {
			if(value.equals("Y")) {
				checkboxTermsAndPrivacy.tick(true);
			}else if(value.equals("N")) {
				checkboxTermsAndPrivacy.tick(false);
			}
			
		}
		
		public static void clickContinue() {
			buttonContinue.click();
		}
		
		public static void clickJSContinue() {
			buttonWebElementContinue.clickJS();
		}
		
		public static void clickCancel() {
			buttonCancel.click();
		}
		
		public static void verifyErrorInvalidEmail() {
			errorMessageInvalidEmail.verifyDisplayed();
		}
		
		public static void verifyErrorInvalidPassword() {
			errorMessageInvalidPassword.verifyDisplayed();
		}
		
		public static void verifyErrorInvalidConfirmPassword() {
			errorMessageInvalidConfirmPassword.verifyDisplayed();
		}
		
		public static void verifyErrorEmptyFirstName() {
			errorMessageEmptyFirstName.verifyDisplayed();
		}
		
		public static void verifyErrorEmptyLastName() {
			errorMessageEmptyLastName.verifyDisplayed();
		}
		
		public static void verifyErrorEmptyEmail() {
			errorMessageEmptyEmail.verifyDisplayed();
		}
		
		public static void verifyErrorEmptyPassword() {
			errorMessageEmptyPassword.verifyDisplayed();
		}

		public static void verifyErrorEmptyConfirmPassword() {
			errorMessageEmptyConfirmPassword.verifyDisplayed();
		}
		
		public static void verifyErrorUncheckedTermsAndPrivacy() {
			errorMessageUncheckedTermsAndPrivacy.verifyDisplayed();
		}

	}
	
	public static class AccountTypeSection {
		private final static Button buttonStudent = new Button("Student", By.xpath("//*[starts-with(text(), 'STUDENT')]"));
		private final static Button buttonInstructor = new Button("Instructor", By.xpath("//*[starts-with(text(), 'INSTRUCTOR')]"));
		
		public static void clickStudentOrInstructor(String value) {
			if(value.equals("Instructor")) {
				buttonInstructor.click();
			} else if(value.equals("Student")) {
				buttonStudent.click();
			}
		}
		
	}
	
	public static class AccountSetupDetails {
		
		private final static Element listboxInstructorType = new Element("I'm using GoReact at a...", By.xpath("//span[contains(text(), 'using GoReact at a…')]//parent::label//following-sibling::div//*//button"));
		
		private final static TextBox textboxInstitutionName = new TextBox("Institution Name", By.xpath("//label[contains(text(), 'Institution Name')]//parent::div//input"));
		private final static TextBox textboxOrganizationName = new TextBox("Organization Name", By.xpath("//label[contains(text(), 'Organization Name')]//parent::div//input"));
		
		
		private final static Element listboxYourRole = new Element("Your Role", By.xpath("//span[contains(text(), 'Your Role')]//parent::label//following-sibling::div//*//button"));
		private final static Element listboxCourseType = new Element("Course Type", By.xpath("//span[contains(text(), 'Course Type')]//parent::label//following-sibling::div//*//button"));
		private final static Element listboxTrainingType = new Element("Course Type", By.xpath("//span[contains(text(), 'Training Type')]//parent::label//following-sibling::div//*//button"));
		private final static Element listboxCourseFormat = new Element("Course Format", By.xpath("//span[contains(text(), 'Course Format')]//parent::label//following-sibling::div//*//button"));
		
		private final static Button buttonCancel = new Button("Cancel", By.xpath("//*[starts-with(text(), 'Cancel')]"));
		private final static Button buttonContinue = new Button("Continue", By.xpath("//button//*[starts-with(text(), 'Continue')]"));
		
		
		public static void selectGoReactInstructorType(String value){
			listboxInstructorType.click();
			Element valueInstructorType = new Element("Instructor Type" , By.xpath("//*[contains(text(), 'using GoReact at a…')]//parent::label//following-sibling::*//*//button//following-sibling::*//*//*//*[contains(text(), '" + value + "')]"));
			valueInstructorType.click();
		}
		
		public static void enterInstitutionNameOrganizationName(String value, String name) {
			if(value.equals("K-12 Education Institution") || value.equals("Higher Education Institution")) {
				textboxInstitutionName.setText(name);
				Element valueInstitutionName = new Element("Institution Name: " + name , By.xpath("//label[contains(text(), 'Institution Name')]//parent::div//ul//li//a//go-typeahead-item-template[text()='" + name + "']"));
				valueInstitutionName.click();
			}else if(value.equals("Professional Organization")) {
				textboxOrganizationName.setText(name);
				Element valueOrganizationName = new Element("Organization Name: " + name , By.xpath("//label[contains(text(), 'Organization Name')]//parent::div//ul//li//a//go-typeahead-item-template[text()='" + name + "']"));
				valueOrganizationName.click();
			}

		}
		
		public static void selectYourRole(String value, String role){
			if(value.equals("K-12 Education Institution") || value.equals("Professional Organization") || value.equals("Higher Education Institution")) {
				listboxYourRole.click();
				Element valueInstructorType = new Element("Your Role: " + role, By.xpath("//*[contains(text(), 'Your Role')]//parent::label//following-sibling::*//*//button//following-sibling::*//*//*//*[contains(text(), '" + role + "')]"));
				valueInstructorType.click();
			}
			
		}
		
		public static void selectType(String value, String type){
			if(value.equals("K-12 Education Institution") || value.equals("Professional Organization") || value.equals("Personal Use")) {
				listboxTrainingType.click();
				Element valueTrainingType = new Element("Training Type" + type, By.xpath("//*[contains(text(), 'Training Type')]//parent::label//following-sibling::*//*//button//following-sibling::*//*//*//*[contains(text(), '" + type + "')]"));
				valueTrainingType.click();
			}else if(value.equals("Higher Education Institution") ) {
				listboxCourseType.click();
				Element valueInstructorType = new Element("Course Type" + type, By.xpath("//*[contains(text(), 'Course Type')]//parent::label//following-sibling::*//*//button//following-sibling::*//*//*//*[contains(text(), '" + type + "')]"));
				valueInstructorType.click();
			}
		}
		
		public static void selectCourseFormat(String value){
			listboxCourseFormat.click();
			Element valueInstructorType = new Element("Course Format" , By.xpath("//*[contains(text(), 'Course Format')]//parent::label//following-sibling::*//*//button//following-sibling::*//*//*//*[contains(text(), '" + value + "')]"));
			valueInstructorType.click();
		}
		

		public static void clickCancel() {
			buttonCancel.click();
		}
		
		public static void clickContinue() {
			buttonContinue.click();
		}

		
	}
	
}
