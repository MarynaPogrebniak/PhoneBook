package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
     }

    @Test
    public void LogoTest() {
        Assert.assertTrue(app.getHeader().isLogoPresent());
    }

    @Test
    public void HomeButtonTest() {
        Assert.assertTrue(app.getHeader().isHomeLinkPresent());
    }

    @Test
    public void AboutButtonTest() {
        Assert.assertTrue(app.getHeader().isAboutLinkPresent());
    }

    @Test
    public void LoginButtonTest() {
       Assert.assertTrue(app.getHeader().isLoginLinkPresent());
    }

    @AfterMethod
    public void tearDown (){
    }
}
