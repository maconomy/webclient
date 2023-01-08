package factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitUntilState;

public class Factory {

	// Declaring variables outside of methods to make it available across page class
	public Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;

	Properties properties;
	
	//start for parallel local threading so each page will have individual reference and instantiation
	ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	static ThreadLocal<Page> tlPage = new ThreadLocal<>();
	
	public Playwright getPlaywright() {
		return tlPlaywright.get();
	}
	public Browser getBrowser() {
		return tlBrowser.get();
	}
	public BrowserContext getBrowserContext() {
		return tlBrowserContext.get();
	}
	public static Page getPage() {
		return tlPage.get();
	}
	//end for parallel
	
	public Page initializeBrowser(Properties properties) {
		String browserName = properties.getProperty("browser").trim().toLowerCase();
		boolean headless = Boolean.parseBoolean(properties.getProperty("headless")) ;
		String URL = properties.getProperty("URL");
		System.out.println("Browser selected: " + browserName);
		tlPlaywright.set(Playwright.create()); //non-thread-non parallel value: playwright = Playwright.create();
		
		switch (browserName) {
		case "chrome":
			//browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(headless));
			//tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(headless)));
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless)));
			break;
		case "firefox":
			//browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(headless));
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(headless)));
			break;
		case "edge":
			//browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(headless));
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(headless)));
			break;
		case "safari":
			//browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("webkit").setHeadless(headless));
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("webkit").setHeadless(headless)));
			break;

		default:
			System.out.println("Unknown browser, select between chrome, firefox, edge or safari");
			break;
		}
		tlBrowserContext.set(getBrowser().newContext());
		//browserContext = browser.newContext();
		//getBrowserContext().setDefaultNavigationTimeout(120000);
		
		//browserContext.setDefaultNavigationTimeout(120000);
		tlPage.set(getBrowserContext().newPage());
		//page = browserContext.newPage();
		getPage().navigate(URL, new Page.NavigateOptions()
				  .setWaitUntil(WaitUntilState.NETWORKIDLE)); //page.navigate(URL);
		
		return getPage(); //page;
	}
	
	//this method get all values under file resources/config.properties
	public Properties initializeConfigProperties() {
		try {
			FileInputStream fileInputStream = new FileInputStream("./resources/config.properties");
			properties = new Properties();
			properties.load(fileInputStream);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return properties;
	}
	
	//whenever we run from jenkins this will overwrite the existing values under config.properties file 
	public void setConfigProperties() {
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("./resources/config.properties");
			properties = new Properties();
			properties.setProperty("browser", System.getProperty("browser"));
			properties.setProperty("URL", System.getProperty("WebClientURL"));
			properties.setProperty("headless", System.getProperty("headless"));
			properties.setProperty("username", System.getProperty("username"));
			properties.setProperty("password", System.getProperty("password"));
			properties.setProperty("testType", System.getProperty("testType"));
			properties.store(fileOutputStream, "Updated config properties file ");
			
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
			System.out.println("error message: " + exception.getMessage()); 
			System.out.println("error cause: " + exception.getCause());
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
