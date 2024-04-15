
package tests;

import listeners.RetryFailedTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.DataProviderUtils;

import java.util.Map;

public final class SwagLabsLoginTestMethodInterceptor extends BaseTest{
    private SwagLabsLoginTestMethodInterceptor(){}

     @Test(dataProvider = "LoginTestData", dataProviderClass = DataProviderUtils.class, retryAnalyzer = RetryFailedTest.class)
    public void loginTest(Map<String, String> map){
        LoginPage lp = new LoginPage();
        DashboardPage dp = new DashboardPage();

        lp.enterUserName(map.get("username"))
                .enterPassword(map.get("password"))
                .clickLoginButton()
                .clickMenuButton()
                .clickLogoutButton();
    }


   // @Test
    public void invalidLoginCredentialsTest(){
        LoginPage lp = new LoginPage();
        lp.enterUserName("admin")
                .enterPassword("admin")
                .clickLoginButton();
        Assert.assertEquals(lp.invalidCredentialsError(), "test error message");
        //Assert.assertEquals(lp.invalidCredentialsError(), "Epic sadface: Username and password do not match any user in this service");
    }


}
