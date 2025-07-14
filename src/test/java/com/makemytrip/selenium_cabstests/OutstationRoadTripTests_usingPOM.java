package com.makemytrip.selenium_cabstests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static com.makemytrip.base.Keyword.driver;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.makemytrip.base.TestBase;
import com.makemytrip.pages.CabSearchPage;
import com.makemytrip.pages.LoginPage;

public class OutstationRoadTripTests_usingPOM extends TestBase {
	/**
	 * This method verifies OutstationRoundTrip valid search functionality
	 */
	@Test
	public void validOutstationRoundTripCabSearch() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickOnCabsBtn();

		CabSearchPage cabsPage = PageFactory.initElements(driver, CabSearchPage.class);
		cabsPage.clickOnOutstationRoundTripRadioBtn();
		cabsPage.clickOnFromCityTab();
		cabsPage.enterCity("Pune, Maharashtra, India");
		cabsPage.clickOnCity("Pune, Maharashtra, India");
		cabsPage.enterCity("Mumbai, Maharashtra, India");
		cabsPage.clickOnCity("Mumbai, Maharashtra, India");
		cabsPage.clickOnDepartureForwardArrow();
		cabsPage.clickOnDepartureForwardArrow();
		cabsPage.selectDate();
		cabsPage.selectDate();
		cabsPage.clickOnTime_Hr();
		cabsPage.clickOnTime_ApplyBtn();
		cabsPage.clickOnSearchBtn();
		AssertJUnit.assertTrue((driver.getTitle()).contains("Cab Booking"));
	}
	
	/**
	 * This method verifies add stops button should get removed after five click.
	 * @throws InterruptedException
	 */
	
	@Test
	public void addStopsButtonValidation() throws InterruptedException {
		String[] cities = {"Pune","Delhi","Mumbai","Kolkata","Goa"};
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickOnCabsBtn();

		CabSearchPage cabsPage = PageFactory.initElements(driver, CabSearchPage.class);
		cabsPage.clickOnOutstationRoundTripRadioBtn();
		int stopsCount = 0;
		
		for(int i = 0; i < 6; i++) {
		Thread.sleep(2000);
			if(cabsPage.isStopsBtnDisplayed()) {
				cabsPage.clickOnAddMoreStopsBtn();
				cabsPage.waitForCityListToBeVisible();
				cabsPage.clickOnMoreStopsCity(cities[i]);
				stopsCount++;
			}else
				break;
		}
		
		AssertJUnit.assertEquals(stopsCount, 5);
		
		
	}

}
