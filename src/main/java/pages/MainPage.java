package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.IsVisibleOptions;
import com.microsoft.playwright.impl.AssertionsTimeout;

import dev.failsafe.Timeout;

public class MainPage {

	
	Page page;
	//objects - string locators
	String sidebarButton = "//a[@title='Menu']";
	String sidebarWorkspaceList = "//dm-tree//dm-menu-item";
	String settingsButton = "//a[@title='Settings']";
	String logoutButton = "//a[@dm-data-id='dm-logout-link']";
	
	
	
	MainPage (Page page) {
		this.page = page;
	}
	
	//action-methods
	public void doClickEachWorkspace() {
		
	}
	
	public boolean isSidebarButtonExists() {
		return page.isVisible(sidebarButton);
		
	}
	

	public LogoutPage doLogout() {
		
		page.click(settingsButton);
		page.click(logoutButton);

		return new LogoutPage(page);
	}
	
}
