package WebUI.Runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import webui.playwright.Factory.PlaywrightFactory;
import java.net.MalformedURLException;

@CucumberOptions(
        monochrome = true,
        dryRun = false,
        features = "src/test/java/WebUI/FeatureFiles/",
        glue = "WebUI.StepDefinitions",
        plugin = {
                "pretty",
                //"summary",
                //"html:target/cucumber-htmlreport-Regressions.html",
                //"json:target/cucumber-report-Regressions.json",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class CucumberPlaywright extends PlaywrightFactory {
    private final static Logger logger = LoggerFactory.getLogger(CucumberPlaywright.class);
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        logger.info("Setting Up Cucumber");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser", "website"})
    public void setDriver(String browser, String website) throws MalformedURLException {
        logger.info("SetDriver : "+ browser +" browser | Website : " + website
                + " | With Cucumber Runner : " + this.getClass().getName());

        this.browserName = browser;
        this.websiteName = website;
        logger.info("Browser used : " + this.browserName);
        logger.info("Website : " + this.websiteName);
        //startBrowser(this.browserName);
    }

    @Test(groups = "cucumber", description = "Tests Runs Cucumber Feature", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleEvent, FeatureWrapper cucumberFeature) throws MalformedURLException, InterruptedException {
        logger.info("Executing feature " + cucumberFeature.toString());
        logger.info("Refreshing driver for each scenario");
        playwright = startBrowser(this.browserName);
        logger.info("Browser used : " + this.browserName );
        logger.info("Website : " + this.websiteName);
        this.setDriver(this.browserName, this.websiteName);
        logger.info("Executing scenario : " + pickleEvent.toString());
        this.setWebsites(this.websiteName);
        logger.info("Website to open : " + this.websiteName);
        opensHomePage(this.websiteName);
        testNGCucumberRunner.runScenario(pickleEvent.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        logger.info("Providing scenarios | Number of scenarios to run : "
                + testNGCucumberRunner.provideScenarios().length);
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        logger.info("Closing Down Cucumber ");
        testNGCucumberRunner.finish();
    }

}
