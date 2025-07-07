package com.trains;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.bidi.browsingcontext.Locator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static com.makemytrip.base.Keyword.*;
import com.makemytrip.base.Locators;
import com.makemytrip.base.TestBase;
import com.makemytrip.pages.CabSearchPage;
import com.makemytrip.pages.LoginPage;
import com.makemytrip.pages.TrainSearchPage;

import static com.makemytrip.pages.LoginPage.*;

/**
 * All test cases of Trains
 */
public class TrainsHomePageTest extends TestBase {

	private static final Logger LOG = LogManager.getLogger(TrainsHomePageTest.class);

	@Test
	public void search_trainsUsingKeyword() {

		// clickOnElement("CSSSELECTOR", getLocator("login_Close_popup_btn"));// by
		// proerties file
		clickOnElement("CSSSELECTOR", Locators.login_Close_popup_btn);// by interface
		clickOnElement("CSSSELECTOR", Locators.menu_Trains);

		clickOnElement("CSSSELECTOR", Locators.from_textbox);
		enterText("CSSSELECTOR", Locators.from_inputbox, "Mumbai");
		clickOnElement("CSSSELECTOR", Locators.from_select_item_from_list);

		clickOnElement("CSSSELECTOR", Locators.to_textbox);
		enterText("CSSSELECTOR", Locators.to_inputbox, "Goa");
		clickOnElement("CSSSELECTOR", Locators.to_select_item_from_list);

		clickOnElement("CSSSELECTOR", Locators.travel_dateBox);
		clickOnElement("CSSSELECTOR", Locators.travel_date_select);

		clickOnElement("CSSSELECTOR", Locators.travel_class);

		clickOnElement("CSSSELECTOR", Locators.search_button);

	}

	@Test

	public void serachTrainsUsingPOM() throws InterruptedException {
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		//loginPage.clickOnCloseBtnOfLoginSignUpPo();
		loginPage.clickOnCabsBtn();
		
		TrainSearchPage homepage = PageFactory.initElements(driver, TrainSearchPage.class);
		homepage.clickOnTrainTab();
		homepage.clickOnFromTxt();
		homepage.enterfrom_inputbox("Pune");
		homepage.clickOnfrom_select_item_from_list();
		homepage.clickOn_to_textbox();
		homepage.enterTo_inputbox("Goa");
		homepage.select_input_Tocity_list();
		homepage.clickOnTravel_dateBox();
		homepage.selectTravel_date();
		homepage.clickOntravel_class();
		homepage.clickOnsearch_button();

	}

	@Test
	public void same_from_toCity() {
		// TODO Auto-generated method stub
		LOG.info("from and to city same");

	}

}
