package tests;

import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class BaseTest {

	public static void main(String[] args) {
		System.out.println("Start testing");
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
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
