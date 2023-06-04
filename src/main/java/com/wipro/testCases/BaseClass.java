package com.wipro.testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.wipro.pageObjects.AddAddressPage;
import com.wipro.pageObjects.AddressBookPage;
import com.wipro.pageObjects.CheckoutPage;
import com.wipro.pageObjects.HomePage;
import com.wipro.pageObjects.LoginPage;
import com.wipro.pageObjects.MyAccountPage;
import com.wipro.pageObjects.OrderPlacedPage;
import com.wipro.pageObjects.ProductDetailsPage;
import com.wipro.pageObjects.ProductsListPage;
import com.wipro.pageObjects.RegistrationPage;
import com.wipro.pageObjects.ShoppingCartPage;
import com.wipro.utilities.ReadConfigFile;
import com.wipro.utilities.TakeScreenshot;

// ******************** This is the base class where all the initial setup code is written and 
// ********************  this class will be inherited by all the test classes
public class BaseClass {
	ReadConfigFile readConfig = new ReadConfigFile();
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentReports report;
	public static ExtentTest extentTestVar;

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", readConfig.getPropertyFromPropertiesFile("chromePath"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(readConfig.getApplicationUrl());
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, RegistrationPage.class);
		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, MyAccountPage.class);
		PageFactory.initElements(driver, AddressBookPage.class);
		PageFactory.initElements(driver, AddAddressPage.class);
		PageFactory.initElements(driver, ProductDetailsPage.class);
		PageFactory.initElements(driver, ProductsListPage.class);
		PageFactory.initElements(driver, ShoppingCartPage.class);
		PageFactory.initElements(driver, CheckoutPage.class);
		PageFactory.initElements(driver, OrderPlacedPage.class);
	}

	@BeforeTest
	public void setUpExtentReport() {
		report = new ExtentReports(
				"/Users/SI20466403/eclipse-workspace/CapstoneTutorialsNinja/src/test/resources/TestReports"
						+ "/ExtentReport.html",
				true);
		report.addSystemInfo("Host Name", "Siddharth Kishan");
		report.addSystemInfo("User Name", "Siddharth Kishan");
		report.addSystemInfo("Environment", "QA_Environment");
	}

	@AfterTest
	public void endReport() {
		report.flush();
	}

	@AfterMethod
	public void logTestReports(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTestVar.log(LogStatus.FAIL, "FAILED TEST CASE: " + result.getName());
			extentTestVar.log(LogStatus.FAIL, "FAILED TEST CASE DRESCRIPTION: " + result.getThrowable());
			extentTestVar.log(LogStatus.FAIL, extentTestVar
					.addScreenCapture(TakeScreenshot.takeScreenshot("ExtentReport_Fail_" + result.getName() + ".jpg")));

		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTestVar.log(LogStatus.SKIP, "SKIPPED TestCase IS " + result.getName());
			extentTestVar.log(LogStatus.SKIP, extentTestVar
					.addScreenCapture(TakeScreenshot.takeScreenshot("ExtentReport_Skip_" + result.getName() + ".jpg")));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTestVar.log(LogStatus.PASS, "PASSED TESCASE IS " + result.getName());
			extentTestVar.log(LogStatus.PASS, extentTestVar.addScreenCapture(
					TakeScreenshot.takeScreenshot("ExtentReport_Success_" + result.getName() + ".jpg")));
		}
		report.endTest(extentTestVar);
	}
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
