package com.makemytrip.selenium_cabstests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static com.makemytrip.base.Keyword.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.datadriventesting.DataProviders;
import com.makemytrip.base.TestBase;
import com.makemytrip.pages.CabResultPage;
import com.makemytrip.pages.CabSearchPage;
import com.makemytrip.pages.LoginPage;

public class OutstationOneWayTests_usingPOM extends TestBase {
	private static final Logger LOG = LogManager.getLogger(OutstationOneWayTests_usingPOM.class);


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
		LOG.info("Entered City -"+ from +" : "+to);
		cabsPage.clickOnDeparture();
		cabsPage.clickOnDepartureForwardArrow();
		cabsPage.clickOnDepartureForwardArrow();
		cabsPage.selectDate();
		cabsPage.clickOnOutstationOneWay_PickupTime();
		cabsPage.clickOnTime_Hr();
		cabsPage.clickOnTime_min();
		cabsPage.clickOnTime_ApplyBtn();
		String parentTitle = driver.getTitle();
		LOG.info("Extracted ParentPage Title: "+parentTitle);
		cabsPage.clickOnSearchBtn();

		// validation :

		String childTitle = driver.getTitle();
		LOG.info("Extracted ChildPage Title: "+childTitle);
		Assert.assertNotEquals(childTitle, parentTitle);

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
		LOG.info("Entered Same From and To City");
		cabsPage.clickOnSearchBtn();
		String attrVal = cabsPage.errorMsgForSameCity("class");
		Assert.assertTrue(attrVal.contains("shake"), "Error Message did not shake");

	}
	
	/**
	 * Checks if all available cars match the given fuel type filter.
	 */
	@Test
	public void FuelTpeFilterverification() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickOnCabsBtn();

		CabSearchPage cabsPage = PageFactory.initElements(driver, CabSearchPage.class);
		cabsPage.clickOnFromCityTab();
		cabsPage.enterCity("Pune, Maharashtra, India");
		cabsPage.clickOnCity("Pune, Maharashtra, India");
		cabsPage.enterCity("Mumbai, Maharashtra, India");
		cabsPage.clickOnCity("Mumbai, Maharashtra, India");
		cabsPage.clickOnSearchBtn();
		
		CabResultPage resultPage = PageFactory.initElements(driver, CabResultPage.class);
		resultPage.waitforFilterToBeVisible();
		resultPage.clickOnTypeOfFuel("Diesel");
		AssertJUnit.assertTrue(resultPage.listOfAvailablecars("Diesel"));
		
	}
	/**
	 * This method verifies default departure date 
	 */
	@Test
	public void defaultDepartureDate() {
		CabSearchPage cabsPage = PageFactory.initElements(driver, CabSearchPage.class);
		String date = cabsPage.getDepartureDate();
		
		//string date converted in date format
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("d MMM yy");
		LocalDate actualDate = LocalDate.parse(date.trim(), formater);
		System.out.println("actualDate: " + actualDate);

		// Current + 1 date
		LocalDate expectedDate = LocalDate.now().plusDays(1);
		System.out.println("expectedDate: " + expectedDate);

		AssertJUnit.assertEquals(expectedDate, actualDate);

	}

}





























