package com.trains;

import static com.mmt.utils.FileUtility.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.bidi.browsingcontext.Locator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static com.makeMyTrip.base.Keyword.*;
import com.makeMyTrip.base.Locators;
import com.makeMyTrip.base.TestBase;
import com.makeMyTrip.pages.LoginPage;

import  static com.makeMyTrip.pages.LoginPage.*;



/**
 * All test cases of Trains
 */
public class TrainsHomePageTest extends TestBase {

	
	private static final Logger LOG = LogManager.getLogger(TrainsHomePageTest.class);
	@Test
	public void search_trainsUsingKeyword() {
		
		//clickOnElement("CSSSELECTOR", getLocator("login_Close_popup_btn"));// by proerties file
		clickOnElement("CSSSELECTOR",Locators.login_Close_popup_btn);//by interface
		clickOnElement("CSSSELECTOR", Locators.menu_Trains);
		
		clickOnElement("CSSSELECTOR", Locators.from_textbox);
		enterText("CSSSELECTOR",Locators.from_inputbox,"Mumbai");
		clickOnElement("CSSSELECTOR", Locators.from_select_item_from_list);
		
		clickOnElement("CSSSELECTOR", Locators.to_textbox);
		enterText("CSSSELECTOR", Locators.to_inputbox,"Goa");
		clickOnElement("CSSSELECTOR", Locators.to_select_item_from_list);
		
		clickOnElement("CSSSELECTOR", Locators.travel_dateBox);
		clickOnElement("CSSSELECTOR", Locators.travel_date_select);
		
		clickOnElement("CSSSELECTOR", Locators.travel_class);
		
		clickOnElement("CSSSELECTOR", Locators.search_button);
		
	}
	
	
	@Test
	
	public void serachTrainsUsingPOM() {
		LoginPage homepage=PageFactory.initElements(driver, LoginPage.class);
//		homepage.clickOnCloseButtonLoginPopUp();
//		homepage.clickOnTrainTab();
//		homepage.clickOnFromTxt();
//		homepage.enterfrom_inputbox("Mumbai");
//		homepage.clickOnfrom_select_item_from_list();
//		homepage.clickOnFromTxt();
//		homepage.enterTo_inputbox("Goa");
//		homepage.clickTo_select_item_from_list();
//		homepage.clickOnTravel_dateBox();
//		homepage.clickOnTravel_date_select();
//		homepage.clickOntravel_class();
//		homepage.clickOnsearch_button();

	}
	
@Test
	public void same_from_toCity() {
		// TODO Auto-generated method stub
		LOG.info("from and to city same");

	}

}
