package com.framework.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

public class Browser {

	public static String browser;
	public static String dataFilePath = System.getProperty("user.dir").replace("\\", "/")
			+ "/src/main/resources/TestData/dataFile.xml";
	public static String downloadFilepath = System.getProperty("user.dir").replace("\\", "/")
			+ "/src/main/resources/downloads/";
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static String environment = System.getProperty("environment");
	private static ThreadLocal<ExtentTest> logger = new ThreadLocal<ExtentTest>();
	public static Integer searchLoop = 1;
	public static String seleniumGridUrl = System.getProperty("webdriver.base.url");
	public static FileInputStream fileInputStream;
	public static Properties properties;
	public static ITestResult result;

	public static void getBrowser() throws Exception {
		fileInputStream = new FileInputStream(
				System.getProperty("user.dir").replace("\\", "/") + "/src/main/resources/AppConfig/config.properties");
		properties = new Properties();
		properties.load(fileInputStream);
		browser = properties.getProperty("browser").toString();
	}

	public static void acceptAlert() {
		getDriver().switchTo().alert().accept();
	}

	public static void closeBrowser() throws Exception {
		if (getDriver() != null) {
			getDriver().quit();
			Log.setLog(browser.replace("grid_", "") + " instance closed.");
		}
	}

	public static void switchToDefaultContent() {
		getDriver().switchTo().defaultContent();
		Log.testStep("PASSED", "Switch to default content", "Switch to default content");

	}

	public static void closeTab() {
		getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
	}

	public static void delay(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
		}
	}

	public static WebElement findElement(By by) throws WebDriverException {
		WebElement element = null;
		int i = 0;
		int attempts = 0;
		while (i != searchLoop && element == null) {
			i += 1;
			try {
				element = new WebDriverWait(getDriver(), 10).ignoring(StaleElementReferenceException.class)
						.until(ExpectedConditions.presenceOfElementLocated(by));
			} catch (Exception e) {
				element = null;
			}
		}
		if (element != null) {
			try {
				while (attempts < 2) {
					try {
						Actions actions = new Actions(getDriver());
						actions.moveToElement(element);
						actions.perform();
					} catch (StaleElementReferenceException e) {
					}
					attempts++;
				}
			} catch (Exception e) {
			}
		}

		return element;
	}

	public static List<WebElement> findElements(By by) throws WebDriverException {
		List<WebElement> elements = null;
		int i = 0;
		int attempts = 0;
		while (i != searchLoop && elements.size() == 0) {
			i += 1;
			try {
				elements = new WebDriverWait(getDriver(), 5).ignoring(StaleElementReferenceException.class)
						.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
			} catch (Exception e) {
				elements = null;
			}
		}
		if (elements != null) {
			try {
				while (attempts < 2) {
					try {
						Actions actions = new Actions(getDriver());
						actions.moveToElement(elements.get(0));
						actions.perform();
					} catch (StaleElementReferenceException e) {
					}
					attempts++;
				}
			} catch (Exception e) {
			}
		}
		return elements;
	}

	public static List<WebElement> findElements(By parentBy, By childBy) throws WebDriverException {
		WebElement element = null;
		List<WebElement> elements = null;
		int i = 0;
		int attempts = 0;
		while (i != searchLoop && elements.size() == 0) {
			i += 1;
			try {
				element = new WebDriverWait(getDriver(), 5).ignoring(StaleElementReferenceException.class)
						.until(ExpectedConditions.presenceOfElementLocated(parentBy));
				elements = element.findElements(childBy);
			} catch (Exception e) {
				elements = null;
			}
		}
		if (elements != null) {
			try {
				while (attempts < 2) {
					try {
						Actions actions = new Actions(getDriver());
						actions.moveToElement(elements.get(0));
						actions.perform();
					} catch (StaleElementReferenceException e) {
					}
					attempts++;
				}
			} catch (Exception e) {
			}
		}
		return elements;
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static ExtentTest getLogger() {
		return logger.get();
	}

	public static int getTabCount() {
		return new ArrayList<String>(getDriver().getWindowHandles()).size();
	}

	public static void navigateBackward() throws IOException {
		getDriver().navigate().back();
		Log.testStep("PASSED", "Navigate Backward", "Navigate Backward");
	}

	protected static void navigateForward() throws IOException {
		getDriver().navigate().forward();
		Log.testStep("PASSED", "Navigate Forward", "Navigate Forward");
	}

	@SuppressWarnings("deprecation")
	public static void openBrowser() throws Exception {
		getBrowser();
		if (browser.equalsIgnoreCase("firefox")) {
			// Set Path for the executable file
			System.setProperty("webdriver.gecko.driver", "src/main/resources/Drivers/geckodriver.exe");
			System.setProperty("webdriver.firefox.marionette", "true");

			DesiredCapabilities cap = DesiredCapabilities.firefox();

			driver.set(new FirefoxDriver(cap));
			getDriver().manage().window().maximize();

		} else if (browser.equalsIgnoreCase("ie")) {
			// Set Path for the executable file
			System.setProperty("webdriver.ie.driver", "src/main/resources/Drivers/IEDriverServer.exe");
			driver.set(new InternetExplorerDriver());
			getDriver().manage().window().maximize();

		} else if (browser.equalsIgnoreCase("htmlUnit")) {
			HtmlUnitDriver driver = new HtmlUnitDriver();
			driver.setJavascriptEnabled(true);

		} else if (browser.equalsIgnoreCase("chrome")) {
			String driverType = null;
			if (OSChecker.isWindows()) {
				driverType = "chromedriver.exe";
			} else if (OSChecker.isMac()) {
				driverType = "chromedriver_mac";
			}

			System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/" + driverType);
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("prefs", chromePrefs);
			
			fileInputStream = new FileInputStream(
					System.getProperty("user.dir").replace("\\", "/") + "/src/main/resources/AppConfig/config.properties");
			properties = new Properties();
			properties.load(fileInputStream);
			String chromeProfile = properties.getProperty("chrome_profile").toString();
			if(chromeProfile.equals("true")) {
				Log.testStep("INFO", "Initializing Chrome Profile", "Initializing Chrome Profile");
				chromeOptions.addArguments("--user-data-dir=C:\\Browser");
				chromeOptions.addArguments("--profile-directory=Profile 5");
			}else {
				Log.testStep("INFO", "Chrome Profile not detected", "Chrome Profile not detected");
			}
			
			chromeOptions.addArguments("start-maximized");
			chromeOptions.addArguments("mute-audio");
			chromeOptions.addArguments("disable-extensions");
//			 chromeOptions.addArguments("headless");
			chromeOptions.addArguments("disable-gpu");
			// chromeOptions.addArguments("window-size=1280x1024");

			DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
			chromeCapabilities.setJavascriptEnabled(true);
			chromeCapabilities.setAcceptInsecureCerts(true);
			chromeCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

			driver.set(new ChromeDriver(chromeCapabilities));
			
			Log.testStep("PASSED", "Browser Initialized", "Browser Initialized");
			
		} else if (browser.equalsIgnoreCase("grid_chrome")) {
			ChromeOptions gridChromeOptions = new ChromeOptions();
			gridChromeOptions.addArguments("start-maximized");
			gridChromeOptions.addArguments("mute-audio");
			gridChromeOptions.addArguments("disable-extensions");
			gridChromeOptions.addArguments("headless");
			gridChromeOptions.addArguments("disable-gpu");
			gridChromeOptions.addArguments("window-size=1280x1024");

			DesiredCapabilities gridChromeCapabilities = DesiredCapabilities.chrome();
			gridChromeCapabilities.setJavascriptEnabled(true);
			gridChromeCapabilities.setAcceptInsecureCerts(true);
			gridChromeCapabilities.setCapability(ChromeOptions.CAPABILITY, gridChromeOptions);

			driver.set(new RemoteWebDriver(new URL(seleniumGridUrl), gridChromeCapabilities));

		} else if (browser.equalsIgnoreCase("grid_ie")) {
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
			capability.setCapability("nativeEvents", false);
			capability.setCapability("unexpectedAlertBehaviour", "accept");
			capability.setCapability("ignoreProtectedModeSettings", true);
			capability.setCapability("disable-popup-blocking", true);
			capability.setCapability("enablePersistentHover", true);
			driver.set(new RemoteWebDriver(new URL(seleniumGridUrl), capability));
			getDriver().manage().window().maximize();

		} else if (browser.equalsIgnoreCase("grid_firefox")) {
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			driver.set(new RemoteWebDriver(new URL(seleniumGridUrl), capability));
			getDriver().manage().window().maximize();

		} else {
			throw new IllegalArgumentException("Could not find supported browser: " + browser);
		}
		// getDriver().manage().deleteAllCookies();
		Log.setLog("Start automation test in " + browser.replace("grid_", "") + " with Dimensions: "
				+ getDriver().manage().window().getSize());
	}

	protected static void openBrowserAndNavigateUrl(String url) throws Exception {
		openBrowser();
		getDriver().get(url);
		Log.testStep("PASSED", "Navigate to " + url, "Navigate to " + url);
	}

	public static void opennewtab() {
		getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
	}

	public static void refreshPage() throws IOException {
		getDriver().navigate().refresh();
		Log.testStep("PASSED", "Page is Refreshed", "Page is Refreshed");
	}

	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Log.testStep("PASSED", "Page is scrolled down", "Page is scrolled down");
	}

	public static void stopPageLoading() throws IOException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("return window.stop");
		Log.testStep("PASSED", "Page loading is stopped", "Page loading is stopped");
	}

	public static void switchParentTab() throws InterruptedException {
		getDriver().close();
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(0));
	}

	public static void switchWindowTab(int tab) throws InterruptedException {
		try {
			int loop = 0;
			int tabCount = 0;
			while (tabCount != (tab + 1) && loop != 5) {
				tabCount = getTabCount();
				delay(1);
				loop += 1;
			}
			ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
			getDriver().switchTo().window(tabs.get(tab));
		} catch (Exception e) {
			Log.testStep("FAILED", "Tab/Window is NOT available", "Tab/Window is available");
			throw e;
		}
	}

	public static void waitForAngularRequestsToFinish() {
		if ((boolean) ((JavascriptExecutor) getDriver())
				.executeScript("return (typeof angular !== 'undefined')? true : false;")) {
			((JavascriptExecutor) getDriver()).executeAsyncScript("var callback = arguments[arguments.length - 1];"
					+ "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");
		}
	}

	public static boolean waitForJStoLoad() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				try {
					Long state = (Long) ((JavascriptExecutor) arg0).executeScript("return jQuery.active");
					return (state == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};
		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				String state = (String) ((JavascriptExecutor) arg0).executeScript("return document.readyState;");
				return state.equalsIgnoreCase("complete");
			}
		};
		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	public static void setEnvironmentAndNavigateToURL(String environment) throws Exception {

		fileInputStream = new FileInputStream(
				System.getProperty("user.dir").replace("\\", "/") + "/src/main/resources/AppConfig/config.properties");
		properties = new Properties();
		properties.load(fileInputStream);

		String url = null;

		if (environment.equalsIgnoreCase("test")) {
			DataUtility.setSheetName(environment);
			url = properties.getProperty("demotours_test").toString();
			Log.testStep("INFO", "Setting to Test Environment", "Setting to Test Environment");
		} else if (environment.equalsIgnoreCase("dev")) {
			DataUtility.setSheetName(environment);
			url = properties.getProperty("demotours_dev").toString();
			Log.testStep("INFO", "Setting to Dev Environment", "Setting to Dev Environment");
		} else if (environment.equalsIgnoreCase("stage")) {
			DataUtility.setSheetName(environment);
			url = properties.getProperty("demotours_stage").toString();
			Log.testStep("INFO", "Setting the Environment to Stage", "Setting the Environment to Stage");
		} else if (environment.equalsIgnoreCase("service-now")) {
			DataUtility.setSheetName(environment);
			url = properties.getProperty("service_now_test").toString();
			Log.testStep("INFO", "Setting the Environment to Service Now Test",
					"Setting the Environment to Service Now Test");
		} else if (environment.equalsIgnoreCase("goreact_test")) {
			DataUtility.setSheetName(environment);
			url = properties.getProperty("goreact_test").toString();
			Log.testStep("INFO", "Setting the Environment to Go React Test",
					"Setting the Environment to Go React Test");
		}

		navigateUrl(url);
	}

	public static void navigateUrl(String url) throws Exception {
		getDriver().get(url);
		Log.testStep("PASSED", "Open " + url, "Open " + url);
	}

}
