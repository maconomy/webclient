package pages;

import com.microsoft.playwright.Page;


public class LoginPage {

	private Page page;
	//String Locators
	
	String usernameLabel = "//label[@for='username']";
	String usernameTextbox = "//input[@id='username']";
	String passwordLabel = "//label[@for='password']";
	String passwordTextbox = "//input[@id='password']";
	String loginButton = "//button[@id='login']";
	String languageDropdown = "//dm-language-selector//button";
	String sidebarButton = "//a[@title='Menu']";
	// page constructor
	public LoginPage (Page page) { 
		this.page = page;
	}
	
	//Actions
	
	public String getPageTitle() {
		return page.title();
	
	}
	
	public String getPageURL() {
		return page.url();
	}
	
	public MainPage doLogin(String username, String password) { 
		page.fill(usernameTextbox, username);
		page.fill(passwordTextbox, password);
		page.click(loginButton);
		page.waitForSelector(sidebarButton);
		
		
		return new MainPage(page);
	}

	
}
