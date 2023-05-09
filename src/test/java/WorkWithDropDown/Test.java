package WorkWithDropDown;

import java.util.List;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class Test {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(headless).newPage();
		page.navigate("https://letcode.in/dropdowns");
		
		//Select the Banana using visible text//
		Locator loc=page.locator("#fruits");
		loc.selectOption("3");
		 
		//Print SubTitle
		String textContent = page.locator("p.subtitle").textContent();
		System.out.println(textContent);
		
		//Select your super hero's//
		Locator Heroloc=page.locator("#superheros");
		Heroloc.selectOption(new String [] {"am","aq","ta"});
		
	    //Select the last programming language and print all the options//
		Locator langDD = page.locator("#lang");
		Locator options = langDD.locator("option");
		List<String> allInnerTexts = options.allInnerTexts();
		allInnerTexts.forEach(i-> System.out.println(i));
		
		int count = options.count();
		System.out.println("len: "+count);
		langDD.selectOption(new SelectOption().setIndex(count-1));
		
		playwright.close();

	}

}
