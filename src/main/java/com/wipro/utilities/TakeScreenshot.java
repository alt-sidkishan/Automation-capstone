package com.wipro.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.wipro.testCases.BaseClass;

public class TakeScreenshot extends BaseClass {
	public static TakesScreenshot screenshot;
	public static File screenshotFile;
	public static String screenshotFolder = "/Users/SI20466403/eclipse-workspace/CapstoneTutorialsNinja/src/test/resources/screenshots/";

	public static String takeScreenshot(String destLoc) throws IOException {
		screenshot = (TakesScreenshot) driver;
		screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(screenshotFolder + destLoc));
		return screenshotFolder + destLoc;
	}
}
