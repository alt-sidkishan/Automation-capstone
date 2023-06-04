package com.wipro.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wipro.utilities.PageActions;

public class ProductDetailsPage {
	@FindBy(xpath = "//div[@id='content']/descendant::h1")
	public static WebElement productNameHeader;

	@FindBy(xpath = "//div[@id='content']/descendant::ul[@class='list-unstyled'][2]/li/h2")
	public static WebElement productprice;
	@FindBy(xpath = "//button[@id='button-cart']")
	public static WebElement addToCartButton;
	@FindBy(xpath = "//i[@class='fa fa-shopping-cart']")
	public static WebElement shoppingCartDropMenu;

	public static void addProductToCart() {
		PageActions.click(addToCartButton);
	}

	public static void goToShoppingCartPage() {
		PageActions.click(shoppingCartDropMenu);
	}
}
