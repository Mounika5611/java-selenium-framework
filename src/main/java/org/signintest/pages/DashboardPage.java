package org.signintest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.signintest.base.BasePage;

public class DashboardPage extends BasePage {

    WebDriver driver;

    public DashboardPage(WebDriver driver){
        super(driver);
        this.driver =  driver;
    }

     By accountsAndLists = By.id("nav-link-accountList");


    public String loggedInUser(){
        waitForElementToAppear(accountsAndLists);
        return driver.findElement(accountsAndLists).getText();
    }
}
