package com.Google.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Google.qa.base.TestBase;
import com.Google.qa.pages.HomePage;
import com.Google.qa.pages.LandingPage;
import com.Google.qa.pages.SearchPage;

public class LandingPageTest extends TestBase{
	
	HomePage homepage;
	SearchPage searchpage;
	LandingPage landingpage;

	public LandingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialisation();
		homepage = new HomePage();
		searchpage =homepage.ValidateSearchFuntionality(prop.getProperty("searchkeyword"));
		landingpage=searchpage.NavigateToLandingPage(prop.getProperty("SiteURL"));
	}
	
	
	@Test(priority =1)
	public void LandingPageTitleTest() {
		String Landing_Page_Title = landingpage.ValidateLandingPageTitle();
		System.out.println(Landing_Page_Title);
		Assert.assertTrue(Landing_Page_Title.contains("Sierra"));
	}
//	@Test(priority =2)
//	public void LandingPageLogoTest() throws InterruptedException {
//		Assert.assertTrue(landingpage.ValidateLandingPageLogo());
//	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	

}
