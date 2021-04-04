package com.framework.pageobjects;

import org.openqa.selenium.By;

import com.framework.webelements.Button;
import com.framework.webelements.Element;
import com.framework.webelements.Link;


public class DashboardPage {
	
	public static class WelcomeSection {

		public static void verifyWelcomeText(String value) {
			Element displayWelcome = new Element("Welcome to GoReact! - " + value, By.xpath("//span[text()='Welcome to GoReact!']"));
			displayWelcome.verifyDisplayed();
		}
		
		public static void verifyWelcomeText() {
			Element displayWelcome = new Element("Welcome to GoReact!", By.xpath("//span[text()='Welcome to GoReact!']"));
			displayWelcome.verifyDisplayed();
		}
		
	}
	
	public static class DashboardHeader{
		
		private final static Button buttonUserNavigation = new Button("User Navigation", By.xpath("//uib-dropdown[contains(@class, 'user-widget btn-group btn-group-rnd dropdown')]"));
		private final static Link linkUserNavigationValue = new Link("User Navigation - Log Out", By.xpath("//uib-dropdown[contains(@class, 'user-widget btn-group btn-group-rnd dropdown')]//ul//li//a[text()='Log Out']"));
		
		public static void clickLogOut() {
			buttonUserNavigation.click();
			linkUserNavigationValue.click();
		}
		
	}
}
