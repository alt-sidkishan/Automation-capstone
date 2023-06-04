package com.wipro.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.utilities.PageActions;

public class ProductsListPage {
	@FindBy(linkText = "iMac")
	public static WebElement iMacProductPageLink;
	@FindBy(linkText = "iPod Classic")
	public static WebElement mp3ProductPageLink;

	public static void openiMacProductPage() {
		PageActions.click(iMacProductPageLink);
	}

	public static void openMp3ProductPage() {
		PageActions.click(mp3ProductPageLink);
	}
}
