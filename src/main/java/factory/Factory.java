package factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Factory {

	// Declaring variables outside of methods to make it available across page class
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;

	public Page initializeBrowser(String browserName, Boolean headless) {
		browserName.toLowerCase();
		System.out.println("Browser selected: " + browserName);

		playwright = Playwright.create();
		switch (browserName) {
		case "chrome":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(headless));
			break;
		case "firefox":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(headless));
			break;
		case "edge":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(headless));
			break;
		case "safari":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("webkit").setHeadless(headless));
			break;

		default:
			System.out.println("Unknown browser, select between chrome, firefox, edge or safari");
			break;
		}
		
		browserContext = browser.newContext();
		page = browserContext.newPage();
		page.navigate("https://webclient-5-1-x.webclient-docker.cphdev.deltek.com/maconomy");
		
		return page;
	}

}
