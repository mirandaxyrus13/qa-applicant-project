package com.framework.pageobjects.saucedemo;

import org.openqa.selenium.By;

import com.framework.webelements.Button;
import com.framework.webelements.Element;
import com.framework.webelements.TextBox;

public class LoginPage {
	
	public static class LoginSection {
		
		private final static TextBox textBoxUsername = new TextBox("Username", By.xpath("//input[@id='user-name']"));
		private final static TextBox textBoxPassword = new TextBox("Password", By.xpath("//input[@id='password']"));

		private final static Button buttonLogin = new Button("LOGIN", By.xpath("//input[@id='login-button']"));
		
		private final static Element logoSauceDemo = new Element("Sauce Demo Logo", By.xpath("//div[@class='login_logo']"));
		
		
		public static void verifyLogo() {
			logoSauceDemo.verifyDisplayed();
		}
		
		public static void loginUser(String username, String password) {
			textBoxUsername.setText(username);
			textBoxPassword.setPassword(password);
			buttonLogin.click();
		}
		
	}
}