package com.Google.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Google.qa.base.TestBase;

public class LandingPage extends TestBase {
	
	@FindBy(xpath = "//*[@class='header-logo svg-highlightable svg-primary']")
	WebElement LandingPageLogo;
	
	//Initializing Page Object
	
			public LandingPage() {
				PageFactory.initElements(driver, this);
			}
			
			public String ValidateLandingPageTitle() {
				return driver.getTitle();
			}
			
			public boolean ValidateLandingPageLogo() {
				return LandingPageLogo.isDisplayed();
				
			}

}
