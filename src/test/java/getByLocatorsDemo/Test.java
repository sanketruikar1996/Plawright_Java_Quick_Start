package getByLocatorsDemo;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class Test {

	public static void main(String[] args) {
		Playwright pw=Playwright.create();
		BrowserType chromium=pw.chromium();
		LaunchOptions headless=new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser=chromium.launch(headless);
		BrowserContext context=browser.newContext();
		Page page=context.newPage();
		page.navigate("https://bookcart.azurewebsites.net/");
		
		//getByText
	    page.getByText("Login").click();
	    
	    //getBylabel
		page.getByLabel("Username").fill("ortoni");
		page.getByLabel("Password").fill("Pass1234$");
		//getByRole
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
				.setName("Login")).last().click();
		
		//getByPlaceHolder
		page.getByPlaceholder("Search books", new Page.GetByPlaceholderOptions()
				.setExact(true)).type("The Hookup");
		
		//getbyRole
		page.getByRole(AriaRole.OPTION).first().click();
		
		//getByText
		page.getByAltText("Book cover image").click();
		System.out.println(page.url());	
		
	
		
		pw.close();

	}

}
