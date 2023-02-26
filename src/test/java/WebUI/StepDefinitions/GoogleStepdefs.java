package WebUI.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import webui.playwright.Factory.PlaywrightFactory;
import static webui.playwright.Utils.Helpers.*;

public class GoogleStepdefs extends PlaywrightFactory {
    //Helpers helpers = new Helpers();

    @Given("users inputs {string} search text")
    public void usersInputsSearchText(String searchString){
        getPageTitle();
        enterText("input[name='q']", searchString);
        clickElement("//input[@name='btnK']");
    }

    @Then("users validates {string} search text is present")
    public void usersValidatesSearchTextIsPresent(String text) {
        validateByText(text);
    }

    @And("users clicks Images, News, Videos, and Shopping links")
    public void usersClicksImagesNewsVideosAndShoppingLinks() {
    }


}
