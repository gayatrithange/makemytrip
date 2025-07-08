package com.makemytrip.selenium_cabstests;

import static com.makemytrip.base.Keyword.*;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.datadriventesting.DataProviders;
import com.makemytrip.base.TestBase;
import com.makemytrip.pages.CabSearchPage;
import com.makemytrip.pages.LoginPage;

public class OutstationOneWayTests_usingPOM extends TestBase {

	/**
	 * This method verifies OutstationOneWay cab search functionality with valid
	 * multiple inputs using dataProvider
	 */
	@Test(dataProvider = "validLocations", dataProviderClass = DataProviders.class)
	public void validOutstationOneWayCabSearch(String from, String to) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		// loginPage.clickOnCloseBtnOfLoginSignUpPo();
		loginPage.clickOnCabsBtn();

		CabSearchPage cabsPage = PageFactory.initElements(driver, CabSearchPage.class);
		cabsPage.clickOnFromCityTab();
		cabsPage.enterCity(from);
		cabsPage.clickOnCity(from);
		cabsPage.enterCity(to);
		cabsPage.clickOnCity(to);
		cabsPage.clickOnDeparture();
		cabsPage.clickOnDepartureForwardArrow();
		cabsPage.clickOnDepartureForwardArrow();
		cabsPage.selectDate();
		cabsPage.clickOnOutstationOneWay_PickupTime();
		cabsPage.clickOnTime_Hr();
		cabsPage.clickOnTime_min();
		cabsPage.clickOnTime_ApplyBtn();
		String parentTitle = driver.getTitle();
		cabsPage.clickOnSearchBtn();

		// validation :

		String childTitle = driver.getTitle();

		if (parentTitle != childTitle)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);

	}

	/**
	 * This Method verified Error Message appear and shakes after entering same From
	 * and To City and click on search
	 */
	@Test
	public void SameInvalidOutstationOneWayCabSearch() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickOnCabsBtn();

		CabSearchPage cabsPage = PageFactory.initElements(driver, CabSearchPage.class);
		cabsPage.clickOnFromCityTab();
		cabsPage.enterCity("Pune, Maharashtra, India");
		cabsPage.clickOnCity("Pune, Maharashtra, India");
		cabsPage.enterCity("Pune, Maharashtra, India");
		cabsPage.clickOnCity("Pune, Maharashtra, India");
		cabsPage.clickOnSearchBtn();
		String attrVal = cabsPage.errorMsgForSameCity("class");
		Assert.assertTrue(attrVal.contains("shake"), "Error Message did not shake");

	}

}
