package reports;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public final class ExtentManager {
    ExtentManager(){};

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    static ExtentTest getextentTest(){
        return extentTest.get();
    }

    static void setExtentTestRef(ExtentTest extentTestRef){
        extentTest.set(extentTestRef);
    }

    static void unload(){
        extentTest.remove();
    }
}
