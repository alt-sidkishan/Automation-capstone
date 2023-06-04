package com.wipro.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.wipro.pageObjects.AddAddressPage;
import com.wipro.pageObjects.AddressBookPage;
import com.wipro.pageObjects.HomePage;
import com.wipro.pageObjects.LoginPage;
import com.wipro.pageObjects.MyAccountPage;
import com.wipro.utilities.AddressDataProvider;
import com.wipro.utilities.LoginDataProvider;
import com.wipro.utilities.PageActions;
import com.wipro.utilities.TakeScreenshot;

public class TC02 extends BaseClass {

	// ************ This is the test method to test the login functionality of the
	// Application
	// Input values for login is provided by "loginData" data provider, for every
	// row data present in Xl it will provide one string array

	@Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
	public void testLoginFunctionality(String[] loginData) throws IOException {
		extentTestVar = report.startTest("LoginFunctionality");
		HomePage.goToLoginPage();
		LoginPage.fillLoginForm(loginData);
		TakeScreenshot.takeScreenshot("TC02_loginSuccess.png");
		String webpageName = driver.getTitle();
		if (webpageName.equals("My Account")) {
			// means user successfully logged in to nopCommerce application
			assertEquals(webpageName, "My Account");
			MyAccountPage.clickOnMyAccountDropDown();
			MyAccountPage.goToAddressBookPage();
			AddressBookPage.goToAddAddressPage();
		}
	}

	// ************ This is the test method to test the Add Address functionality of
	// the
	// Application
	// Input values for Add Address fields is provided by "addressData" data
	// provider, for every
	// row data present in Xl it will provide one string array

	@Test(dataProvider = "addressData", dataProviderClass = AddressDataProvider.class, dependsOnMethods = {
			"testLoginFunctionality" })
	public void addNewAddressFunctionality(String[] addressData) throws IOException, InterruptedException {
		extentTestVar = report.startTest("AddNewAddressFunctionality");
		AddAddressPage.fillAddressForm(addressData);
		TakeScreenshot.takeScreenshot("TC02_AddAddressScreenshot.png");
		PageActions.click(AddressBookPage.logoutButton);
	}

}
