package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    // precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
        // click on Login Link
        // driver.findElement(By.xpath("//a[.='LOGIN']")).click();
        app.getHeader().clickOnLoginLink();
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        // enter email field
        // [placeholder='Email']
        // enter password field
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("sam@gmail.com")
                .setPassword("Sam123$-$_"));

        // click on Registration // by.name - registration
        app.getUser().clickOnRegistrationButton();

        // assert user logged in(check Sign Out button displayed)
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
