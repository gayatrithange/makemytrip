package com.makeMyTrip.selenium_cabsTests;

import static com.makeMyTrip.base.Keyword.*;
import static com.makeMyTrip.base.LocatorType.*;
import static com.utils.FileUtil.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dataDrivenTesting.DataProviders;
import com.makeMyTrip.base.TestBase;

public class FormInputTagTextTest_usingKeyword extends TestBase {

	/**
	 * Validates the presence form input tag after clicking on a given radio button
	 * type in the cab booking section.
	 * 
	 * @param radioButtonText
	 * @param formInputTag
	 */
	@Test(dataProvider = "expectedRadioButtons", dataProviderClass = DataProviders.class)
	public void formInputTagsValidationForAllRadioBtns(String radioButtonText, String formInputTag) {
		clickOnElement(XPATH, getLocator("click_on_cabs_btn"));
		clickOnElement(XPATH, getLocator("radio_button", radioButtonText));
		String[] expectedFormTags = getListFromProperty(formInputTag);
		List<WebElement> actualFormTags = getListOfElementTexts(XPATH, getLocator("list_of_Cabs_form_tags"));
		System.out.println(actualFormTags.size());

		for (int i = 0; i < expectedFormTags.length; i++) {
			String actual = actualFormTags.get(i).getText().toLowerCase().trim();

			String expected = expectedFormTags[i].toLowerCase().trim();
			System.out.print(actual + " " + expected);
			System.out.println();
			Assert.assertTrue(actual.contains(expected));

		}
		quitBrowser();
	}

}
