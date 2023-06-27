package com.phonebook.tests;

import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
        // click on Login Link
        // driver.findElement(By.xpath("//a[.='LOGIN']")).click();
        app.getHeader().clickOnLoginLink();
    }

    @Test (priority = 1)
    public void loginPositiveTest() {
        // enter email field
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("sam@gmail.com")
                .setPassword("Sam123$-$_"));

        // click on Login button
        app.getUser().clickOnLoginButton();

        // assert user logged in(check Sign Out button displayed)
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

    @Test (priority = 2) // запустится 2м в рамках одного класса
    public void loginNegativeWithoutPasswordTest() {
        // enter email field
        app.getUser().fillLoginRegistrationForm(new User().setEmail("sam@gmail.com"));

        // click on Login button
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
