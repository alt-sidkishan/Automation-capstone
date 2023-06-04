package com.wipro.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.testCases.BaseClass;

public class PageActions extends BaseClass {

	public static void setDriver(WebDriver driver, WebDriverWait wait) {
		PageActions.driver = driver;
		PageActions.wait = wait;
	}
	public static void SendKeys(WebElement element, String data) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(data);

	}

	public static void click(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public static void selectOptionByText(WebElement element, String value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public static String getText(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
}
