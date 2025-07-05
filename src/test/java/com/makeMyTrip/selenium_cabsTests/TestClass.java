package com.makeMyTrip.selenium_cabsTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.makeMyTrip.base.TestBase;
import static com.makeMyTrip.base.Keyword.*;
import static com.makeMyTrip.base.LocatorType.*;
import static com.utils.FileUtil.*;
public class TestClass extends TestBase {

	@Test(dataProvider = "sameLocations", dataProviderClass = com.dataDrivenTesting.DataProviders.class)
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
