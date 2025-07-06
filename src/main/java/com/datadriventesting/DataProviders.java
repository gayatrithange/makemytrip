package com.dataDrivenTesting;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.ExcelUtil;



public class DataProviders {
	private static String baseDir = System.getProperty("user.dir");
	
	
	/**
	 * This method provides Radio button Tests
	 * Each test data set includes the visible radio button text and the 
	 * corresponding Form tag key (from testdata.properties) to be used for validation.
	 * @return
	 */
	
	@DataProvider(name = "expectedRadioButtons")
	public  Object[][] radioButtonOptions() {
		return new Object[][] {
			{"Outstation One-Way","Outstation_One_Way_form_tags"}, {"Outstation Round-Trip", "Outstation_Round_Trip_form_tags"},
			{"Airport Transfers", "Airport_Transfers_form_tags"}, {"Hourly Rentals", "Hourly_Rentals_form_tags"}
			};
		
	}
	
	/**
	 * This method provides valid From and To Locations
	 * @return
	 */
	
	@Test@DataProvider(name = "validLocations")
	public static Object[][] validLocationListData() {
		String FilePath = baseDir+"/src/test/resources/excel_files/City_Data.xlsx"; 
		String SheetName = "Valid_Data";
		Object[][] data= ExcelUtil.validLocationListData(FilePath,SheetName);
		return data;
		
	}
	
	/**
	 * This Method provides same From and To Locations
	 * @return
	 */
	@DataProvider(name = "sameLocations")
	public static Object[][] sameLocationListData() {
		String FilePath = baseDir+"/src/test/resources/excel_files/City_Data.xlsx"; 
		String SheetName = "Same_City";
		Object[][] data= ExcelUtil.validLocationListData(FilePath,SheetName);
		return data;
		
	}
	
	

}
