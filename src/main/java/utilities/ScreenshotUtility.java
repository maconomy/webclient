package utilities;

import java.nio.file.Paths;

import com.microsoft.playwright.Page;

import factory.Factory;

public class ScreenshotUtility extends Factory{
	public String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/screenshot" + System.currentTimeMillis() + ".png";
		
		getPage().screenshot(new Page.ScreenshotOptions()
				.setPath(Paths.get(path))
				.setFullPage(true));
		return path;
	}
}
