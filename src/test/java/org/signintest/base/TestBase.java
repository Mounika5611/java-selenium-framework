package org.signintest.base;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.signintest.utils.DriverManager;
import org.signintest.utils.Log;
import org.signintest.utils.PropertyReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;

public class TestBase extends DriverManager {
    //Setup and Teardown
    public WebDriver driver;

    PropertyReader reader = new PropertyReader();

    public TestBase() {
        this.driver = super.getDriver();

    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        //Read properties from properties file and set the Driver
        try {
            if (PropertyReader.readItem("browser").equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } else {
                try {
                    throw new Exception("Browser Driver is not supported");
                } catch (Exception e) {
                    Log.error("No compatible browser found", e);
                }
            }

        } catch (Exception e) {
            Log.error("Browser Launch error", e);
        }

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    public void takeScreenshot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}
