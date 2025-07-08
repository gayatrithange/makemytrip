package com.makemytrip.selenium_cabstests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import com.makemytrip.base.TestBase;
import com.makemytrip.pages.CabSearchPage;
import com.makemytrip.pages.LoginPage;

import static com.makemytrip.base.Keyword.*;
import static com.makemytrip.base.LocatorType.*;
import static com.utils.FileUtil.*;
public class TestClass extends TestBase {

	@Test(dataProvider = "sameLocations", dataProviderClass = com.datadriventesting.DataProviders.class)
	public void sameFromAndToCityErrorMsgValidationUsingKeyword(String from, String to) {
		clickOnElement(XPATH, getLocator("click_on_cabs_btn"));
		clickOnElement(XPATH, getLocator("click_on_from_input_box"));
		enterText(XPATH,getLocator("enter_from_city_name"),from);
		clickOnElement(XPATH, getLocator("click_on_given_city_name", from));
		enterText(XPATH, getLocator("enter_to_city_name"), to);
		clickOnElement(XPATH, getLocator("click_on_given_city_name", to));
		String errMsg = getText(XPATH, getLocator("error_msg"));
		Assert.assertTrue(errMsg.contains("cannot be the same"));
		
		
	}
	

}
