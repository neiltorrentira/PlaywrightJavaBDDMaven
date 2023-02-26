package WebUI.StepDefinitions;

import WebUI.Runners.PlaywrightCucumber;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks extends PlaywrightCucumber {
    private final static Logger logger = LoggerFactory.getLogger(Hooks.class);

    @After()
    public void stopTest(Scenario scenario) {
        logger.info("Test Scenario : " + scenario.getName() + " has : "
                + (scenario.isFailed() ? "failed" : "passed"));
        getPage().close();
        getBrowserContext().close();
        //getBrowser().close();
        getPlaywright().close();
    }
}
