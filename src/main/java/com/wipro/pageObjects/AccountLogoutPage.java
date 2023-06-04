package com.wipro.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//Following page object model design pattern to keep all the elements and 
//their methods in a separate class belonging to every page present in the application
public class AccountLogoutPage {

	// Logout success message element
	@FindBy(xpath = "//div[@id='content']/p")
	public static WebElement logoutMessagElement;

	public static String getLogoutMessage() {
		return logoutMessagElement.getText();
	}
}
