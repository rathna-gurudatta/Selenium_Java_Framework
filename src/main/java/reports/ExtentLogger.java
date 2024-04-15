package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.observer.entity.MediaEntity;
import driver.DriverManager;
import enums.ConfigProperties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ReadPropertyFile;
import utils.ScreenshotUtils;

public final class ExtentLogger {
    private ExtentLogger(){};

    public static void pass(String message){
        try {
            if(ReadPropertyFile.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")){
                ExtentManager.getextentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
            }else{
                ExtentManager.getextentTest().pass(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fail(String message){
        try {
            if(ReadPropertyFile.getValue(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")){
                ExtentManager.getextentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
            }else{
                ExtentManager.getextentTest().fail(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void skip(String message){
        try {
            if(ReadPropertyFile.getValue(ConfigProperties.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("yes")){
                ExtentManager.getextentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
            }else{
                ExtentManager.getextentTest().skip(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
