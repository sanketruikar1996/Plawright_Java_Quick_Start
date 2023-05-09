package LaunchBrowsers;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchChromeUI {

	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		////To see the browser UI, pass the headless=false flag while launching the browser.
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		Page page = browser.newPage();
		page.navigate("http://playwright.dev");
		System.out.println("Page Title : "+page.title());
		System.out.println("Page URL : "+page.url());
		browser.close();
		page.close();

	}

}
