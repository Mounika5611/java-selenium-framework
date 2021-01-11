package org.signintest.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.signintest.utils.WaitForHelper;

public class BasePage {

    // Navigate
    //wait for element
    //Wait for Item
    //click
    //Read and Write text
    //Move to an element

    protected WebDriver driver;
     public BasePage(WebDriver driver){
         this.driver = driver;
     }

     public void goToUrl(String url){
         driver.get(url);
     }

     public void waitForElementToAppear(By elementLocation){
         new WaitForHelper(driver).presenceOfElement(elementLocation);
     }

     public void waitForLoad(){
         new WaitForHelper(driver).implicitWait();
     }

     public void click(By elementLocation){
         driver.findElement(elementLocation).click();
     }

     public void writeText(By elementLocation, String text){
         driver.findElement(elementLocation).clear();
         driver.findElement(elementLocation).sendKeys(text);
     }

     public void readText(By elementLocation){
         driver.findElement(elementLocation).getText();
     }

     public void moveToElement(By elementLocation){
         new Actions(driver).moveToElement(driver.findElement(elementLocation)).build().perform();
     }

}
