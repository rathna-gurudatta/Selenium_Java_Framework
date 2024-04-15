
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.Map;

public final class SwagLabsLoginTestRetry extends BaseTest{
    private SwagLabsLoginTestRetry(){}

    /* @Test(dataProvider = "LoginTestData", dataProviderClass = DataProviderUtils.class, retryAnalyzer = RetryFailedTest.class) */
    @Test
    public void loginTest(Map<String, String> map){
        LoginPage lp = new LoginPage();
        DashboardPage dp = new DashboardPage();

        lp.enterUserName(map.get("username"))
                .enterPassword(map.get("password"))
                //.enterPassword("test")
                .clickLoginButton()
                .clickMenuButton()
                .clickLogoutButton();
    }


    //@Test
    public void invalidLoginCredentialsTest(){
        LoginPage lp = new LoginPage();
        lp.enterUserName("admin")
                .enterPassword("admin")
                .clickLoginButton();
        Assert.assertEquals(lp.invalidCredentialsError(), "test error message");
        //Assert.assertEquals(lp.invalidCredentialsError(), "Epic sadface: Username and password do not match any user in this service");
    }


}
