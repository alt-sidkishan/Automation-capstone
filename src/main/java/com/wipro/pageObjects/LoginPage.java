package com.wipro.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.utilities.PageActions;

public class LoginPage {

	@FindBy(xpath = "//input[@id='input-email']")
	public static WebElement emailInputField;
	@FindBy(xpath = "//input[@id='input-password']")
	public static WebElement passwordInputFied;
	@FindBy(xpath = "//input[@value='Login' and @class='btn btn-primary']")
	public static WebElement loginButton;
	// public static By forgottenPasswordLink = By.xpath(null);

	public static void fillLoginForm(String[] loginInputData) {
		PageActions.SendKeys(emailInputField, loginInputData[0]);
		PageActions.SendKeys(passwordInputFied, loginInputData[1]);
		PageActions.click(loginButton);
	}
}
