package com.makemytrip.stepdefinitions;

import static com.makemytrip.base.Keyword.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import com.makemytrip.base.TestBase;
import com.makemytrip.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class HomePageSteps {
	private static final Logger LOG = LogManager.getLogger(HomePageSteps.class);
	TestBase testbase = new TestBase();

	
	/*@Given("URL is launched and login signup popup is closed")
	  public void launchBrowserAndClosePopup() {
		testbase.launchBrowser();
		LOG.info("Launched URL and closed on signup popup");  
	}*/
	
	@Given("user clicks on cabs tab")
	public void clickonCabsBtn() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickOnCloseBtnOfLoginSignUpPo();
		loginPage.clickOnCabsBtn();
	}
	
}
