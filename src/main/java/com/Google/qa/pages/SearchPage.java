package com.Google.qa.pages;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Google.qa.base.TestBase;
import com.Google.qa.util.TestUtil;

public class SearchPage extends TestBase {
	
	//PageRepository or Object Repository
	
	@FindBy(id = "result-stats")
	WebElement ResultText;
	

	
	
	//Initializing Page Object
	
		public SearchPage() {
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		
		public String ValidateSearchPageTitle() {
			return driver.getTitle();
		}
		
		public LandingPage NavigateToLandingPage(String SiteURL) throws InterruptedException {
			List<WebElement> Searchelement = (List<WebElement>) driver.findElements(By.xpath("//*[@id='rso']//div/a"));

			for (WebElement Link : Searchelement) {
				if (Link.getText().contains(SiteURL)) {
					System.out.println("URL found");
					Link.click();
					break;
				}
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(5000);
			return new LandingPage();
		}
		

}
