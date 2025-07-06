package com.makemytrip.selenium_cabstests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RideTypeRadioButtonValidation extends BaseTest {
	String attr = "";
	List<WebElement> actualRadioBtnText;

	// TC_Cab_005
	@Test
	public void RideTypeRadioButtonCountTest() {
		List<String> expectedRadioBtnTextList = Arrays.asList("Outstation One-Way", "Outstation Round-Trip",
				"Airport Transfers", "Hourly Rentals");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("(//li[@class=\"b2c_selected selectedText\" or @class = \"notSelectedText\"])[4]")));
		actualRadioBtnText = driver.findElements(By.xpath("//ul[@class='latoBlack greyText b2c_cswTabs']//child::li"));
		AssertJUnit.assertEquals(actualRadioBtnText.size(), expectedRadioBtnTextList.size());
		// System.out.println(actualRadioBtnText);
	}

	// TC_Cab_006
	@Test(dataProvider = "expectedRadioButtons", dataProviderClass = com.datadriventesting.DataProviders.class, dependsOnMethods = "RideTypeRadioButtonCountTest")
	public void RideTypeRadioButtonTextTest(String radioButtonText, String formTag) {
		for (WebElement radioBtn : actualRadioBtnText) {
			System.out.println(radioBtn);
			if (radioBtn.getText().contains(radioButtonText)) {
				AssertJUnit.assertTrue(radioBtn.isDisplayed(), radioButtonText);
			}
		}

		WebElement rideBtn = driver.findElement(By.xpath("//ul[@class='latoBlack greyText b2c_cswTabs']/descendant::li[text()='" + radioButtonText + "']"));
		rideBtn.click();
		attr = rideBtn.getDomAttribute("class");
		if (attr.contains("selectedText"))
			AssertJUnit.assertTrue(true);

		else
			AssertJUnit.assertTrue(false);
		

	}

	// TC_Cab_007
	@Test(dependsOnMethods = "RideTypeRadioButtonTextTest")
	public void VerifyOnlyOneRideTypeRadioButtonIsSelected() {

		int selectedCount = 0;
		for (int i = 0; i < actualRadioBtnText.size(); i++) {
			String className = driver.findElement(By.cssSelector("ul[class*='greyText']>li:nth-child(" + (i + 1) + ")"))
					.getDomAttribute("class");
			if (attr.equals(className))
				selectedCount++;
		}
		AssertJUnit.assertEquals(selectedCount, 1);

	}

}
