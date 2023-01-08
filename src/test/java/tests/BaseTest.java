package tests;

import java.util.Properties;

import org.testng.annotations.*;

import factory.Factory;
import pages.LoginPage;
import pages.LogoutPage;
import pages.MainPage;
import com.microsoft.playwright.Page;

public class BaseTest{
	
	Factory factory;
	Page page;
	LoginPage loginPage;
	MainPage mainPage;
	LogoutPage logoutPage;
	Properties properties;
	
	@BeforeTest
	public void setup() {
		factory = new Factory(); //creating a new object of the class Factory.java so we can use all variables and methods under it
		//This if condition, is to verify if the test is running via jenkins, if yes then WebClientURL will not be null, and will overwrite values under config.properties 
		if (System.getProperty("WebClientURL") != null) {
			factory.setConfigProperties();
		}
		properties = factory.initializeConfigProperties(); // this initializes or get all the key-value from the config.properties file
		page = factory.initializeBrowser(properties);  //as we created the new object factory, we are able to call initializeBrowser method
		
		loginPage = new LoginPage(page); //creating object of class loginPage so we can use all variables and methods under it
		
	}

	
	@AfterTest
	public void tearDown() {
		//page.context().close();
		page.context().browser().close();
		//factory.playwright.close();
	}
	
}
