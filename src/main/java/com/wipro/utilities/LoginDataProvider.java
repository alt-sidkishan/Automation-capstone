package com.wipro.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class LoginDataProvider extends TestDataProvider {

	@DataProvider(name = "loginData")
	public static Object[][] provideLoginData() throws IOException {
		readConfigFile = new ReadConfigFile();
		String loginDataXlFileLoc = readConfigFile.getPropertyFromPropertiesFile("loginDataXlFile");
		fis = new FileInputStream(loginDataXlFileLoc);
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("Sheet1");
		int numRows = sheet.getLastRowNum();
		int numCols = sheet.getRow(0).getLastCellNum();
		int r = 0, c = 0;
		Object[][] obj = new Object[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			Row row = sheet.getRow(i + 1);
			for (int j = 0; j < numCols; j++) {
				Cell cell = row.getCell(j);
				DataFormatter formatter = new DataFormatter();
				obj[r][c++] = formatter.formatCellValue(cell);
			}
		}
		return obj;
	}
}
