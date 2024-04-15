package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentLogger;
import reports.ExtentManager;
import reports.ExtentReport;

import java.time.Duration;

public final class LoginPage extends BasePage{

    private final By userNameEditField = By.id("user-name");
    private final By passwordEditField = By.id("password");
    public final By loginButton = By.id("login-button");
    private final By loginErrorMessage = By.cssSelector("h3[data-test='error']");


    public LoginPage enterUserName(String username){
        sendKeys(userNameEditField, "user name edit box", username, WaitStrategy.PRESENCE);
        return this;
    }

    public LoginPage enterPassword(String password){
        sendKeys(passwordEditField, "password edit box", password, WaitStrategy.PRESENCE);
        return this;
    }

    public DashboardPage clickLoginButton(){
        click(loginButton, "Login button", WaitStrategy.CLICKABLE);
        return new DashboardPage();
    }

    public String invalidCredentialsError(){
        return getText(loginErrorMessage, WaitStrategy.PRESENCE);
    }


}
