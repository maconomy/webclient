package pages;

import com.microsoft.playwright.Page;

public class BasePage {

	Page page;
	
	//common actions or methods
	public boolean doElementExists(String element) {
		System.out.println("test log: Checking if " + element + " exists...");
		return page.isVisible(element);
	}
	
	public void click(String element) {
		System.out.println("test log: clicking " + element);
		page.click(element);
	}
	
	public void fill(String element) {
		System.out.println("test log: filling");
	}
}
