package webui.playwright.Factory;

import com.microsoft.playwright.*;
import java.awt.*;
import java.util.Objects;

import webui.playwright.Utils.Constants;

import static webui.playwright.Utils.Constants.GOOGLE_URL;


public class PlaywrightFactory {
    Dimension screenSize;
    public String browserName;
    public String websiteName;
    public static String url;

    public static ThreadLocal<Browser> browser = new ThreadLocal<>();
    public static ThreadLocal<BrowserContext> browserContext = new ThreadLocal<>();
    public static ThreadLocal<Page> page = new ThreadLocal<>();
    public static ThreadLocal<Playwright> playwright = new ThreadLocal<>();

    public static Playwright getPlaywright() {
        return Objects.requireNonNull(playwright.get());
    }

    public static Browser getBrowser() {
        return browser.get();
    }

    public static BrowserContext getBrowserContext() {
        return browserContext.get();
    }

    public static Page getPage() {
        return page.get();
    }

    public void setWebsites(String website){
        url = website;
    }

    public ThreadLocal<Playwright> startBrowser(String browserName){
        System.out.println("Browser is : " + browserName);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        playwright.set(Playwright.create());

        switch (browserName.toLowerCase()){
            case "chromium":
                browser.set(getPlaywright().chromium()
                        .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)));
                break;
            case "chrome":
                browser.set(getPlaywright().chromium()
                        .launch(new BrowserType.LaunchOptions()
                        .setChannel("chrome").setHeadless(false)));
                break;
            case "msedge":
            case "edge":
                browser.set(getPlaywright().chromium()
                        .launch(new BrowserType.LaunchOptions()
                        .setChannel("msedge").setHeadless(false)));
                break;
            case "firefox":
                browser.set(getPlaywright().firefox()
                        .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)));
                break;
            case "safari":
                browser.set(getPlaywright().webkit()
                        .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)));
                break;
            default:
                throw new IllegalStateException("Incorrect browser value: " + browserName);
        }
        browserContext.set(getBrowser().newContext(new Browser.NewContextOptions()
                .setViewportSize((int)width, (int)height)));
        page.set(getBrowserContext().newPage());
        //getPage().navigate("http://google.com");

        return playwright;
    }

    public void opensHomePage(String website)throws IllegalStateException{
        switch (website) {
            case GOOGLE_URL:
                getPage().navigate(GOOGLE_URL);
                break;
            case Constants.FACEBOOK_URL:
                getPage().navigate(Constants.FACEBOOK_URL);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + website);
        }
        System.out.println("Opening Website : " + website);
    }


}
