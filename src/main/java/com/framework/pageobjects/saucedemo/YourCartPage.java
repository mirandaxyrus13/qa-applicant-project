package com.framework.pageobjects.saucedemo;

import org.openqa.selenium.By;

import com.framework.webelements.Button;


public class YourCartPage {
	public static class OrderList{
		
		private final static Button buttonCheckout = new Button("CHECKOUT", By.xpath("//button[@id='checkout']"));
		
		public static void clickCheckout () {
			buttonCheckout.click();
		}
	}
}
