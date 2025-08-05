package com.makemytrip.stepdefinitions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.makemytrip.base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	private static final Logger LOG = LogManager.getLogger(Hooks.class);
	TestBase testBase = new TestBase();

	@Before
	public void setupScenario() {
		testBase.launchBrowser();
		/*switch((ApplicationUtil.getBrowserName()).toLowerCase()) {
		case "chrome":
			 driver = new ChromeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
            break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		}
		
		launchURL(ApplicationUtil.getAppUrl());
		driver.manage().window().maximize();*/

	}
	
	@After
	public void tearDownScenario() {
		testBase.tearDown();
		/*if (driver != null) {
			driver.quit();
		}*/
		LOG.info("Browser is closed");
	} 

}
