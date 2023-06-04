package com.wipro.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class RegistrationDataProvider extends TestDataProvider {

// ********* This is the data provider method which reads the xl-file and returns the data in the form of 2D-array of Object type
	@DataProvider(name = "registrationData")
	public static Object[][] provideRegistrationData() throws IOException {
		readConfigFile = new ReadConfigFile();
		String registrationDataXlFileLoc = readConfigFile.getPropertyFromPropertiesFile("registrationDataXlFile");
		fis = new FileInputStream(registrationDataXlFileLoc);
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("registration");
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
