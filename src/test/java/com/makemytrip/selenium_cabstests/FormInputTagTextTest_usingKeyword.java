package com.makemytrip.selenium_cabstests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.makemytrip.base.Keyword.*;
import static com.makemytrip.base.LocatorType.*;
import static com.utils.FileUtil.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.datadriventesting.DataProviders;
import com.makemytrip.base.TestBase;

public class FormInputTagTextTest_usingKeyword extends TestBase {
	private static final Logger LOG = LogManager.getLogger(FormInputTagTextTest_usingKeyword.class);


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
		clickOnElement(XPATH, getLocator("all_radio_button", radioButtonText));
		String[] expectedFormTags = getListFromProperty(formInputTag);
		List<WebElement> actualFormTags = getListOfElementTexts(XPATH, getLocator("list_of_Cabs_form_tags"));

		for (int i = 0; i < expectedFormTags.length; i++) {
			String actual = actualFormTags.get(i).getText().toLowerCase().trim();

			String expected = expectedFormTags[i].toLowerCase().trim();
			System.out.print(actual + " " + expected);
			System.out.println();
			AssertJUnit.assertTrue(actual.contains(expected));

		}
		LOG.info("Imput form tags are correct for : "+radioButtonText);
		
	}

}
