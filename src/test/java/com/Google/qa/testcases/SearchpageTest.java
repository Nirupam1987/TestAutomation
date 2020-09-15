package com.Google.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Google.qa.base.TestBase;
import com.Google.qa.pages.HomePage;
import com.Google.qa.pages.LandingPage;
import com.Google.qa.pages.SearchPage;

public class SearchpageTest extends TestBase {
	
	HomePage homepage;
	SearchPage searchpage;
	LandingPage landingpage;

	public SearchpageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialisation();
		homepage = new HomePage();
		searchpage =homepage.ValidateSearchFuntionality(prop.getProperty("searchkeyword"));
	}
	
	
	@Test(priority =1)
	public void SearchPageTitleTest() {
		String Search_Page_Title = searchpage.ValidateSearchPageTitle();
		Assert.assertTrue(Search_Page_Title.contains("Google Search"));
	}
	@Test(priority =2)
	public void NavigationToLandingpage() throws InterruptedException {
		landingpage = searchpage.NavigateToLandingPage(prop.getProperty("SiteURL"));
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
}
