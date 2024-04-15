package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentLogger;
import reports.ExtentManager;
import reports.ExtentReport;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class DashboardPage extends BasePage{

    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutButton = By.linkText("Logout");

    public DashboardPage clickMenuButton(){
        click(menuButton, "Menu button", WaitStrategy.CLICKABLE);
        return this;
    }

    public void clickLogoutButton(){
        click(logoutButton, "Logout button", WaitStrategy.CLICKABLE);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(new LoginPage().loginButton));
        //return new LoginPage();
    }
}
