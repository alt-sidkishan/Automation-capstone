package com.wipro.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.utilities.PageActions;

public class MyAccountPage {

	@FindBy(xpath = "//a[@href='https://tutorialsninja.com/demo/index.php?route=account/account']")
	public static WebElement myAccountDropMenu;
	@FindBy(xpath = "//li[@class='dropdown open']/ul/li/a")
	public static WebElement myAccountDropdown;
	@FindBy(linkText = "Modify your address book entries")
	public static WebElement modifyOrAddAddress;

	@FindBy(linkText = "Desktops")
	public static WebElement desktopDropMenu;

	@FindBy(linkText = "Mac (1)")
	public static WebElement macDropdown;

	@FindBy(xpath = "//nav[@id='menu']/div[2]/ul/li/a")
	public static List<WebElement> allMenuLinks;

	@FindBy(linkText = "Logout")
	public static WebElement logoutDropdown;
	@FindBy(linkText = "MP3 Players")
	public static WebElement mp3OptionMenu;
	@FindBy(linkText = "Show AllMP3 Players")
	public static WebElement allMp3Players;

	public static void clickOnMyAccountDropDown() {
		PageActions.click(myAccountDropMenu);
		PageActions.click(myAccountDropdown);
	}

	public static void goToAddressBookPage() {
		PageActions.click(modifyOrAddAddress);
	}

	public static void showMacProducts() {
		PageActions.click(desktopDropMenu);
		PageActions.click(macDropdown);
	}

	public static void showAllMp3Products() {
		PageActions.click(mp3OptionMenu);
		PageActions.click(allMp3Players);
	}

	public static void logoutFromAccount() {
		PageActions.click(myAccountDropMenu);
		PageActions.click(logoutDropdown);
	}
}
