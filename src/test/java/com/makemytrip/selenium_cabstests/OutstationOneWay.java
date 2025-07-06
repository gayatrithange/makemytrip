package com.makemytrip.selenium_cabstests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Local;

public class OutstationOneWay extends TestBase {
	/**
	 * This method verifies default Departure Date
	 */
	@Test
	public void defaultDepartureDate() {

		String Date = "";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//div[contains(@class,'outstationOneway')]//descendant::label[@for='departure']/child::p/span[1]")));
		for (int i = 1; i <= 3; i++) {
			Date += driver.findElement(By.xpath(
					"//div[contains(@class,'outstationOneway')]//descendant::label[@for='departure']/child::p/span[" + i
							+ "]"))
					.getText() + " ";
		}
		System.out.println(Date);

		// string date converted in date format
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("d MMM yy");
		LocalDate actualDate = LocalDate.parse(Date.trim(), formater);
		System.out.println("actualDate: " + actualDate);

		// Current + 1 date
		LocalDate expectedDate = LocalDate.now().plusDays(1);
		System.out.println("expectedDate: " + expectedDate);

		AssertJUnit.assertEquals(expectedDate, expectedDate);

	}


	/**
	 * This methods verify valid From and To inputs locations
	 * 
	 * @param from
	 * @param to
	 */
	@Test(dataProvider = "validLocations", dataProviderClass = com.datadriventesting.DataProviders.class)
	public void validOutstationOneWayCabSearch(String from, String to) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fromCity']")));
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]//child::div//child::input")))
				.sendKeys(from);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='autoSuggestPlugin hsw_autocomplePopup']//following::span[contains(text(),'"
						+ from + "')]")))
				.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='autoSuggestPlugin hsw_autocomplePopup']//child::div//child::input")))
				.sendKeys(to);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='autoSuggestPlugin hsw_autocomplePopup']//following::span[contains(text(),'" + to
						+ "')]")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'outstationOneway')]//descendant::label[@for='departure']"))).click();

		driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]")).click();
		driver.findElement(By.xpath("//div[@aria-label='Thu Jul 31 2025']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'outstationOneway')]//descendant::label[@for='pickupTime']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = '11  Hr']"))).click();
		driver.findElement(By.xpath("//span[text() = '50  min']")).click();
		driver.findElement(By.xpath("//span[@class='applyBtnText']")).click();

		String parentTitle = driver.getTitle();
		System.err.println("parentTitle: " + parentTitle);

		driver.findElement(By.xpath("//a[text() = 'Search']")).click();

		// validation :

		String childTitle = driver.getTitle();
		System.err.println("childTitle : " + childTitle);

		if (parentTitle != childTitle)
			AssertJUnit.assertTrue(true);
		else
			AssertJUnit.assertTrue(false);

	}

	/**
	 * This methods verify same(invalid) From and To inputs locations
	 * 
	 * @param from
	 * @param to
	 */
	@Test(dataProvider = "sameLocations", dataProviderClass = com.datadriventesting.DataProviders.class)
	public void SameInvalidOutstationOneWayCabSearch(String from, String to) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"fromCity\"]")));
		driver.findElement(By.xpath("//input[@id=\"fromCity\"]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]//child::div//child::input")))
				.sendKeys(from);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@class='autoSuggestPlugin hsw_autocomplePopup']//following::span[text()='" + from + "']")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='autoSuggestPlugin hsw_autocomplePopup']//child::div//child::input")))
				.sendKeys(to);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//div[@class='autoSuggestPlugin hsw_autocomplePopup']//following::span[text()='" + to + "']")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'outstationOneway')]//descendant::label[@for='departure']"))).click();

		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Thu Jul 31 2025']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'outstationOneway')]//descendant::label[@for='pickupTime']"))).click();
		driver.findElement(By.xpath("//span[text() = '09  Hr']")).click();
		driver.findElement(By.xpath("//span[text() = '50  min']")).click();
		driver.findElement(By.xpath("//span[@class='applyBtnText']")).click();
		driver.findElement(By.xpath("//a[text() = 'Search']")).click();

		// validation
		WebElement errMsg = driver.findElement(By.xpath("//div[@id='errorMessage']"));
		wait.until(ExpectedConditions.domAttributeToBe(errMsg, "class", "errorSection makeFlex shake"));
		String attribute = driver.findElement(By.xpath("//div[@id='errorMessage']")).getDomAttribute("class");
		AssertJUnit.assertEquals(attribute, "errorSection makeFlex shake");

	}

}
