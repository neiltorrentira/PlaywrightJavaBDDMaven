package webui.playwright.Utils;

import com.microsoft.playwright.Page;
import webui.playwright.Factory.PlaywrightFactory;

public class Helpers extends PlaywrightFactory {
    public static void clickElement(String element){
        getPage().click(element);
    }

    public static void enterText(String element, String text){
        getPage().fill(element, text);
    }

    public static void getPageTitle(){
        System.out.println("Page Title : " + getPage().title());
    }

    public static void validateByText(String text){
        getPage().getByText(text);
        getPage().getByText(text, new Page.GetByTextOptions().setExact(true));
        System.out.println("Text found : " + text);
    }

}
