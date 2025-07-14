package com.makemytrip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.makemytrip.base.Keyword;
import com.utils.WaitFor;

public class CabSearchPage {
	
	@FindBy(xpath = "//input[@id='fromCity']")
	WebElement clickOnFromCityTab;
	
	@FindBy(xpath = "//div[@class='autoSuggestPlugin hsw_autocomplePopup']//child::div//child::input")
	WebElement enterTextOnFromCityTab;
	
	@FindBy(xpath = "//div[contains(@class,'outstationOneway')]//descendant::label[@for='departure']")
	WebElement  clickOnDeparture;
	
	@FindBy(xpath = "//span[@aria-label='Next Month']")
	WebElement clickOnDepartureForwardArrow;
	
	@FindBy(xpath = "//div[@aria-label='Tue Oct 14 2025']")
	WebElement selectDate;
	
	@FindBy(xpath = "//div[contains(@class,'outstationOneway')]//descendant::label[@for='pickupTime']")
	WebElement clickOnOutstationOneWay_PickupTime;
	
	@FindBy(xpath = "//span[text() = '11  Hr']")
	WebElement clickOnTime_Hr;
	
	@FindBy(xpath = "//span[text() = '50  min']")
	WebElement clickOnTime_min;
	
	@FindBy(xpath = "//span[@class='applyBtnText']")
	WebElement clickOnTime_ApplyBtn;
	
	@FindBy(xpath = "//a[text() = 'Search']")
	WebElement clickOnSearchBtn;
	
	@FindBy(xpath ="//div[@id='errorMessage']")
	WebElement errorMsgForSameCity;
	
	public String errorMsgForSameCity(String attr) {
		String attrVal = errorMsgForSameCity.getDomAttribute(attr);
		return attrVal;
	}
	
	public void clickOnSearchBtn() {
		clickOnSearchBtn.click();

	}
	
	@FindBy(css = "li[data-cy='outstationOneWay']")
	WebElement clickOnOutstationOneWayRadioBtn;
	
	public void clickOnOutstationOneWayRadioBtn() {
		clickOnOutstationOneWayRadioBtn.click();

	}
	
	@FindBy(css = "li[data-cy='outstationRoundTrip']")
	WebElement clickOnOutstationRoundTripRadioBtn;
	
	public void clickOnOutstationRoundTripRadioBtn() {
		WaitFor.elementToBeVisible(clickOnOutstationRoundTripRadioBtn);
		clickOnOutstationRoundTripRadioBtn.click();

	}
	
	@FindBy(css = "li[data-cy='airportTransfer']")
	WebElement clickOnAirportTransferRadioBtn;
	
	public void clickOnAirportTransferRadioBtn() {
		clickOnAirportTransferRadioBtn.click();
	}
	
	@FindBy(css = "li[data-cy='hourlyRental']")
	WebElement clickOnHourlyRentalRadioBtn;
	
	
	
	public void clickOnMoreStopsCity(String city) {
		WebElement ele = Keyword.driver.findElement(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/descendant::div/descendant::span[contains(text(),'"+city+"')]"));
		Actions action = new Actions(Keyword.driver);
		action.moveToElement(ele).click().perform();
	}
	@FindBy(xpath = "//ul[@class='react-autosuggest__suggestions-list']")
	WebElement waitForCityListToBeVisible;
	
	public void waitForCityListToBeVisible() {
		WaitFor.elementToBeVisible(waitForCityListToBeVisible);

	}
	@FindBy(css = "div.cabMulticityContainer p.addMoreTxt")
	WebElement clickOnAddMoreStopsBtn;
	
	public void clickOnAddMoreStopsBtn() {
		clickOnAddMoreStopsBtn.click();
	}
	public boolean isStopsBtnDisplayed() {
		return clickOnAddMoreStopsBtn.isDisplayed();
	}
	
	@FindBy(css = "div.multiCityView-container>div")
	List<WebElement> getCountOfStops;
	
	public int getCountOfStops() {
		int count = getCountOfStops.size();
		return count;
		
   
	}
	
	@FindBy(css = "p[data-cy = 'departureDate']>span")
	List<WebElement> departureDate;
	
	public String getDepartureDate() {
		String date = "";
		WaitFor.elementToBeVisible(departureDate.get(1));
		for (int i = 0; i < 3; i++) {
			date += departureDate.get(i).getText()+" ";
		}
		return date;

	}
	
	public void clickOnTime_ApplyBtn() {
		clickOnTime_ApplyBtn.click();

	}
	public void clickOnTime_min() {
		WaitFor.elementToBeClickable(clickOnTime_min);
		clickOnTime_min.click();

	}
	public void clickOnTime_Hr() {
		WaitFor.elementToBeClickable(clickOnTime_Hr);
		clickOnTime_Hr.click();

	}
	public void clickOnOutstationOneWay_PickupTime() {
		WaitFor.elementToBeVisible(clickOnOutstationOneWay_PickupTime);
		clickOnOutstationOneWay_PickupTime.click();

	}
	public void selectDate() {
		WaitFor.elementToBeVisible(selectDate);
		selectDate.click();

	}
	
	public void clickOnDepartureForwardArrow() {
		clickOnDepartureForwardArrow.click();

	}
	public void clickOnDeparture() {
		WaitFor.elementToBeClickable(clickOnDeparture);
		clickOnDeparture.click();

	}
	public void clickOnFromCityTab() {
		WaitFor.elementToBeVisible(clickOnFromCityTab);
		clickOnFromCityTab.click();

	}
	
	public void enterCity(String text) {
		WaitFor.elementToBeVisible(enterTextOnFromCityTab);
		enterTextOnFromCityTab.sendKeys(text);

	}
	
	public void clickOnCity(String cityName) {
		String value = "//div[@class='autoSuggestPlugin hsw_autocomplePopup']//following::span[contains(text(),'"+cityName+"')]";
		By clickOnCity =By.xpath(value);
		WaitFor.elementToBeVisible(clickOnCity).click();
	}

	public void clickOnHourlyRentalRadioBtn() {
		clickOnHourlyRentalRadioBtn.click();
		
	}



}
