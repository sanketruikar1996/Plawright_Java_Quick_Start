package WorkWithInputs;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class InputDemo {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
					new BrowserType.LaunchOptions()
					.setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://letcode.in/edit");
		page.type("#fullName","Sanket Ruikar");
		
	/*	Append a text and press keyboard tab */
		
		Locator joinLocator=page.locator("#join");
		joinLocator.press("End");
		joinLocator.type("Man");
		joinLocator.press("Tab");
		
	/*	What is inside the text box */
		
		String attributeValue=page.locator("id=getMe").getAttribute("value");
		System.out.println(attributeValue);
		
		/* Clear the text */
		
		page.locator("#clearMe").clear();
		
	}

}
