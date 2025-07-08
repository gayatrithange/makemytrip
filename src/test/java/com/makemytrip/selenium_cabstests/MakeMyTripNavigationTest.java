package com.makemytrip.selenium_cabstests;

import org.testng.annotations.Test;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MakeMyTripNavigationTest {
RemoteWebDriver driver;
	
	//TC_Web_001
     @Test
	public void chromeBrowser() {
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"commonModal__close\"]")));
		driver.findElement(By.xpath("//span[@class=\"commonModal__close\"]")).click();
		System.out.println("Chrome passed");
	}
	
	//TC_Web_002
     @Test
	public void safariBrowser() {
		driver = new SafariDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"commonModal__close\"]")));
		driver.findElement(By.xpath("//span[@class=\"commonModal__close\"]")).click();
		System.out.println("Safari passed");
	}

}
