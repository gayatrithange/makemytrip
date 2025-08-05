package com.makemytrip.selenium_cabstests;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OutstationRoadTrip_Validation extends BaseTest  {
	
	/**
	 * This method verifies after doing hover on drop Time default message appear.
	 */
	@Test 
	public void dropTimeButtonValidation() {
		driver.findElement(By.xpath("//div[@class=\"makeFlex\"]/descendant::li[@data-cy='outstationRoundTrip']")).click();
		WebElement button = driver.findElement(By.xpath("//input[@id=\"dropTime\"]"));
		boolean status = button.isEnabled();
		System.out.println("status : "+status);
		if(!status) {
			Actions action = new Actions(driver);
			action.moveToElement(button);
			String tipMsg = driver.findElement(By.xpath("//div[@class='rtInfoTooltip']")).getText();
			System.out.println(tipMsg);
		}else
			Assert.assertEquals(status, false);
		
		//Search Button
		driver.findElement(By.xpath("//a[text() = 'Search']")).click();
	}
	
	
	/**
	 * This method verifies default departure date and return date
	 */
	@Test
	public void defaultDepartureAndReturnDateValidation() {
		driver.findElement(By.xpath("//div[@class=\"makeFlex\"]/descendant::li[@data-cy='outstationRoundTrip']")).click();
		String DepartureDate = "";
		String ReturnDate="";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'outstationRound')]//descendant::label[@for='departure']/child::p/span")));
		for(int i = 1; i <= 3 ; i++) {
			DepartureDate += driver.findElement(By.xpath("//div[contains(@class,'outstationRound')]//descendant::label[@for='departure']/child::p/span["+i+"]")).getText()+" ";
			ReturnDate += driver.findElement(By.xpath("//div[contains(@class,'outstationRound')]//descendant::label[@for='return']/child::p/span["+i+"]")).getText()+" ";
		}
		
		
		//converted string date to date format
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("d MMM yy");
		LocalDate returnDate = LocalDate.parse(ReturnDate.trim(), formater);
		LocalDate departureDate = LocalDate.parse(DepartureDate.trim(), formater);
		
		//getting current +1 date
		LocalDate expectedDate = LocalDate.now().plusDays(1);
		//System.out.println(expectedDate);
		
		Assert.assertEquals(departureDate, expectedDate);
		Assert.assertEquals(returnDate, expectedDate);
		
	}
	
	
	

}
