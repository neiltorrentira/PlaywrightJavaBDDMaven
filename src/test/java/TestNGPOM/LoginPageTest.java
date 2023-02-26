package TestNGPOM;

import org.testng.Assert;
import org.testng.annotations.Test;
import webui.playwright.Utils.Constants;
import webui.playwright.Utils.Utils;

public class LoginPageTest extends BaseTest{
    @Test(priority = 1)
    public void loginPageNavigationTest() {
        loginPage = homePage.navigateToLoginPage();
        String actLoginPageTitle = loginPage.getLoginPageTitle();
        System.out.println("page act title: " + actLoginPageTitle);
        Assert.assertEquals(actLoginPageTitle, Constants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void forgotPwdLinkExistTest() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }

    @Test(priority = 3)
    public void appLoginTest() {
        Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(),
                Utils.decode64(prop.getProperty("password").trim())));
    }

}
