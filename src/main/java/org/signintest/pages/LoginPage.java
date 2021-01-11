package org.signintest.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.signintest.base.BasePage;
import org.signintest.utils.PropertyReader;

public class LoginPage extends BasePage{

    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //Page Locators
    By signInNavigateButton = By.id("nav-link-accountList");
    By userName = By.id("ap_email");
    By continueButton = By.id("continue");
    By password = By.id("ap_password");
    By signInButton = By.id("signInSubmit");

    //Page Actions
    public void openLoginPage(){
        goToUrl(PropertyReader.readItem("url"));
    }

    public void loginToAmazon(){
        click(signInNavigateButton);
        writeText(userName, PropertyReader.readItem("userName"));
        click(continueButton);
        writeText(password, PropertyReader.readItem("password"));
        click(signInButton);

    }

    public DashboardPage afterLogin(){
        return new DashboardPage(driver);
    }
}
