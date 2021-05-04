package com.framework.stepdefinitions.saucedemo;


import com.framework.pageobjects.saucedemo.InventoryPage;
import com.framework.pageobjects.saucedemo.YourCartPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class ProductSelectionStepDefinitions{

	@When("^the \"(.*)\" product is added to cart$")
	public static void the_product_is_added_to_cart(String value) throws Exception{
		InventoryPage.Products.verifyProductDisplayed(value);
		InventoryPage.Products.addToCart(value);
	}
	
	@And("^the product is checked out$")
	public static void the_product_is_checked_out() throws Exception{
		InventoryPage.Products.clickCart();
		YourCartPage.OrderList.clickCheckout();
	}
	
	
}
