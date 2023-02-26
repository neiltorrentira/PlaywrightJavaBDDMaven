package webui.playwright.Utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final String GOOGLE_URL = "https://www.google.com/";
    public static final String FACEBOOK_URL = "https://www.facebook.com/";
    public static final String PROP_FILE_NAME = "framework.properties";
    public static final String FILE_NOT_FOUND_EXCEPTION_MESSAGE = "The Property file has not been found";

    public static List<String> firstnameListOfStrings = Arrays.asList("Emily", "Michael", "Jessica", "Matthew", "Ashley",
            "Jacob", "Sarah", "Christopher", "Samantha","Joshua", "Taylor", "Nicholas", "Hannah", "Tyler", "Alexis",
            "Brandon", "Rachel", "Austin", "Elizabeth", "Andrew");
    public static List<String> lastnameListOfStrings = Arrays.asList("Smith", "Johnson", "Williams", "Jones", "Brown",
            "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris",
            "Martin", "Thompson",  "Garcia", "Martinez", "Robinson" );

    public static final String HOME_PAGE_TITLE = "Your Store";
    public static final String LOGIN_PAGE_TITLE = "Account Login";
}