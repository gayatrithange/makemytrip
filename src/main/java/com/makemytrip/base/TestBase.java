package com.makemytrip.base;

import static com.makemytrip.base.Keyword.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.makemytrip.pages.LoginPage;
import com.utils.ApplicationUtil;

public class TestBase {
	private static final Logger LOG = LogManager.getLogger(TestBase.class);

	
	/**
	 * Launches the browser, navigates to the application URL, 
	 * maximizes the window, and closes the initial login/signup popup.
	 * 
	 * Browser name and Application URL are fetched application properties
	 * {@link ApplicationUtil#getBrowserName()} and {@link ApplicationUtil#getAppUrl()}
	 */
	@BeforeMethod
	public static void launchBrowser() {
	openBrowser(ApplicationUtil.getBrowserName());
	launchURL(ApplicationUtil.getAppUrl());
	driver.manage().window().maximize();
	LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	login.clickOnCloseBtnOfLoginSignUpPo();
	LOG.info("Launched browser : Launched URL : and closed login signup popup");
	}
	
	@AfterMethod
    public void tearDown() {
		quitAllWindows();
    }

}
