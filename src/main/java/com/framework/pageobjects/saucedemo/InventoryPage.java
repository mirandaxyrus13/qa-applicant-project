package com.framework.pageobjects.saucedemo;

import org.openqa.selenium.By;

import com.framework.webelements.Button;
import com.framework.webelements.Element;
import com.framework.webelements.Link;

public class InventoryPage {
	
	public static class Products{
		
		private static final Link linkCart = new Link("Cart", By.xpath("//a[@class='shopping_cart_link']"));
		
		public static void clickCart() {
			linkCart.click();
		}
		
		public static void verifyProductDisplayed(String product) {
			Element labelProduct = new Element(product + " Label", By.xpath("//div[starts-with(text(), '" + product + "')]"));
			labelProduct.verifyDisplayed();
		}
		
		public static void addToCart(String product) {
			Button buttonAddProduct = new Button("Add to Cart - " + product, By.xpath("//div[starts-with(text(), '" + product + "')]//ancestor::div[@class='inventory_item']//button"));
			buttonAddProduct.click();
		}
		
		public static void removeToCart(String product) {
			Button buttonRemove = new Button("Remove - " + product, By.xpath("//div[starts-with(text(), '" + product + "')]//ancestor::div[@class='inventory_item']//button"));
			buttonRemove.click();
		}
		
	}
	
}
