package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import reports.ExtentReport;

public final class SwagLabsLoginTest extends BaseTest{
    private SwagLabsLoginTest(){}

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
    public Object[][] getLoginCredentials(){
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"visual_user","secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}

        };
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
