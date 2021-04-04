package com.framework.core;

public class Verification {

	// Verify pageTitle Equals
	public static void VerifyPageTitleEquals(String expected) {
		if (Browser.getDriver().getTitle().equals(expected)) {
			Log.testStep("PASSED", expected + " is the correct page title", expected + " is the correct page title");
		} else {
			Log.testStep("FAILED", Browser.getDriver().getTitle() + " is the page title",
					expected + " is the correct page title");
		}
	}

}
