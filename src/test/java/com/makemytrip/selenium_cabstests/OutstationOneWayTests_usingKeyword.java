package com.makemytrip.selenium_cabstests;

import org.testng.annotations.Test;

import com.makemytrip.base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.util.List;

import static com.makemytrip.base.Keyword.*;
import static com.makemytrip.base.LocatorType.*;
import static com.utils.FileUtil.*;


public class OutstationOneWayTests_usingKeyword extends TestBase {

	/**
	 * This method verifies error message after entering same From and To input
	 * fields
	 */
	@Test(dataProvider = "sameLocations", dataProviderClass = com.datadriventesting.DataProviders.class)
	public void sameFromAndToCityErrorMsgValidation(String from, String to) {
		clickOnElement(XPATH, getLocator("click_on_cabs_btn"));
		clickOnElement(XPATH, getLocator("click_on_from_input_box"));
		enterText(XPATH,getLocator("enter_from_city_name"),from);
		clickOnElement(XPATH, getLocator("click_on_given_city_name", from));
		enterText(XPATH, getLocator("enter_to_city_name"), to);
		clickOnElement(XPATH, getLocator("click_on_given_city_name", to));
		String errMsg = getText(XPATH, getLocator("error_msg"));
		Assert.assertTrue(errMsg.contains("cannot be the same"));
		
	}
	
	/**
	 * This method verifies By clicking on Return Date of "Outstation One-Way" ride
	 * type shifts to "Outstation Round-Trip"
	 */
	@Test
	public void messageOnReturnDate() {
		clickOnElement(XPATH, getLocator("click_on_cabs_btn"));
		clickOnElement(XPATH, getLocator("click_on_outstation_one_way_form_tag_return"));
		String val = getDomAttributeValue(XPATH, getLocator("outstation_road_trip_radio_btn"), "class");
		Assert.assertTrue(val.contains("selectedText"));
	}

	

}
