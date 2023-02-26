package WebUI.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import webui.playwright.Factory.PlaywrightFactory;
import webui.playwright.Utils.Helpers;

public class GoogleStepdefs extends PlaywrightFactory {
    Helpers helpers = new Helpers();

    @Given("users inputs {string} search text")
    public void usersInputsSearchText(String searchString){
        helpers.getPageTitle();
        helpers.enterText("input[name='q']", searchString);
        helpers.clickElement("//input[@name='btnK']");

        /*System.out.println(page.title());
        page.locator("input[name='q']").highlight();
        page.type("input[name='q']", searchString);
        page.locator("//input[@name='btnK']").highlight();
        page.click("//input[@name='btnK']");*/

        //driver.findElement(By.name("q")).sendKeys(searchString);
        //helpers.clickElement(By.xpath("//input[@name='btnK']"));
        //driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("users validates {string} search text is present")
    public void usersValidatesSearchTextIsPresent(String arg0) {
        /*page.getByText(arg0);
        System.out.println(arg0);
        page.getByText(arg0, new Page.GetByTextOptions().setExact(true));
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/googleSample.png")));*/
    }

    @And("users clicks Images, News, Videos, and Shopping links")
    public void usersClicksImagesNewsVideosAndShoppingLinks() {
        /*page.close();
        browser.close();
        playwright.close();*/
    }


}
