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
	
	public void doLogin(String username, String password) { 
		page.fill(usernameTextbox, username);
		page.fill(passwordTextbox, password);
		page.click(loginButton);
		
	}
}
