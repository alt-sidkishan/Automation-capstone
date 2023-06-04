package com.wipro.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.utilities.PageActions;

public class OrderPlacedPage {
	@FindBy(xpath = "//div[@id='content']/p")
	public static WebElement orderPlacedTextElement;

	@FindBy(linkText = "Continue")
	public static WebElement continueButton;

	public static String getOrderPlacedText() {
		return PageActions.getText(orderPlacedTextElement);
	}

	public static void clickContinueButton() {
		continueButton.click();
	}
}
