package com.utils;


public class ApplicationUtil {
	 static String baseDir = System.getProperty("user.dir");
	 static String FilePath = baseDir+"/src/main/resources/application.properties";
	
	public static String getBrowserName() {
		String val = FileUtil.getProperty(FilePath, "browser_name");
		return val;

	}
	
	public static String getAppUrl() {
		String val = FileUtil.getProperty(FilePath, "qa.url");
		return val;

	}

}
