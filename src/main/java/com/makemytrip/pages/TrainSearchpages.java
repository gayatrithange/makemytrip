package com.makemytrip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrainSearchpages {
	@FindBy(css = "label[for='fromCity]")
	WebElement clickOnFromTextBox;

	@FindBy(css = "input[placeholder='From]")
	WebElement clickOnEnterFromCity;

	@FindBy(css = "//span[contains(text(),'Pune Junction')]")
	WebElement clickOnSelectFromCity;

	@FindBy(css = "input#toCity")
	WebElement clickOnToTextBox;

	@FindBy(css = "input.react-autosuggest__input.react-autosuggest__input--open")
	WebElement clickOnEnterToCity;

	@FindBy(css = "div.react-autosuggest__section-title+ul>li:nth-child(1)")
	WebElement clickOnSelectToCity;

	@FindBy(css = "div[data-cy=\\\"RailSearchWidget_340\\\"]")
	WebElement clickOnTravelDateBox;

	@FindBy(css = "div.DayPicker-Months>div:nth-child(1)>div.DayPicker-Body>div:nth-child(5)>div:nth-child(1)")
	WebElement clickOnSelectTravelDate;
	
	@FindBy(css = "ul.travelForPopup>li:nth-child(4)")
	WebElement clickOnToSelectClass;
	
	@FindBy(xpath = "//a[contains( text(),'Search')]")
	WebElement clickOnToSearchBtn;
	

}
