package com.wipro.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.utilities.PageActions;

public class RegistrationPage {
	@FindBy(xpath = "//input[@id='input-firstname']")
	public static WebElement firstNameInputField;
	@FindBy(xpath = "//input[@id='input-lastname']")
	public static WebElement lastNameInputField;
	@FindBy(xpath = "//input[@id='input-email']")
	public static WebElement emailInputField;
	@FindBy(xpath = "//input[@id='input-telephone']")
	public static WebElement telephoneInputField;
	@FindBy(xpath = "//input[@id='input-password']")
	public static WebElement passwordInputField;
	@FindBy(xpath = "//input[@id='input-confirm']")
	public static WebElement confirmPasswordInputField;
	@FindBy(xpath = "//input[@name='newsletter']")
	public static WebElement subscribeYesCheckbox;
	@FindBy(xpath = "//input[@name='agree']")
	public static WebElement privacyTick;
	@FindBy(xpath = "//input[@type='submit' and @value='Continue']")
	public static WebElement continueButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	public static WebElement registeredUserError;

	public static void fillRegistrationForm(String[] regInputData) {
		PageActions.SendKeys(firstNameInputField, regInputData[0]);
		PageActions.SendKeys(lastNameInputField, regInputData[1]);
		PageActions.SendKeys(emailInputField, regInputData[2]);
		PageActions.SendKeys(telephoneInputField, regInputData[3]);
		PageActions.SendKeys(passwordInputField, regInputData[4]);
		PageActions.SendKeys(confirmPasswordInputField, regInputData[5]);
		if (regInputData[6].equalsIgnoreCase("Yes")) {
			PageActions.click(subscribeYesCheckbox);
		}
		PageActions.click(privacyTick);
		PageActions.click(continueButton);
	}

	public static String getRegisteredUserErrorMessage() {
		return PageActions.getText(registeredUserError);
	}
}
