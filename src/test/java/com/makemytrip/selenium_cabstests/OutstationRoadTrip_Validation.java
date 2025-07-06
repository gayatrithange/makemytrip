package com.makemytrip.selenium_cabstests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OutstationRoadTrip_Validation extends BaseTest  {
	//TC_Cab_023
	@Test
	public void validOutstationRoundTripCabSearch() {
		driver.findElement(By.xpath("//div[@class=\"makeFlex\"]/descendant::li[@data-cy=\"outstationRoundTrip\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fromCity']")));
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]//child::div//child::input"))).sendKeys("pune");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='autoSuggestPlugin hsw_autocomplePopup']//following::span[text()='Pune, Maharashtra, India']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='autoSuggestPlugin hsw_autocomplePopup']//child::div//child::input"))).sendKeys("mumbai");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='autoSuggestPlugin hsw_autocomplePopup']//following::span[contains(text(),'Terminal 2')]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Wed Jun 11 2025']"))).click();
		driver.findElement(By.xpath("//div[@aria-label='Fri Jun 13 2025']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = '09  Hr']"))).click();
		driver.findElement(By.xpath("//span[text() = '50  min']")).click();
		driver.findElement(By.xpath("//span[@class='applyBtnText']")).click();
		
		
	}
	
	//TC_Cab_024
	@Test (dependsOnMethods ="validOutstationRoundTripCabSearch")
	public void dropTimeButtonValidation() {
		WebElement button = driver.findElement(By.xpath("//input[@id=\"dropTime\"]"));
		boolean status = button.isEnabled();
		System.out.println("status : "+status);
		if(!status) {
			Actions action = new Actions(driver);
			action.moveToElement(button);
			String tipMsg = driver.findElement(By.xpath("//div[@class='rtInfoTooltip']")).getText();
			System.out.println(tipMsg);
		}else
			AssertJUnit.assertEquals(status, false);
		
		//Search Button
		driver.findElement(By.xpath("//a[text() = 'Search']")).click();
	}
	
	
	//TC_Cab_025
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
		
		AssertJUnit.assertEquals(departureDate, expectedDate);
		AssertJUnit.assertEquals(returnDate, expectedDate);
		
	}
	
	//TC_Cab_026
	@Test
	public void addStopsButtonValidation() throws InterruptedException {
		String[] cities = {"Pune","Delhi","Mumbai","Kolkata","Goa"};
		driver.findElement(By.xpath("//div[@class='makeFlex']/descendant::li[@data-cy='outstationRoundTrip']")).click();
		By addMoreCityBtn = By.xpath("//p[@class ='addMoreTxt']");
		
		
		for(int i = 0; i < 5; i++) {
			Thread.sleep(2000);
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ul[@class='react-autosuggest__suggestions-list']")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(addMoreCityBtn)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='react-autosuggest__suggestions-list']")));
			WebElement ele = driver.findElement(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/descendant::div/descendant::span[contains(text(),'"+cities[i]+"')]"));
			actions.moveToElement(ele).click().perform();
	
		}
		//Checking if Button is visible if not, get the count of number of stops
		int stopsCount =0;
		List<WebElement> btnVisiblity = driver.findElements(addMoreCityBtn);
		if(btnVisiblity.isEmpty()) {
			List<WebElement> ele =  driver.findElements(By.xpath("//div[@class ='multiCityView-container']/child::div"));
			stopsCount = ele.size();
		}
		
		AssertJUnit.assertEquals(stopsCount, 5);
		
		
	}
	

}
