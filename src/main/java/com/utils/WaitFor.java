package com.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.base.Keyword;

public class WaitFor {
	
	public static WebDriverWait wait;
	
	static {
		wait = new WebDriverWait(Keyword.driver, Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withMessage("wait excedded");
	}
	
	
	public static void elementToBeClickable(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));

	}
	
	public static void elementToBeVisible(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public static void elementToBeClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}

	public static WebElement elementToBeVisible(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	
	
	

}
