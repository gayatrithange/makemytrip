package com.makemytrip.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:CabsPageFeature", glue = {"com.makemytrip.stepdefinitions"},dryRun = false, plugin = {
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
})
public class FeatureRunner extends AbstractTestNGCucumberTests {

}
