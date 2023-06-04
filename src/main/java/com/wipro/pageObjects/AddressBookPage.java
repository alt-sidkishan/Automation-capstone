package com.wipro.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.utilities.PageActions;

public class AddressBookPage {
	@FindBy(linkText = "New Address")
	public static WebElement addAddressButton;

	@FindBy(xpath = "(//a[@href='https://tutorialsninja.com/demo/index.php?route=account/logout'])[2]")
	public static WebElement logoutButton;

	public static void goToAddAddressPage() {
		PageActions.click(addAddressButton);
	}
}
