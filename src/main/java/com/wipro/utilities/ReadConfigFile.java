package com.wipro.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	Properties properties;
	String configFileLoc = "/Users/SI20466403/eclipse-workspace/CapstoneTutorialsNinja/src/test/resources/configuration/config.properties";

	public ReadConfigFile() {
		File propFile = new File(configFileLoc);
		try {
			FileInputStream fis = new FileInputStream(propFile); // give path
			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is: " + e.getMessage());
		}

	}

	public String getPropertyFromPropertiesFile(String property) {
		return properties.getProperty(property);
	}

	public String getApplicationUrl() {
		return properties.getProperty("baseUrl");
	}

}
