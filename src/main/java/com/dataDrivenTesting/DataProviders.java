package com.dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.ExcelUtil;



public class DataProviders {
	static String baseDir = System.getProperty("user.dir");
	static String FilePath;
	static String SheetName;
	static Object[][] data;
	
	/**
	 * This method provides Radio button Tests
	 * @return
	 */
	
	@DataProvider(name = "expectedRadioButtons")
	public  Object[][] radioButtonOptions() {
		return new Object[][] {
			{"Outstation One-Way"}, {"Outstation Round-Trip"},
			{"Airport Transfers"}, {"Hourly Rentals"}
			};
		
	}
	
	/**
	 * This method provides valid From and To Locations
	 * @return
	 */
	
	@Test@DataProvider(name = "validLocations")
	public static Object[][] validLocationListData() {
		FilePath = baseDir+"/src/test/resources/excel_files/City_Data.xlsx"; 
		SheetName = "Valid_Data";
		data= ExcelUtil.validLocationListData(FilePath,SheetName);
		return data;
		
	}
	
	/**
	 * This Method provides same From and To Locations
	 * @return
	 */
	@DataProvider(name = "sameLocations")
	public static Object[][] sameLocationListData() {
		FilePath = baseDir+"/src/test/resources/excel_files/City_Data.xlsx"; 
		SheetName = "Same_City";
		data= ExcelUtil.validLocationListData(FilePath,SheetName);
		return data;
		
	}
	
	

}
