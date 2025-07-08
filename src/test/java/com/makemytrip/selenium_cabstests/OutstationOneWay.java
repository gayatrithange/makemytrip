package com.makemytrip.selenium_cabstests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OutstationOneWay extends BaseTest {
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



}
