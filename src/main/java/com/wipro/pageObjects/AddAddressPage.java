package com.wipro.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.utilities.PageActions;

public class AddAddressPage {
	@FindBy(id = "input-firstname")
	public static WebElement firstNameInputField;
	@FindBy(id = "input-lastname")
	public static WebElement lastNameInputField;
	@FindBy(id = "input-company")
	public static WebElement companyInputField;
	@FindBy(id = "input-address-1")
	public static WebElement address1InputField;

	@FindBy(id = "input-address-2")
	public static WebElement address2InputField;
	@FindBy(id = "input-city")
	public static WebElement cityInputField;

	@FindBy(id = "input-postcode")
	public static WebElement postcodeInputField;

	@FindBy(id = "input-country")
	public static WebElement countrySelectElement;

	@FindBy(id = "input-zone")
	public static WebElement stateSelectElement;
	@FindBy(xpath = "//input[@value = '1']")
	public static WebElement defaultAddressYes;
	@FindBy(xpath = "//input[@value = 'Continue']")
	public static WebElement continueButton;

	//Method to fill all the input fields of address form present in add address page
	public static void fillAddressForm(String[] addressData) {
		PageActions.SendKeys(firstNameInputField, addressData[0]);
		PageActions.SendKeys(lastNameInputField, addressData[1]);
		PageActions.SendKeys(companyInputField, addressData[2]);
		PageActions.SendKeys(address1InputField, addressData[3]);
		PageActions.SendKeys(address2InputField, addressData[4]);
		PageActions.SendKeys(cityInputField, addressData[5]);
		PageActions.SendKeys(postcodeInputField, addressData[6]);
		// select country
		PageActions.click(countrySelectElement);
		PageActions.selectOptionByText(countrySelectElement, addressData[7]);

		// select state
		PageActions.click(stateSelectElement);
		PageActions.selectOptionByText(stateSelectElement, addressData[8]);
		// Default address radio button
		if (addressData[7].equalsIgnoreCase("yes")) {
			PageActions.click(defaultAddressYes);
		}
		PageActions.click(continueButton);
	}
}
