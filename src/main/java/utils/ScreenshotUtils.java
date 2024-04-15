package utils;

import driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class ScreenshotUtils {
    ScreenshotUtils(){
        RemoteWebDriver

    }

    public static String getBase64Image(){
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
