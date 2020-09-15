package com.Google.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Google.qa.pages.HomePage;
import com.Google.qa.pages.SearchPage;
import com.Google.qa.base.TestBase;

public class HomePageTest extends TestBase {
	
	HomePage homepage;
	SearchPage searchpage;
	
	public HomePageTest() {
		super();
	}

	
	@BeforeMethod
	public void SetUp() {
		initialisation();
		homepage = new HomePage();
	}
	
	@Test(priority =1)
	public void HomePageTitleTest() {
		String Home_Page_Title = homepage.ValidateHomePageTitle();
		Assert.assertEquals(Home_Page_Title, "Google");
		
	}
	
	@Test(priority =2)
	public void HomePageLogoTest() {
		boolean flag = homepage.ValidateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority =3)
	public void HomePageSearchFuntionalityTest() throws Exception {
		searchpage =homepage.ValidateSearchFuntionality(prop.getProperty("searchkeyword"));
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
	