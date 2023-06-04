package com.wipro.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.utilities.PageActions;

public class ShoppingCartPage {
	@FindBy(linkText = "iPod Classic")
	public static WebElement productName;
	@FindBy(xpath = "//tbody/tr/td[6]")
	public static WebElement productPrice;
	@FindBy(xpath = "//a[text() = 'Checkout']")
	public static WebElement checkoutBtn;
	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr/td[4]/div/input")
	public static WebElement QuantityInputField;
	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr/td[4]/div/input/following-sibling::span/button")
	public static WebElement updateQuantityButton;

	public static String getProductName() {
		return productName.getText();
	}

	public static String getProductPrice() {
		return productPrice.getText();
	}

	public static void cartCheckout() {
		PageActions.click(checkoutBtn);
	}

	public static void updateQuantityOfProduct(String quantity) {
		PageActions.SendKeys(QuantityInputField, quantity);
		PageActions.click(updateQuantityButton);
	}
}
