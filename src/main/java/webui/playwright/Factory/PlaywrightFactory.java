package webui.playwright.Factory;

import com.microsoft.playwright.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Objects;
import java.util.Properties;

import static webui.playwright.Utils.Constants.*;

public class PlaywrightFactory {
    Dimension screenSize;
    public String browserName;
    public String websiteName;
    public static String url;
    Properties prop;

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

        return playwright;
    }

    public void opensHomePage(String website)throws IllegalStateException{
        switch (website.trim()) {
            case GOOGLE_URL:
                getPage().navigate(GOOGLE_URL);
                break;
            case FACEBOOK_URL:
                getPage().navigate(FACEBOOK_URL);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + website);
        }
        System.out.println("Opening Website : " + website);
    }

    public Page initBrowser(Properties prop) {

        String browserName = prop.getProperty("browser").trim();
        System.out.println("browser name is : " + browserName);

        // playwright = Playwright.create();
        playwright.set(Playwright.create());

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser.set(getPlaywright().chromium().launch
                        (new BrowserType.LaunchOptions()
                        .setHeadless(false)));
                break;
            case "firefox":
                browser.set(getPlaywright().firefox().launch
                        (new BrowserType.LaunchOptions()
                        .setHeadless(false)));
                break;
            case "safari":
                browser.set(getPlaywright().webkit().launch
                        (new BrowserType.LaunchOptions()
                        .setHeadless(false)));
                break;
            case "chrome":
                browser.set(getPlaywright().chromium().launch
                        (new BrowserType.LaunchOptions().setChannel("chrome")
                        .setHeadless(false)));
                break;
            case "edge":
                browser.set(getPlaywright().chromium().launch
                        (new BrowserType.LaunchOptions().setChannel("msedge")
                        .setHeadless(false)));
                break;

            default:
                System.out.println("Please pass the right browser name......");
                break;
        }
        browserContext.set(getBrowser().newContext());
        page.set(getBrowserContext().newPage());
        getPage().navigate(prop.getProperty("url").trim());
        return getPage();
    }

    /**
     * This method is used to initialize the properties from config file
     */
    public Properties init_prop() {
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config.properties");
            prop = new Properties();
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**
     * take screenshot
     */
    public static String takeScreenshot() {
        String path = System.getProperty("user.dir") + "/screenshot/"
                + System.currentTimeMillis() + ".png";
        //getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));

        byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(path)).setFullPage(true));
        String base64Path = Base64.getEncoder().encodeToString(buffer);

        return base64Path;
    }

}
