package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{


	
	@Test
	public void loginTitleTest() {
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(actualTitle, "Deltek Maconomy");
		
	}
	
	@Test
	public void loginPageURLTest() {
		String actualURL = loginPage.getPageURL();
		if (actualURL.contains("/maconomy")) { 
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(actualURL, "");
	}
	
	@DataProvider
	public Object[][] getCredentials() {
		return new Object [][] {
			
			{"Administrator","123456"},
			{"Jack Johnson","123456"},
			{"Andy Hansson","123456"}
			
			
			
		};
		
	}
	
	@Test(dataProvider = "getCredentials")
	public void doLogin(String username, String password) {
		loginPage.doLogin(username, password);
		System.out.println("Tested using username: " + username);
		
	}
	

}
