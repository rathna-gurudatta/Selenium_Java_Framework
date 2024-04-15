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

public final class SwagLabsLoginTestExcel extends BaseTest{
    private SwagLabsLoginTestExcel(){}

    @Test(dataProvider = "LoginTestData")
    public void loginTest(String username, String password){
        LoginPage lp = new LoginPage();
        DashboardPage dp = new DashboardPage();

        lp.enterUserName(username)
                .enterPassword(password)
                .clickLoginButton()
                .clickMenuButton()
                .clickLogoutButton();
    }

    @DataProvider(name = "LoginTestData", parallel=true)
    public Object[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream(FrameworkConstants.getTestDataExcel());
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int rowNum = sheet.getLastRowNum();
        int colNum = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowNum][colNum];
        for(int i=1; i<=rowNum; i++){
            for(int j=0; j<colNum; j++){
                data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
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
