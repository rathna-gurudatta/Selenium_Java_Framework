package driver;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import exceptions.BrowserInvocationFailedException;
import factories.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.ReadPropertyFile;

import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver {

    private Driver(){ };
    private static WebDriver driver;

    public static void initDriver(){
        if(Objects.isNull(DriverManager.getDriver())) {
//            if(ReadPropertyFile.getValue(ConfigProperties.BROWSER).equalsIgnoreCase("chrome")){
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//            }else if(ReadPropertyFile.getValue(ConfigProperties.BROWSER).equalsIgnoreCase("firefox")){
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//            }else if(ReadPropertyFile.getValue(ConfigProperties.BROWSER).equalsIgnoreCase("safari")){
//                WebDriverManager.safaridriver().setup();
//                driver = new SafariDriver();
//            }

//            try {
//                DriverManager.setDriver(DriverFactory.getDriver());
//            } catch (MalformedURLException e) {
//                throw new BrowserInvocationFailedException("Please check the browser capabilities",e);
//            }


            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
            WebDriver driver = new ChromeDriver();
            DriverManager.setDriver(driver);

            DriverManager.getDriver().get(ReadPropertyFile.getValue(ConfigProperties.URL));
        }
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().close();
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
