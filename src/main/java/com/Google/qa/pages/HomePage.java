package com.Google.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Google.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//PageRepository or Object Repository
	
	@FindBy(xpath = "//input[@title='Search']")
	WebElement SearchTextBox;

	@FindBy(id ="hplogo")
	WebElement GoogleLogo;
	
	
	//Initializing Page Object
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String ValidateHomePageTitle() {
		return driver.getTitle();
	}
	
	public Boolean ValidateLogo() {
		return GoogleLogo.isDisplayed();
	}
	
	public SearchPage ValidateSearchFuntionality(String keyword) throws InterruptedException {
		SearchTextBox.sendKeys(keyword);
		SearchTextBox.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		return new SearchPage();
	}
}
