package org.signintest.tests;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.signintest.base.TestBase;
import org.signintest.pages.DashboardPage;
import org.signintest.pages.LoginPage;
import org.signintest.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends TestBase {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Login")
    @Test
    public void loginToAmazon(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToAmazon();
        takeScreenshot("Login to Amazon");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Logged in")
    @Test
    public void verifyLoggedInUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginToAmazon();
        DashboardPage dashboardPage = loginPage.afterLogin();
        Assert.assertEquals(dashboardPage.loggedInUser(), "Hello, " + PropertyReader.readItem("displayName") +"\n" +
                "Account & Lists");
        takeScreenshot("Verify Login");
    }
}
