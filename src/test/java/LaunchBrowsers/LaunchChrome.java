package LaunchBrowsers;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchChrome {

	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome"));
		Page page = browser.newPage();
		page.navigate("http://playwright.dev");
		System.out.println("Page Title : "+page.title());
		System.out.println("Page URL : "+page.url());
		browser.close();
		page.close();
	}

}
