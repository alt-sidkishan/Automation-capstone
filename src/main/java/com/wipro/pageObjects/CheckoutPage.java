package com.wipro.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.utilities.PageActions;

public class CheckoutPage {

	@FindBy(xpath = "//input[@id='button-payment-address']")
	public static WebElement continueBilling;

	@FindBy(xpath = "//input[@id='button-shipping-address']")
	public static WebElement continueShipping;
	@FindBy(xpath = "//input[@id='button-shipping-method']")
	public static WebElement continueShippingMethod;
	@FindBy(xpath = "//input[@name='agree']")
	public static WebElement policies;
	@FindBy(xpath = "//input[@id='button-payment-method']")
	public static WebElement continueTerms;
	@FindBy(xpath = "//input[@id='button-confirm']")
	public static WebElement confirmOrder;

	public static void clickContinueBilling() {
		PageActions.click(continueBilling);
	}

	public static void clickContinueShipping() {
		PageActions.click(continueShipping);
	}

	public static void clickContinueShippingMethod() {
		PageActions.click(continueShippingMethod);
	}

	public static void clickPolicies() {
		PageActions.click(policies);
	}

	public static void clickContinueTerms() {
		PageActions.click(continueTerms);
	}

	public static void clickConfirmOrder() {
		PageActions.click(confirmOrder);
	}
}
