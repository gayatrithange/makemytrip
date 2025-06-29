package com.makeMyTrip.selenium_cabsTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
	public RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	Actions actions = null;
	
	@BeforeMethod
	public void CabsButtonClickTest() throws IOException {
		driver = new ChromeDriver();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		actions = new Actions(driver);
		driver.get("https://www.makemytrip.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"commonModal__close\"]")));
		driver.findElement(By.xpath("//span[@class=\"commonModal__close\"]")).click();
		driver.findElement(By.xpath("//li[@class=\"menu_Cabs\"]")).click();
		driver.manage().window().maximize();	
	}
	
	@AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
	
	@Test(dataProvider = "validLocations", dataProviderClass = com.dataDrivenTesting.DataProviders.class)
	public void validOutstationOneWayCabSearch(String from, String to) {
		
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fromCity']")));
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]//child::div//child::input")))
				.sendKeys(from);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@class='autoSuggestPlugin hsw_autocomplePopup']//following::span[contains(text(),'"+from+"')]")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='autoSuggestPlugin hsw_autocomplePopup']//child::div//child::input")))
				.sendKeys(to);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@class='autoSuggestPlugin hsw_autocomplePopup']//following::span[contains(text(),'"+to+"')]")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'outstationOneway')]//descendant::label[@for='departure']"))).click();

		driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]")).click();
		driver.findElement(By.xpath("//div[@aria-label='Thu Jul 31 2025']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'outstationOneway')]//descendant::label[@for='pickupTime']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = '11  Hr']"))).click();
		driver.findElement(By.xpath("//span[text() = '50  min']")).click();
		driver.findElement(By.xpath("//span[@class='applyBtnText']")).click();
		driver.findElement(By.xpath("//a[text() = 'Search']")).click();

		// validation
		WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"cabModifySearch\"]")));
		
		
		AssertJUnit.assertTrue(searchResult.isDisplayed());

	}

}
