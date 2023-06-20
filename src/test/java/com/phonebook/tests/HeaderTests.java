package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignOutButton();
        }
     }

    @Test
    public void LogoTest() {
        Assert.assertTrue(app.isLogoPresent());
    }

    @Test
    public void HomeButtonTest() {
        Assert.assertTrue(app.isHomeLinkPresent());
    }

    @Test
    public void AboutButtonTest() {
        Assert.assertTrue(app.isAboutLinkPresent());
    }

    @Test
    public void LoginButtonTest() {
       Assert.assertTrue(app.isLoginLinkPresent());
    }

    @AfterMethod
    public void tearDown (){

    }
}
