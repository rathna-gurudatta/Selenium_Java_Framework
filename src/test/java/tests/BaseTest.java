package tests;

import constants.FrameworkConstants;
import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import reports.ExtentReport;

import java.io.IOException;


public class BaseTest {
    protected BaseTest(){ }

    @BeforeMethod
    public void startUp(){
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }


}
