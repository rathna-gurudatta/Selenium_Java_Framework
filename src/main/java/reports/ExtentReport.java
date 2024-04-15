package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.FrameworkConstants;
import enums.CategoryTypes;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReport {

    private ExtentReport(){};

    private static ExtentReports reports;

    public static void initReports(){
        if(Objects.isNull(reports)){
            reports = new ExtentReports();
            ExtentSparkReporter spark = null;
            try {
                spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
            reports.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Selenium Automation Report");
            spark.config().setReportName("Automation Test Report");
        }
    }

    public static void flushReport(){
        if(Objects.nonNull(reports)){
            reports.flush();
            try {
                Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ExtentManager.unload();
        }
    }

    //Every time a new test runs createTest() is called, creates a node in reports
    public static void createTest(String testCaseName){
        ExtentTest test = reports.createTest(testCaseName);
        ExtentManager.setExtentTestRef(test);
    }


    public static void addCategories(CategoryTypes[] categories){
        for(CategoryTypes category:categories){
            ExtentManager.getextentTest().assignCategory(category.toString());
        }
    }
}
