package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesUtility {

	public static FileInputStream fis = null;

	public static String readProperty(String key) {
		Properties prop = new Properties();

		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (prop.getProperty(key) != null) {
			return prop.getProperty(key);
		} else {
			return "proper value not found for" + key;
		}

	}

}
