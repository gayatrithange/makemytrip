package com.makemytrip.selenium_cabstests;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.makemytrip.base.TestBase;
import com.makemytrip.pages.CabSearchPage;
import com.makemytrip.pages.LoginPage;

import static com.makemytrip.base.Keyword.*;
import static com.makemytrip.base.LocatorType.*;
import static com.utils.FileUtil.*;
public class TestClass extends TestBase {

	@Test(dataProvider = "sameLocations", dataProviderClass = com.datadriventesting.DataProviders.class)
	public void sameFromAndToCityErrorMsgValidationUsingKeyword(String from, String to) {
		clickOnElement(XPATH, getLocator("click_on_cabs_btn"));
		clickOnElement(XPATH, getLocator("click_on_from_input_box"));
		enterText(XPATH,getLocator("enter_from_city_name"),from);
		clickOnElement(XPATH, getLocator("click_on_given_city_name", from));
		enterText(XPATH, getLocator("enter_to_city_name"), to);
		clickOnElement(XPATH, getLocator("click_on_given_city_name", to));
		String errMsg = getText(XPATH, getLocator("error_msg"));
		AssertJUnit.assertTrue(errMsg.contains("cannot be the same"));
		
		
	}
	@Test
	public void validOutstationOneWayCabSearch() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		//loginPage.clickOnCloseBtnOfLoginSignUpPo();
		loginPage.clickOnCabsBtn();
		
		CabSearchPage CabsPage = PageFactory.initElements(driver, CabSearchPage.class);
		CabsPage.clickOnFromCityTab();
		CabsPage.enterCity("Mumbai, Maharashtra, India");
		CabsPage.clickOnCity("Mumbai, Maharashtra, India");
		CabsPage.enterCity("Pune, Maharashtra, India");
		CabsPage.clickOnCity("Pune, Maharashtra, India");
		CabsPage.clickOnDeparture();
		CabsPage.clickOnDepartureForwardArrow();
		CabsPage.clickOnDepartureForwardArrow();
		CabsPage.selectDate();
		CabsPage.clickOnOutstationOneWay_PickupTime();
		CabsPage.clickOnTime_Hr();
		CabsPage.clickOnTime_min();
		CabsPage.clickOnTime_ApplyBtn();
		String parentTitle = driver.getTitle();
		CabsPage.clickOnSearchBtn();

		// validation :

		String childTitle = driver.getTitle();
		
		if (parentTitle != childTitle)
			AssertJUnit.assertTrue(true);
		else
			AssertJUnit.assertTrue(false);

	}

}
