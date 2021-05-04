package com.framework.pageobjects.saucedemo;

import org.openqa.selenium.By;

import com.framework.webelements.Button;
import com.framework.webelements.Element;
import com.framework.webelements.TextBox;

public class CheckoutPage {
	
	public static class YourInformation{
		
		private final static TextBox textBoxFirstName = new TextBox("First Name", By.xpath("//input[@id='first-name']"));
		private final static TextBox textBoxLastName = new TextBox("Last Name", By.xpath("//input[@id='last-name']"));
		private final static TextBox textBoxZipPostalCode = new TextBox("Zip/Postal Code", By.xpath("//input[@id='postal-code']"));
		private final static Button buttonContinue = new Button("Continue", By.xpath("//input[@id='continue']"));
		
		
		public static void enterYourInformation(String firstName, String lastName, String zipPostalCode) {
			textBoxFirstName.setText(firstName);
			textBoxLastName.setText(lastName);
			textBoxZipPostalCode.setText(zipPostalCode);
		}
		
		public static void clickContinue() {
			buttonContinue.click();
		}
		
	}
	
	public static class Overview{
		private final static Element titleOverview = new Element("Overview Title", By.xpath("//span[contains(text(), 'Checkout: Overview')]"));
	
		public static void verifyTitle() {
			titleOverview.verifyDisplayed();
		}
	}
}
