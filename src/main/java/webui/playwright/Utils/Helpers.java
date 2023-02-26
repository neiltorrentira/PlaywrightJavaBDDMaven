package webui.playwright.Utils;

import webui.playwright.Factory.PlaywrightFactory;

public class Helpers extends PlaywrightFactory {
    public void clickElement(String element){
        getPage().click(element);
    }

    public void enterText(String element, String text){
        getPage().fill(element, text);
    }

    public void getPageTitle(){
        System.out.println("Page Title : " + getPage().title());
    }
}
