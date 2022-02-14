package org.weatherautomation.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {


	public static Properties propertyLoader() {
		Properties properties = new Properties();
		File file = null;
		FileInputStream fis = null;
		try {
			file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\stg_config.properties");
			fis = new FileInputStream(file);
			try {
				properties.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("failed to load properties file ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("properties file not found at ");
		}
		return properties;
	}
}
