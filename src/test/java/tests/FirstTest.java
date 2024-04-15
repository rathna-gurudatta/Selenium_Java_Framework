package tests;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{
    @Test
    public void test1(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);

    }

    @Test
    public void test2(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Rathna", Keys.ENTER);
    }

    @Test
    public void test3(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
    }

}
