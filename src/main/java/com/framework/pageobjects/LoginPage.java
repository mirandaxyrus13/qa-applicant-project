package com.framework.pageobjects;

import org.openqa.selenium.By;

import com.framework.webelements.Button;
import com.framework.webelements.Element;
import com.framework.webelements.TextBox;

public class LoginPage {
	
	public static class LoginSection {
		
		private final static TextBox textBoxEmail = new TextBox("Email", By.xpath("//*[@id='email']"));
		private final static TextBox textBoxPassword = new TextBox("Password", By.xpath("//*[@id='password']"));
		private final static Button buttonCreateAccount = new Button("Create Account", By.xpath("//*[starts-with(text(), 'Create Account')]"));
		private final static Button buttonLogin = new Button("Login", By.xpath("//*[starts-with(text(), 'Log In')]//parent::button"));
		private final static Element imageLoginHeader = new Element("goreact Login Header", By.xpath("//img[@class='logo']"));
		private final static Element formLogin = new Element("Login Form", By.xpath("//div[@class='content-space']//form[@name='loginForm']"));
		private final static Element errorMessageCheckUsernameAndPassword = new Element("Check username and password", By.xpath("//div//p[contains(text(), 'Check username and password')]"));
		
		
		
		public static void loginUser(String email, String password) {
			textBoxEmail.setText(email);
			textBoxPassword.setPassword(password);
			buttonLogin.click();
		}
		
		public static void clickCreateAccount() {
			buttonCreateAccount.click();
		}
		
		public static void verifyLoginHeader() {
			imageLoginHeader.verifyDisplayed();
		}
		
		public static void verifyLoginSection() {
			formLogin.verifyDisplayed();
			textBoxEmail.verifyDisplayed();
			textBoxPassword.verifyDisplayed();
		}
		
		public static void verifyErrorCheckUsernameAndPassword() {
			errorMessageCheckUsernameAndPassword.verifyDisplayed();
		}
		
	}
}
