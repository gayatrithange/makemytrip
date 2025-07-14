package com.makemytrip.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.makemytrip.base.Keyword;
import com.utils.WaitFor;

import static com.makemytrip.base.Keyword.*;

import java.util.List;

public class TrainSearchPage {

	private static final Logger LOG = LogManager.getLogger(TrainSearchPage.class);

//	@FindBy(css = "span.commonModal__close")
//	WebElement login_Close_popup_btnElement;
//	public void clickOnlogin_Close_popup_btnElement() {
//		WaitFor.elementToBeVisible(login_Close_popup_btnElement);
//		login_Close_popup_btnElement.click();
//
//	}

	@FindBy(css = "li[data-cy='menu_Trains']")
	WebElement menu_Trains;

	public void clickOnTrainTab() {

		menu_Trains.click();
	}

	@FindBy(css = "div[data-cy=\"RailSearchWidget_338\"]")
	WebElement from_textbox;

	public void clickOnFromTxt() {
		WaitFor.elementToBeClickable(from_textbox);
		from_textbox.click();

	}

	@FindBy(css = "input[aria-controls=\"react-autowhatever-1\"]")
	WebElement from_inputbox;

	public void enterfrom_inputbox(String from_input) throws InterruptedException {
		Thread.sleep(3000);
		from_inputbox.click();
	}

	@FindBy(css = "li#react-autowhatever-1-section-0-item-1")
	WebElement from_select_item_from_list;

	public void clickOnfrom_select_item_from_list() {
		WaitFor.elementToBeVisible(from_select_item_from_list);
		from_select_item_from_list.click();
	}

	@FindBy(css = "div[data-cy=\"RailSearchWidget_339\"]")
	WebElement to_textbox;

	public void clickOn_to_textbox() {
		WaitFor.elementToBeClickable(to_textbox);
		to_textbox.click();
	}

	@FindBy(css = "input[placeholder=\"To\"]")
	WebElement to_inputbox;

	public void enterTo_inputbox(String cityName) {
		WaitFor.elementToBeClickable(to_inputbox);
		to_inputbox.sendKeys(cityName);
	}

	@FindBy(css = "li#react-autowhatever-1-section-0-item-0")
	WebElement to_select_item_from_list;

	public void select_input_Tocity_list() throws InterruptedException {
		Thread.sleep(3000);
		//WaitFor.elementToBeVisible(to_select_item_from_list);
		to_select_item_from_list.click();
	}

	@FindBy(css = "div[data-cy=\"RailSearchWidget_340\"]")
	WebElement travel_dateBox;

	public void clickOnTravel_dateBox() {
		travel_dateBox.click();
	}

	@FindBy(css = "div[aria-label=\"Wed Jul 09 2025\"]")
	WebElement select_travel_date;

	public void selectTravel_date() {

		select_travel_date.click();
	}

	@FindBy(css = "ul[class='travelForPopup']>li[data-cy='3A']")
	WebElement travel_class;

	public void clickOntravel_class() {
		WaitFor.elementToBeVisible(travel_class);
		travel_class.click();
	}

	@FindBy(css = "a[data-cy=\"submit\"]")
	WebElement search_button;

	public void clickOnsearch_button() {
		search_button.click();
	}

	// pune-chennai(18 july)
	@FindBy(css = "div.FilterCard_filterCardSection__oJyM2>div+div>ul>li:nth-child(2)>label[for=\"Trip Guarantee\"]")
	WebElement trip_Gurantee;

	public void ClickOntrip_Gurantee() {
		trip_Gurantee.click();
	}

	@FindBy(css = "[data-testid=\"train-name\"]")
	List<WebElement> list_of_trainName;

	public void train_name() {

		int List_count = list_of_trainName.size();
		System.out.println(List_count);

	}

	@FindBy(css = "label[for=\"Trip Guarantee\"]>div+span")

	WebElement Trip_Guarantee_count;

	private void trip_Guarantee_count() {
		int Trip_Guarantee_countNO = Integer.parseInt(Trip_Guarantee_count.getText());

	}

}
