package CodeGen;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;


	public class Test {
	  public static void main(String[] args) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      page.navigate("https://leetcode.in/");
	      page.getByRole(AriaRole.SEARCHBOX).click();
	      page.getByRole(AriaRole.SEARCHBOX).fill("selenium");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search")).click();
	      page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Nothing Found")).click();
	    }
	  }
	}


