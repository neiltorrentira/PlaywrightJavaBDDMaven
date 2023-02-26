package webui.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Paths;

public class PlaywrightApp {
    public static void main(String[] args) {
        System.out.println("\nPlaywright Java WebUIAutomation!\n");
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch
                (new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://google.com");
        System.out.println(page.title());
        page.type("input[name='q']", "LeBron James");
        page.click("//input[@name='btnK']");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/googleSample.png")));
        browser.close();
        playwright.close();
    }
}
