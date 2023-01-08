package pages;

import com.microsoft.playwright.Page;

public class LogoutPage {

	Page page;
	//locators
	String clickHereToLoginAgainButton = "//div[@dm-data-id='dm-logout-text']//a";
	
	String successfulLoggedOutText = "//div[@dm-data-id='dm-logout-text']"; //You have successfully logged out. Click here to log in again.
	
	//constructor
	LogoutPage (Page page) {
		this.page = page;
	}
	
	//actions-methods
	public boolean isClickHereToLoginAgainExists() {
		
		return page.isVisible(clickHereToLoginAgainButton);
	}
}
