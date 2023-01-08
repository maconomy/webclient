package tests;

import static org.testng.Assert.expectThrows;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {

	@Test
	public void logoutTest(Method method) {
		mainPage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		
		//Assert.assertTrue(mainPage.isSidebarButtonExists());
		logoutPage = mainPage.doLogout();
		
		Assert.assertTrue(logoutPage.isClickHereToLoginAgainExists());
		System.out.println("test log: " + "Logged out successfully");
		
		System.out.println("test log: " + method.getName() + " Passed");
	}
}
