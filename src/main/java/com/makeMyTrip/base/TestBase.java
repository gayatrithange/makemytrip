package com.makeMyTrip.base;

import static com.makeMyTrip.base.Keyword.*;
import static com.makeMyTrip.base.LocatorType.*;
import static com.utils.FileUtil.getLocator;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makeMyTrip.pages.LoginPage;
import com.utils.ApplicationUtil;

public class TestBase {
	
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
	//clickOnElement(XPATH, getLocator("login_signup_popup_close_btn"));
	}
	
	
    public void quitBrowser() {
		quitAllWindows();
    }
}
