package RecordVideo;


import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Test {

	public static void main(String[] args) {
		Playwright pw=Playwright.create();
		BrowserType chromium=pw.chromium();
		LaunchOptions headless=new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser=chromium.launch(headless);
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
		Page page=context.newPage();
		page.navigate("https://bookcart.azurewebsites.net/");
		//click on login
		page.click("//span[text()='Login']/..");
		//enter login details
		page.locator("input[formcontrolname='username']").type("ortoni");
		page.locator("input[formcontrolname='password']").type("Pass1234$");
		//click on login
		page.locator("button[color='primary']").click();
		page.close();
	}

}
