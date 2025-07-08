package com.makemytrip.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.WaitFor;

public class CabSearchPage {
	
	@FindBy(xpath = "//input[@id='fromCity']")
	WebElement clickOnFromCityTab;
	
	@FindBy(xpath = "//div[@class='autoSuggestPlugin hsw_autocomplePopup']//child::div//child::input")
	WebElement enterTextOnFromCityTabElement;
	
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
	
	public void clickOnSearchBtn() {
		clickOnSearchBtn.click();

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
		WaitFor.elementToBeVisible(enterTextOnFromCityTabElement);
		enterTextOnFromCityTabElement.sendKeys(text);

	}
	
	public void clickOnCity(String cityName) {
		String value = "//div[@class='autoSuggestPlugin hsw_autocomplePopup']//following::span[contains(text(),'"+cityName+"')]";
		By clickOnCity =By.xpath(value);
		WaitFor.elementToBeVisible(clickOnCity).click();
	}



}
