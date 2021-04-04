package com.framework.testrunner;

import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "classpath:Features/ServiceNow", plugin = { "pretty", "html:target/cucumberHtmlReport",
		"html:target/cucumberHtmlReport", // html result
		"pretty:target/cucumber-json-report.json", // json result
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ServiceNow_report.html" }, monochrome = true, glue = {
				"com.framework.stepdefinitions.snow" }, tags = { "@ServiceNowRegression" })

public class ServiceNowRegression extends AbstractTestNGCucumberTests {
	
	@AfterClass
	public static void afterClass() {
		String reportConfigPath = System.getProperty("user.dir").replace("\\", "/")
				+ "/src/main/resources/Config/extent-config.xml";
		Reporter.loadXMLConfig(reportConfigPath);
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	}
	
}
