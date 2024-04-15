package pages;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentLogger;

import java.time.Duration;

public class BasePage {

    protected void sendKeys(By by, String elementName, String value, WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).sendKeys(value);
        ExtentLogger.pass("Value " + value + " is entered in the " + elementName);
    }

    protected void click(By by, String elementName, WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).click();
        ExtentLogger.pass(elementName + " is clicked");
    }

    protected String getText(By by, WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        return DriverManager.getDriver().findElement(by).getText();
    }

    protected String getAttributeValue(By by, String attribute, WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        return DriverManager.getDriver().findElement(by).getAttribute(attribute);
    }


}
