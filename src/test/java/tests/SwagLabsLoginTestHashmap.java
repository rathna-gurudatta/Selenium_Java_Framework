
package tests;

import constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import reports.ExtentReport;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class SwagLabsLoginTestHashmap extends BaseTest{
    private SwagLabsLoginTestHashmap(){}

    @Test(dataProvider = "LoginTestData")
    public void loginTest(Map<String, String> map){
        ExtentReport.createTest("loginTest");
        LoginPage lp = new LoginPage();
        DashboardPage dp = new DashboardPage();

        lp.enterUserName(map.get("username"))
                .enterPassword(map.get("password"))
                .clickLoginButton()
                .clickMenuButton()
                .clickLogoutButton();
    }

    @DataProvider(name = "LoginTestData", parallel=true)
    public Object[] getData() throws IOException {
        FileInputStream fis = new FileInputStream(FrameworkConstants.getTestDataExcel());
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int rowNum = sheet.getLastRowNum();
        int colNum = sheet.getRow(0).getLastCellNum();

        Object[] data = new Object[rowNum];
        Map<String, String> map;
        for(int i=1; i<=rowNum; i++){
            map = new HashMap<>();
            for(int j=0; j<colNum; j++){
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);
                //System.out.println("map: " + map);
                data[i-1] = map;
            }
        }

        return data;
    }

    //@Test
    public void invalidLoginCredentialsTest(){
        LoginPage lp = new LoginPage();
        lp.enterUserName("admin")
                .enterPassword("admin")
                .clickLoginButton();
        Assert.assertEquals(lp.invalidCredentialsError(), "Epic sadface: Username and password do not match any user in this service");
    }
}
