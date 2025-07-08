package com.makemytrip.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.utils.WaitFor;

public class CabResultPage {
	
	@FindBy(css = "div.cabList_listingWrapper__Ejhgz>div div.cabDetailsCard_cabImage__sEiBn>span")
	List<WebElement>  cabsFuelType;
	
	/**
	 * This method iterates through the list of fuel type labels (from the UI) 
	 * and verifies whether each one contains the specified fuel type.
	 * @param fuelType
	 * @return
	 */
	public boolean listOfAvailablecars(String fuelType) {
		List<WebElement> allFuelTypes = cabsFuelType;
		WaitFor.elementToBeVisible(cabsFuelType.get(1));
		
			for(int i = 0; i <allFuelTypes.size(); i++) {
				if(!allFuelTypes.get(i).getText().toLowerCase().contains(fuelType.toLowerCase())) {
					return false;
				}
			}
			return true;
	}
	
	@FindBy(css = "div.filterWidgetWeb_filterItemWrapper__VrqrK>div:nth-child(3)>div.accordion_contentWrapper__ihqBf  span.filterSection_title__vHRpx")
	List<WebElement> clickOnTypeOfFuel;
	
	/**
	 * This method iterates through the checkboxes of fuel type (from the UI) 
	 * and clicks on specified fuel type.
	 * @param fuelType
	 */
	public void clickOnTypeOfFuel(String fuelType) {
		List<WebElement> checkbox = clickOnTypeOfFuel;
		WaitFor.elementToBeVisible(checkbox.get(1));
		for(int i = 0; i <checkbox.size(); i++) {
			String s= checkbox.get(i).getText();
			if(s.toLowerCase().contains(fuelType.toLowerCase()))
				checkbox.get(i).click();
		}
	}
	
	@FindBy(css = "div.filterWidgetWeb_container__sOxMc")
	WebElement FilterToBeVisible;
	
	public void waitforFilterToBeVisible() {
		WaitFor.elementToBeVisible(FilterToBeVisible);

	}
	

}
