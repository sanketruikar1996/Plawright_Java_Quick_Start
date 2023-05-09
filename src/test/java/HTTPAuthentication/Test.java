package HTTPAuthentication;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class Test {

	public static void main(String[] args) {
		Playwright pw=Playwright.create();
		
		Browser browser=pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		BrowserContext context =browser.newContext(new Browser.NewContextOptions().setHttpCredentials("admin","admin"));
		
		Page  page=context.newPage();
		page.navigate("https://the-internet.herokuapp.com/basic_auth");
		System.out.println(page.locator("h3").textContent());
		
		

	}

}
