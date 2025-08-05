package com.makemytrip.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.makemytrip.base.TestBase;
import com.makemytrip.pages.CabSearchPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CabsPageSteps {
	private static final Logger LOG = LogManager.getLogger(CabsPageSteps.class);
	String parentTitle = "";
	String childTitle = "";
	
	@When("user enters from city as {string} and clicks on it from suggestions")
	public void enterAndSelectFromCity(String from) {
		CabSearchPage cabsPage = PageFactory.initElements(TestBase.driver, CabSearchPage.class);
		cabsPage.clickOnFromCityTab();
		cabsPage.enterCity(from);
		cabsPage.clickOnCity(from);
		LOG.info("entered and selected 'From' city");
	}
	
	@And("user enters to city as {string} and clicks on it from suggestions")
	public void enterAndSelectToCity(String to) {
		CabSearchPage cabsPage = PageFactory.initElements(TestBase.driver, CabSearchPage.class);
		cabsPage.enterCity(to);
		cabsPage.clickOnCity(to);
		LOG.info("entered and selected 'To' city");
	}
	
	@And("User clicks on departure date picker and navigates to next month")
	public void clickOnDepartureDateAndNavigateToNextMonth() {
		CabSearchPage cabsPage = PageFactory.initElements(TestBase.driver, CabSearchPage.class);
		cabsPage.clickOnDeparture();
		cabsPage.clickOnDepartureForwardArrow();
		cabsPage.clickOnDepartureForwardArrow();
		LOG.info("Clicked on 'Departure Date' and navigated to next month");
		
	}
	
	@And("user selects the departure date")
	public void selectDepartureDate() {
		CabSearchPage cabsPage = PageFactory.initElements(TestBase.driver, CabSearchPage.class);
		cabsPage.selectDate();
		LOG.info("Selected 'Departure Date'");
	}
	
	@And("user clicks on pickup time and selects hour, minute and click on apply button")
	public void selectTimeAndApply() {
		CabSearchPage cabsPage = PageFactory.initElements(TestBase.driver, CabSearchPage.class);
		cabsPage.clickOnOutstationOneWay_PickupTime();
		cabsPage.clickOnTime_Hr();
		cabsPage.clickOnTime_min();
		cabsPage.clickOnTime_ApplyBtn();
		LOG.info("Time Selected and applied");
	}
	
	@And("user captures Parent page title")
	public void captureParentPageTitle() {
		parentTitle = TestBase.driver.getTitle();
		LOG.info("Captured Parent(cabs) page Title");
	}
	
	@And("clicks on search button")
	public void clickOnSearchBtn() {
		CabSearchPage cabsPage = PageFactory.initElements(TestBase.driver, CabSearchPage.class);
		cabsPage.clickOnSearchBtn();
		LOG.info("Clicked on search");
	}
	
	@Then("user captures Child page title")
	public void captureChildPageTitle() {
		childTitle = TestBase.driver.getTitle();
		LOG.info("Captured Child(result) page Title");
	}
	
	@And("user closes browser")
	public void browserClosed() {
		TestBase.driver.quit();
		LOG.info("Browser is closed");
	}
	@When("user clicks on return date of Ontstation One-way")
	public void clickOnReturnDate() {
		CabSearchPage cabsPage = PageFactory.initElements(TestBase.driver, CabSearchPage.class);
		cabsPage.clicksOnReturnDate();
	}
	
	@Then("ride type shifts to Outstation Round-Trip")
	public void checkIfRideTypeShifts() {
		CabSearchPage cabsPage = PageFactory.initElements(TestBase.driver, CabSearchPage.class);
		String val = cabsPage.domAttributevalOfRideType();
		Assert.assertTrue(val.contains("selectedText"));
	}
	
	//Validation
	@And("Child page title must be different from Parent page title")
	public void assertTitles() {
		Assert.assertNotEquals(childTitle, parentTitle);
	}
	
	//Validation
	@Then("verify error message displayed below To input text box")
	public void assertErrormsg() {
		CabSearchPage cabsPage = PageFactory.initElements(TestBase.driver, CabSearchPage.class);
		String errMsg = cabsPage.getErrorMsg();
		System.out.println("Error Msg : "+ errMsg);
		Assert.assertTrue(errMsg.contains("cannot be the same"));
	}
	
	//validation
	@And("verify error message shakes")
	public void errorMsgShakes() {
		CabSearchPage cabsPage = PageFactory.initElements(TestBase.driver, CabSearchPage.class);
		String attrVal = cabsPage.errorMsgForSameCity("class");
		Assert.assertTrue(attrVal.contains("shake"), "Error Message did not shake");
	}
	

}
