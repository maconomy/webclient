package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class webclient1 {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://webclient-5-1-x.webclient-docker.cphdev.deltek.com/maconomy");
      page.getByPlaceholder("Enter User Name").fill("Administrator");
      page.getByPlaceholder("Enter User Name").press("Tab");
      page.getByPlaceholder("Enter Password").fill("123456");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
      page.navigate("https://webclient-5-1-x.webclient-docker.cphdev.deltek.com/workspace");
      page.navigate("https://webclient-5-1-x.webclient-docker.cphdev.deltek.com/workspace/weeklytimesheets");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Expenses")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" New Expense Sheet")).click();
      page.getByLabel("Description").click();
      page.getByLabel("Description").fill("this playwright automation");
      page.getByLabel("Description").press("Tab");
      //page.locator("dm-auto-complete").filter(new Locator.LocatorOptions().setHasText("No search results were found.More search results")).locator("dm-filter-toggle dm-spinner").click();
      //page.locator("dm-filter-result").filter(new Locator.LocatorOptions().setHasText("Web Client Testing Job 1 (100000001) Danmøbler A/S (86228622)")).locator("div").nth(3).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add Expense Sheet Line")).click();
      //page.locator("td:nth-child(6) > .ng-tns-c796-4 > dm-edit-cell > dm-edit-cell-field-element > dm-input-block-wrapper > dm-input-block > div > dm-auto-complete > .dropdown > .input-group > .dropdown-toggle > dm-filter-toggle > dm-spinner").click();
      //page.locator("dm-filter-result").filter(new Locator.LocatorOptions().setHasText("Taxi (Taxi)")).locator("div").nth(2).click();
      page.locator("#expensesheetstable_unitpricecurrency_field_0_e1").click();
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("1.00")).fill("500");
      page.locator("#expensesheetstable_unitpricecurrency_field_0_e1").click();
      page.locator("td:nth-child(10) > .ng-tns-c796-4 > dm-edit-cell > dm-edit-cell-field-element > dm-input-block-wrapper > dm-input-block > div > dm-auto-complete > .dropdown > .input-group > .form-control").click();
      page.locator("#expensesheetstable_unitpricecurrency_field_0_e1").click();
      page.locator("#expensesheetstable_unitpricecurrency_field_0_e1").fill("9000.00");
      page.locator("dm-toast").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Close")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Other Actions ")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Delete Expense Sheet")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Delete")).click();
      page.locator("span").filter(new Locator.LocatorOptions().setHasText("Jim JarrettAdministratorMy SettingsChange PasswordAbout Deltek MaconomyLog Out")).click();
      page.getByText("Log Out").click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Click here to log in again.")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" English (United States) ")).click();
      page.locator("div").filter(new Locator.LocatorOptions().setHasText("MaconomyRevision: 5.1.1-606270User NamePassword Login")).nth(1).click();
    }
  }
}