package com.makemytrip.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.WaitFor;

public class LoginPage {
	private static final Logger LOG = LogManager.getLogger(LoginPage.class);

	
	@FindBy(xpath = "//span[@class='commonModal__close']" )
	WebElement loginSignUpCloseBtn;
	
	@FindBy(xpath = "//li[@class='menu_Cabs']")
	WebElement clickOnCabsBtn;
	
	
	
	public void clickOnCabsBtn() {
		WaitFor.elementToBeClickable(clickOnCabsBtn);
		clickOnCabsBtn.click();
		LOG.info("Clicked on Cabs");
	}
	
	public void clickOnCloseBtnOfLoginSignUpPo() {
		WaitFor.elementToBeVisible(loginSignUpCloseBtn);
		loginSignUpCloseBtn.click();
		
		

	}
	
	
}
