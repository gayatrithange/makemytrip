package com.makeMyTrip.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.makeMyTrip.exceptions.InvalidBrowserNameException;
@Test
public class Keyword {
	 
	public static RemoteWebDriver driver;
	static WebDriverWait wait = null;
	
	public static void openBrowser(String browserName) {
		switch(browserName.toLowerCase()) {
		case "chrome":
			 driver = new ChromeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
            break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			throw new InvalidBrowserNameException(browserName);
		}
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
	public static void quitAllWindows() {
		driver.quit();
	}

	public static void launchURL(String url) {
		driver.get(url);
		
	}
	/**
	 * This method waits until specified WebElement is Clickable and performs Click operation
	 * @param locatorType
	 * @param locator
	 */
	public static void clickOnElement( String locatorType, String locator) {
		waitForElementClickable(locatorType,locator);
		getWebElement(locatorType,locator).click();
		
	}
	/**
	 * This method waits until specified WebElement is visible and performs sendKeys operation
	 * @param locatorType
	 * @param locator
	 * @param text
	 */
	public static void enterText(String locatorType, String locator, String text) {
		waitForElementVisible(locatorType,locator);
		getWebElement(locatorType,locator).sendKeys(text);

	}
	
	/**
	 * This method waits until specified WebElement is visible and performs getText operation
	 * @param locatorType
	 * @param locator
	 * @return
	 */
	public static String getText(String locatorType, String locator) {
		 String text = null;
		 waitForElementVisible(locatorType,locator);
		 text = getWebElement(locatorType,locator).getText();
		return text;
	}
	
	public static String getDomAttributeValue(String locatorType, String locator, String attributeName) {
		waitForElementVisible(locatorType,locator);
		return getWebElement(locatorType, locator).getDomAttribute(attributeName);
	}
		
    
	
	/**
	 * This method waits until specified WebElement is visible and performs findElements operation and returns List<WebElement>
	 * @param locatorType
	 * @param locator
	 * @return
	 */
	public static List<WebElement> getListOfElementTexts(String locatorType, String locator) {
		By by = getBy(locatorType, locator);
		waitForElementVisible(locatorType,locator);
		return driver.findElements(by);
		
		
	}
	
	/**
	 * This method waits until specified WebElement is Clickable 
	 * @param locatorType
	 * @param locator
	 */
	public static void waitForElementClickable(String locatorType,String locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(getBy(locatorType, locator)));
	 			
	}
	
	/**
	 * This method waits until specified WebElement is Visible
	 * @param locatorType
	 * @param locator
	 */
	public static void waitForElementVisible(String locatorType,String locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(getBy(locatorType, locator)));
				
	}
	
	/**
	 * This methods returns selenium 'By' object based on given Locator and Locator Type(eg. id, xpath, cssSelector, name, etc..)
	 * @param locatorType
	 * @param locator
	 * @return
	 */
	private static By getBy(String locatorType,String locator) {
		By by = By.xpath(locator);
		if(locatorType.equalsIgnoreCase("id")) {
			by = By.id(locator);
		}else if(locatorType.equalsIgnoreCase("name")) {
			by = By.name(locator);	
		}else if(locatorType.equalsIgnoreCase("classname")) {
			by = By.className(locator);	
		}else if(locatorType.equalsIgnoreCase("linktext")) {
			by = By.linkText(locator);
		}else if(locatorType.equalsIgnoreCase("partiallinktext")) {
			by = By.partialLinkText(locator);	
		}else if(locatorType.equalsIgnoreCase("tagname")) {
			by = By.tagName(locator);	
		}else if(locatorType.equalsIgnoreCase("xpath")) {
			by = By.xpath(locator);	
		}else if(locatorType.equalsIgnoreCase("cssselector")) {
			by = By.cssSelector(locator);	
		}
		  return by;
		   
	}
		
	    
	/**
	 * This method returns WebElement based on given Locator and Locator Type(eg. id, xpath, cssSelector, name, etc..)
	 * @param locatorType
	 * @param locator
	 * @return
	 */
	private static WebElement getWebElement(String locatorType, String locator) {
		WebElement ele = null;
		if(locatorType.equalsIgnoreCase("id")) {
			ele = driver.findElement(By.id(locator));
		}else if(locatorType.equalsIgnoreCase("name")) {
			ele = driver.findElement(By.name(locator));	
		}else if(locatorType.equalsIgnoreCase("classname")) {
			ele = driver.findElement(By.className(locator));	
		}else if(locatorType.equalsIgnoreCase("linktext")) {
			ele = driver.findElement(By.linkText(locator));	
		}else if(locatorType.equalsIgnoreCase("partiallinktext")) {
			ele = driver.findElement(By.partialLinkText(locator));	
		}else if(locatorType.equalsIgnoreCase("tagname")) {
			ele = driver.findElement(By.tagName(locator));	
		}else if(locatorType.equalsIgnoreCase("xpath")) {
			ele = driver.findElement(By.xpath(locator));	
		}else if(locatorType.equalsIgnoreCase("cssselector")) {
			ele = driver.findElement(By.cssSelector(locator));	
		}
		return ele;
		
		
	}
	

}
