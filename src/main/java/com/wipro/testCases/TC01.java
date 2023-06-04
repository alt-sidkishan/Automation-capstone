package com.wipro.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.wipro.pageObjects.HomePage;
import com.wipro.pageObjects.RegistrationPage;
import com.wipro.utilities.PageActions;
import com.wipro.utilities.RegistrationDataProvider;
import com.wipro.utilities.TakeScreenshot;
import com.wipro.utilities.TestOutput;

public class TC01 extends BaseClass {
	// ************ This is the test method to test the Registration functionality of the Application
	// Input values for registration is provided by data provider, for every row-data present in Xl it will provide one string array
	@Test(dataProvider = "registrationData", dataProviderClass = RegistrationDataProvider.class)
	public void testRegistrationFunctionality(String[] input) throws IOException {
		extentTestVar = report.startTest("RegistrationFunctionality");      // this will creates a toggle for test in html file
		// and all the logs will be added in this level only.
		HomePage.goToRegistrationPage();
		RegistrationPage.fillRegistrationForm(input);
		if (driver.getTitle().equals("Register Account")) {        // case when user is already registered
			String alreadyRegisteredMsg = "Warning: E-Mail Address is already registered!";
			assertEquals(RegistrationPage.getRegisteredUserErrorMessage(), alreadyRegisteredMsg);
			TakeScreenshot.takeScreenshot("TC01_registrationError.png");
			TestOutput.writeMsgToFile("TC01_registrationErrorMsg.txt", alreadyRegisteredMsg);

		} else {   //case when user is having fresh credentials and new account will be created
			WebElement congratsElement = driver.findElement(By.xpath("//div[@id='content']/p"));
			String congratsMessage = PageActions.getText(congratsElement);
			assertEquals(congratsMessage, "Congratulations! Your new account has been successfully created!");
			TakeScreenshot.takeScreenshot("TC01_registrationSuccess.png");
			TestOutput.writeMsgToFile("TC01_registrationSuccessMsg.txt", congratsMessage);
		}
	}
}
