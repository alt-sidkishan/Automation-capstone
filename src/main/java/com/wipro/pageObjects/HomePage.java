package com.wipro.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wipro.utilities.PageActions;

public class HomePage {
	@FindBy(xpath = "//a[@href='https://tutorialsninja.com/demo/index.php?route=account/account']")
	public static WebElement myAccountDropMenu;
	@FindBy(linkText = "Register")
	public static WebElement registerDropdown;
	@FindBy(linkText = "Login")
	public static WebElement loginDropdown;
	@FindBy(linkText = "Logout")
	public static WebElement logoutDropdown;

	public static void goToRegistrationPage() throws IOException {
		PageActions.click(myAccountDropMenu);
		PageActions.click(registerDropdown);
	}

	public static void goToLoginPage() throws IOException {
		PageActions.click(myAccountDropMenu);
		PageActions.click(loginDropdown);
	}

	public static void logoutFromAccount() throws IOException {
		PageActions.click(myAccountDropMenu);
		PageActions.click(logoutDropdown);
	}
}
