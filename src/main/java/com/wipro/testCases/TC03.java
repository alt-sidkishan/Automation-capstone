package com.wipro.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.wipro.pageObjects.CheckoutPage;
import com.wipro.pageObjects.HomePage;
import com.wipro.pageObjects.LoginPage;
import com.wipro.pageObjects.MyAccountPage;
import com.wipro.pageObjects.OrderPlacedPage;
import com.wipro.pageObjects.ProductDetailsPage;
import com.wipro.pageObjects.ProductsListPage;
import com.wipro.pageObjects.ShoppingCartPage;
import com.wipro.utilities.LoginDataProvider;
import com.wipro.utilities.TakeScreenshot;
import com.wipro.utilities.TestOutput;

public class TC03 extends BaseClass {
	// ************ This is the test method to test the Add product and make payment
	// functionality of the Application
	// Input values for login is provided by "loginData" data provider

	@Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
	public void checkoutProductFunctionality(String[] loginData) throws IOException, InterruptedException {
		extentTestVar = report.startTest("PlaceOrderFunctionality");
		HomePage.goToLoginPage();
		LoginPage.fillLoginForm(loginData);
		TakeScreenshot.takeScreenshot("TC03_loginSuccess.png");
		String webpageName = driver.getTitle();
		assertEquals(webpageName, "My Account");
//		if (!webpageName.equals("My Account")) { // case when user could not log into the application
//			TakeScreenshot.takeScreenshot("TC03_loginError.png");
//			assertFalse(false);
//			return;
//		}
		MyAccountPage.showAllMp3Products();
		TakeScreenshot.takeScreenshot("TC03_DesktopList.png");
		ProductsListPage.openMp3ProductPage();
		String productnametext = ProductDetailsPage.productNameHeader.getText();
		String productpricetext = ProductDetailsPage.productprice.getText();
		TestOutput.writeMsgToFile("TC03_prize.txt", "Name: " + productnametext + "\n");
		TestOutput.writeMsgToFile("TC03_prize.txt", "Price: " + productpricetext + "\n");
		ProductDetailsPage.addProductToCart();
		ProductDetailsPage.goToShoppingCartPage();
		TestOutput.writeMsgToFile("TC03_prize.txt",
				"Product Name in Shopping cart: " + ShoppingCartPage.getProductName() + "\n");
		TestOutput.writeMsgToFile("TC03_prize.txt",
				"Product Total Price in Shopping Cart: " + ShoppingCartPage.getProductPrice() + "\n");
		// updating cart quantity to 1
		ShoppingCartPage.updateQuantityOfProduct("1");
		ShoppingCartPage.cartCheckout();

		CheckoutPage.clickContinueBilling(); // error element was null bcoz checkout page was not initialized
		CheckoutPage.clickContinueShipping();
		CheckoutPage.clickContinueShippingMethod();
		CheckoutPage.clickPolicies();
		CheckoutPage.clickContinueTerms();
		CheckoutPage.clickConfirmOrder();
		assertEquals(OrderPlacedPage.getOrderPlacedText(), "Your order has been successfully processed!");
		TakeScreenshot.takeScreenshot("TC03_OrderPlaced.png");
		OrderPlacedPage.clickContinueButton();
		HomePage.logoutFromAccount();
		TakeScreenshot.takeScreenshot("TC03_logoutConfirmation.png");
	}
}
