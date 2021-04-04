//package com.framework.testrunner;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//import com.cucumber.listener.Reporter;
//import com.framework.core.JAXBParser;
//import com.framework.core.XMLMerge;
//
//import cucumber.api.CucumberOptions;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
//
//@CucumberOptions(features = "classpath:features", plugin = { "pretty", "html:target/cucumberHtmlReport",
//		"html:target/cucumberHtmlReport", // html resqult
//		"pretty:target/cucumber-json-report.json", // json result
//		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, monochrome = true, glue = {
//				"com.framework.stepdefinitions.peoplesoft" }, tags = { "@Smoke" })
//
//public class SmokeTest extends AbstractTestNGCucumberTests {
//
//	@AfterClass
//	public static void afterClass() {
//		// Reporter.loadXMLConfig(new
//		// File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
//		String reportConfigPath = System.getProperty("user.dir").replace("\\", "/")
//				+ "/src/main/resources/Config/extent-config.xml";
//		Reporter.loadXMLConfig(reportConfigPath);
//		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
//		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//	}
//
//	@BeforeClass
//	public void beforeClass() throws IOException {
//		File TestData = new File(System.getProperty("user.dir").replace("\\", "/") + "/src/main/resources/TestData/"
//				+ (System.getProperty("environment")) + "/TestData.xml");
//		XMLMerge.IOCopier.joinFiles(TestData, new File[] {
//				new File(System.getProperty("user.dir").replace("\\", "/") + "/src/main/resources/TestData/"
//						+ (System.getProperty("environment")) + "/DataHeader.xml"),
//				new File(System.getProperty("user.dir").replace("\\", "/") + "/src/main/resources/TestData/"
//						+ (System.getProperty("environment")) + "/CommonData.xml"),
//				new File(System.getProperty("user.dir").replace("\\", "/") + "/src/main/resources/TestData/"
//						+ (System.getProperty("environment")) + "/StudentRecords/ScheduleOfClassesTestData.xml"),
//				new File(System.getProperty("user.dir").replace("\\", "/") + "/src/main/resources/TestData/"
//						+ (System.getProperty("environment")) + "/DataFooter.xml") });
//		JAXBParser parser = new JAXBParser();
//		parser.execute(TestData.getAbsolutePath());
//	}
//
//}