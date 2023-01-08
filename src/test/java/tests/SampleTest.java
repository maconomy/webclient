package tests;

import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class SampleTest {

	
	@Test (priority = 3)
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
	
	@Test (priority = 2)
	public void secondTest() {
		System.out.println("2nd testing failed!");
		Assert.assertEquals(1, 2);
	}
	
	@Test (priority = 1)
	public void thirdTest() {
		System.out.println("3rd testing failed!");
		Assert.assertEquals("alex","nat");
	}
	
	@Test (priority = 4)
	public void fourthTest() {
		System.out.println("Start testing");
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
	      BrowserContext context = browser.newContext();
	      context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));
	      Page page = browser.newPage();
	      page.navigate("http://whatsmyuseragent.org/");
	      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
	      System.out.println("page title is: " + page.title());
		  System.out.println(page.content());
		  context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("Trace.zip")));
		  page.close();
		  browser.close();
		  playwright.close();
	    

	    }
	    System.out.println("finish testing");
	    
	}
}
