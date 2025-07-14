package com.makemytrip.stepdefinations;

import static com.makemytrip.base.Keyword.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
		CabSearchPage cabsPage = PageFactory.initElements(driver, CabSearchPage.class);
		cabsPage.clickOnFromCityTab();
		cabsPage.enterCity(from);
		cabsPage.clickOnCity(from);
		LOG.info("entered and selected 'From' city");
	}
	
	@And("user enters to city as {string} and clicks on it from suggestions")
	public void enterAndSelectToCity(String to) {
		CabSearchPage cabsPage = PageFactory.initElements(driver, CabSearchPage.class);
		cabsPage.enterCity(to);
		cabsPage.clickOnCity(to);
		LOG.info("entered and selected 'To' city");
	}
	
	@And("User clicks on departure date picker and navigates to next month")
	public void clickOnDepartureDateAndNavigateToNextMonth() {
		CabSearchPage cabsPage = PageFactory.initElements(driver, CabSearchPage.class);
		cabsPage.clickOnDeparture();
		cabsPage.clickOnDepartureForwardArrow();
		cabsPage.clickOnDepartureForwardArrow();
		LOG.info("Clicked on 'Departure Date' and navigated to next month");
		
	}
	
	@And("user selects the departure date")
	public void selectDepartureDate() {
		CabSearchPage cabsPage = PageFactory.initElements(driver, CabSearchPage.class);
		cabsPage.selectDate();
		LOG.info("Selected 'Departure Date'");
	}
	
	@And("user clicks on pickup time and selects hour, minute and click on apply button")
	public void selectTimeAndApply() {
		CabSearchPage cabsPage = PageFactory.initElements(driver, CabSearchPage.class);
		cabsPage.clickOnOutstationOneWay_PickupTime();
		cabsPage.clickOnTime_Hr();
		cabsPage.clickOnTime_min();
		cabsPage.clickOnTime_ApplyBtn();
		LOG.info("Time Selected and applied");
	}
	
	@And("user captures Parent page title")
	public void captureParentPageTitle() {
		parentTitle = driver.getTitle();
		LOG.info("Captured Parent(cabs) page Title");
	}
	
	@And("clicks on search button")
	public void clickOnSearchBtn() {
		CabSearchPage cabsPage = PageFactory.initElements(driver, CabSearchPage.class);
		cabsPage.clickOnSearchBtn();
		LOG.info("Clicked on search");
	}
	
	@Then("user captures Child page title")
	public void captureChildPageTitle() {
		childTitle = driver.getTitle();
		LOG.info("Captured Child(result) page Title");
	}
	
	@And("user closes browser")
	public void browserClosed() {
		driver.quit();
		LOG.info("Browser is closed");
	}
	
	//Validation
	@And("Child page title must be different from Parent page title")
	public void assertTitles() {
		Assert.assertNotEquals(childTitle, parentTitle);
	}
	

}
