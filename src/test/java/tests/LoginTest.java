package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.impl.AssertionsTimeout;

import constants.AppContants;
import factory.Factory;
import utilities.ExcelUtility;


public class LoginTest extends BaseTest{


	@Test
	public void loginTitleTest() {
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(actualTitle, AppContants.URLTitle);
		System.out.println("test log: " + LoginTest.class.getName() + " Passed");
	}
	
	@Test
	public void loginPageURLTest() {
		String actualURL = loginPage.getPageURL();
		if (actualURL.contains("/maconomy")) { 
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		Assert.assertEquals(actualURL, properties.getProperty("URL"));
		System.out.println("test log: " + LoginTest.class.getName() + " Passed");
		//Assert.assertEquals(actualURL, "");
	}
	
	@DataProvider(name="loginTestData")
	public Object[][] loginTestData() throws IOException {
		return new Object[][] {
			
			{"Administrator","123456", "valid"},
			//{"Jack Johnson","123456", "valid"},
//			{"Andy Hansson","123456", "valid"},
			{"Administato","123456", "invalid"}
//			{"Andy Hansson","122324", "invalid"}
		};
		
//		String path = System.getProperty("user.dir") + "/resources/dataProviders/loginTestData.xlsx";
//		ExcelUtility excelUtility = new ExcelUtility(path);
//		int totalRow = excelUtility.getRowCount("Sheet1");
//		int totalColumn = excelUtility.getCellCount("Sheet1", totalRow);
//		String loginTestData[][] = new String[totalRow][totalColumn];
//		
//		for (int x=1; x<=totalRow; x++) {
//			for (int y=1; y<=totalColumn; y++) {
//				loginTestData[x-1][y] = excelUtility.getCellData("Sheet1", x, y);
//			}
//		}
//		return loginTestData;
	}
	
	@Test(dataProvider = "loginTestData")
	public void loginTest(String username, String password, String result) throws InterruptedException {
		mainPage = loginPage.doLogin(username, password);
		System.out.println("Tested using username: " + username);

		if (result.equals("valid")) {
			Assert.assertTrue(mainPage.isSidebarButtonExists());
			logoutPage = mainPage.doLogout();
		} else if (result.equals("invalid")) {
			Assert.assertFalse(mainPage.isSidebarButtonExists());
			
			
		}

		System.out.println("test log: " + LoginTest.class.getName() + " with param: " + username + " Passed");
	}
	

}
