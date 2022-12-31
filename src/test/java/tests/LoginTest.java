package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import factory.Factory;
import pages.LoginPage;

public class LoginTest {

	Factory factory;
	Page page;
	LoginPage loginPage;
	
	@BeforeTest
	public void setup() {
		factory = new Factory();
		page = factory.initializeBrowser("chrome", false);
		loginPage = new LoginPage(page);
		
	}
	
	@Test
	public void loginTitleTest() {
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(actualTitle, "Deltek Maconomy");
		
	}
	
	@Test
	public void loginPageURLTest() {
		String actualURL = loginPage.getPageURL();
		if (actualURL.contains("")) { 
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(actualURL, "");
	}
	
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
}
