package com.makemytrip.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.WaitFor;

public class LoginPage {
	
	@FindBy(xpath = "//span[@class='commonModal__close']" )
	WebElement loginSignUpCloseBtn;
	
	@FindBy(xpath = "//li[@class='menu_Cabs']")
	WebElement clickOnCabsBtn;
	
	
	
	public void clickOnCabsBtn() {
		WaitFor.elementToBeClickable(clickOnCabsBtn);
		clickOnCabsBtn.click();
	}
	
	public void clickOnCloseBtnOfLoginSignUpPo() {
		WaitFor.elementToBeVisible(loginSignUpCloseBtn);
		loginSignUpCloseBtn.click();

	}
	
	
}
