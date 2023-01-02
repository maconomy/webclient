package maconomy.webclient;

import org.testng.annotations.*;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import org.testng.Assert;

public class BaseTest {
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test...");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class...");
	}

	
	@Test
	public void firstTest() {

			

		System.out.println("first testing passed!");
		Playwright playwright = Playwright.create();
		LaunchOptions launchOptions = new LaunchOptions();
		launchOptions.setChannel("webkit").setHeadless(false);
		
		Browser browser = playwright.webkit().launch(launchOptions);
		Page page = browser.newPage();
		//page.navigate("https://webclient-5-1-x.webclient-docker.cphdev.deltek.com/");
		page.navigate("http://10.4.8.157:22594");
		
		
		String title = page.title();
		System.out.println("title of page is: " + title);
		
		String url = page.url();
		System.out.println("url of page is: " + url);
		
		browser.close();
		playwright.close();

		
	}
	
	@Test
	public void secondTest() {
		System.out.println("2nd testing failed!");
		Assert.assertEquals(1, 2);
	}
	
	@Test
	public void thirdTest() {
		System.out.println("3rd testing failed!");
		Assert.assertEquals("alex","nat");
	}	
}
