package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (!isElementPresent(By.xpath("//a[.='LOGIN']"))) {
            click(By.xpath("//button[.='Sign Out']"));
        }
     }

    @Test
    public void LogoTest() {
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'PHONEBOOK')]")));
    }

    @Test
    public void HomeButtonTest() {
        Assert.assertTrue(isElementPresent(By.xpath("//a[.='HOME']")));
    }

    @Test
    public void AboutButtonTest() {
        Assert.assertTrue(isElementPresent(By.xpath("//a[.='ABOUT']")));
    }

    @Test
    public void LoginButtonTest() {
       Assert.assertTrue(isElementPresent(By.xpath("//a[contains(text(), 'LOGIN')]")));
    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }
}
