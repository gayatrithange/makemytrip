package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class FileUtil {
	private static String baseDir = System.getProperty("user.dir");
	
	
	private static Properties loadProperties(String filePath) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("File to load properties file: "+ filePath);
		}
		
		return prop;


	}

	/**
	 *  This method reads Locator_value from locators.properties File
	 * @param locatorKey
	 * @return
	 */
	public static String getLocator(String locatorKey) {
		String filepath = baseDir+"/src/test/resources/locators.properties";
		Properties prop = loadProperties(filepath);
		return prop.getProperty(locatorKey);
		
	}
	/**
	 * Returns the dynamic locator string by replacing text in the locator template
	 * with the provided dynamic text.
	 * @param locatorKey
	 * @param dynamicText
	 * @return
	 */
	public static String getLocator(String locatorKey , String dynamicText ) {
		 String locatorVal = getLocator(locatorKey);
		 return String.format(locatorVal, dynamicText);
	}
	
	/**
	 * Reads a property value (such as a locator) from the specified properties file. (application.properties)
	 * This is commonly used for reading configuration data such as URLs, browser names, etc.
	 * @param FilePath
	 * @param locatorKey
	 * @return
	 */
	public static String getProperty(String FilePath , String locatorKey) {
		Properties prop = loadProperties(FilePath);
		return prop.getProperty(locatorKey);
	}
	
	/**
	 * Fetches a comma-separated string from testdata.properties and returns it as a String array.
	 * @param locatorKey
	 * @return
	 */
	
	public static String[] getListFromProperty(String locatorKey) {
		String filePath = baseDir+"/src/test/resources/testdata.properties";
		System.out.println(baseDir);
		Properties prop = loadProperties(filePath);
		System.out.println(filePath);
		String locatorVal = prop.getProperty(locatorKey);
		System.out.println(locatorVal);
		String[] formTags = locatorVal.split(",");
		return formTags;
	}
	
	public static void main(String[] args) {
		getListFromProperty("Outstation_One_Way_form_tags");
	}
	
	
		
	
}
