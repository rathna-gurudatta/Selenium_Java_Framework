package constants;

import enums.ConfigProperties;
import org.testng.internal.PropertyUtils;
import utils.ReadPropertyFile;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class FrameworkConstants {
    /*
        1. Always constants should be declared as final
        2. Access modifiers of the constants should be private
        3. Getter to access the constants
        4. Create a private constructor

     */
    private FrameworkConstants(){ }

    private static final String CHROMEDRIVERPATH = System.getProperty("user.dir") + "/src/test/java/resources/executables/chromedriver";
    private static final String CONFIGFILEPATH = System.getProperty("user.dir") + "/src/test/java/resources/config/config.properties";
    private static final int WAITTIMEINSECONDS = 10;
    private static final String EXCELFILEPATH = System.getProperty("user.dir") + "/src/test/java/resources/excel/TestData.xlsx";
    private static final String EXCELRUNMANAGER = System.getProperty("user.dir") + "/src/test/java/resources/excel/TestRunManager2.xlsx";

    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static  String extentReportFilePath = "";

    private static final String SELENIUMGRIDURL = "http://localhost:4444/wd/hub";


    public static String getChromeDriverPath(){
        return CHROMEDRIVERPATH;
    }

    public static String getConfigFilepath(){
        return CONFIGFILEPATH;
    }

    public static int getWaitTimeInSeconds(){
        return WAITTIMEINSECONDS;
    }

    public static String getTestDataExcel(){
        return EXCELFILEPATH;
    }
    public static String getExcelRunManager(){
        return EXCELRUNMANAGER;
    }

    public static String getExtentReportFilePath(){
        if(extentReportFilePath.isEmpty()){
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath(){
        if(ReadPropertyFile.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")){
            return EXTENTREPORTFOLDERPATH + "index.html";
        }else{
            SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyy_HH:mm:ss");
            Date date = new Date();
            return EXTENTREPORTFOLDERPATH + formatter.format(date) + "_index.html";
        }
    }

    public static String getSeleniumGridUrl(){
        return SELENIUMGRIDURL;
    }
}
