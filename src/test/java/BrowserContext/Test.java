package BrowserContext;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test {

	public static void main(String[] args) {
		Playwright pw=Playwright.create();
		BrowserType chromium=pw.chromium();
		LaunchOptions headless=new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser=chromium.launch(headless);
		BrowserContext context=browser.newContext();
		Page page=context.newPage();
		page.navigate("https://bookcart.azurewebsites.net/");
		//click on login
		page.click("//span[text()='Login']/..");
		//enter login details
		page.locator("input[formcontrolname='username']").type("ortoni");
		page.locator("input[formcontrolname='password']").type("Pass1234$");
		//click on login
		page.locator("button[color='primary']").click();
		
		//if we create waant to open new tab with existing user as logged in user then we should use 
		
		Page page2=context.newPage();
		page2.navigate("https://bookcart.azurewebsites.net/");
		//This means it will use stored seesion/coockie/cache info 
		
		
		//But what if we want to open second browser as new user the 
		
		BrowserContext context2=browser.newContext();
		Page page3=context2.newPage();
		page3.navigate("https://bookcart.azurewebsites.net/");

	}

}
