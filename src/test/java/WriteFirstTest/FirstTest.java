package WriteFirstTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstTest {

	public static void main(String[] args) {
		//Create Plawright instance
		Playwright pw=Playwright.create();
		//Create Browser instance
		Browser browser=pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		//Create Page instance
		Page page=browser.newPage();
		page.navigate("https://www.saucedemo.com/");
		
		
	    Locator userNameloc=page.locator("//*[@id=\"user-name\"]");
	    userNameloc.fill("standard_user");
	    
	    Locator passwordloc=page.locator("//*[@id=\"password\"]");
	    passwordloc.fill("secret_sauce");
	    
	    Locator loginButtonloc3=page.locator("//*[@id=\"login-button\"]");
	    loginButtonloc3.click();
	    
	    
	    



	}

}
