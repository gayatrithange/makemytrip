package com.makemytrip.stepdefinations;

import static com.makemytrip.base.Keyword.*;
import  static com.makemytrip.base.TestBase.*;



import com.makemytrip.pages.LoginPage;

import io.cucumber.java.en.Given;

public class HomePageUsingStepDefination {

	@Given("login popup is closed")
	public void login_popup_closed() {
		launchBrowser();
 	}
	
	
}
