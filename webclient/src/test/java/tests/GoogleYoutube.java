package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class GoogleYoutube {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://www.google.com/");
      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).click();
      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).fill("youtube");
      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search")).press("Enter");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("YouTube https://www.youtube.com")).click();
      page.locator("#chips").getByText("Music").first().click();
      //page.getByText("Christmas decorations").click();
      page.getByPlaceholder("Search").click();
      page.getByPlaceholder("Search").fill("playwright au");
      page.getByPlaceholder("Search").press("ArrowDown");
      page.getByPlaceholder("Search").press("Enter");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Playwright Beginner Tutorials Automation Step by Step Verified")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pause keyboard shortcut k")).click();
    }
  }
}