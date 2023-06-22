package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }

        app.getHeader().clickOnLoginLink();

        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("sam@gmail.com")
                .setPassword("Sam123$-$_"));

        app.getUser().clickOnLoginButton();

        app.getHeader().clickOnAddLink();

        app.getContact().fillAddContactForm(new Contact()
                .setName("Karin")
                .setLastname("Jackson")
                .setPhone("01520234561")
                .setEmail("jackson@gmail.com")
                .setAddress("Berlin")
                .setDesc("friend"));

        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreated("Karin"));
        app.getContact().removeContact();
    }

    @Test
    public void removeContactPositiveTest() {
        app.getContact().removeContact();
        Assert.assertTrue(app.getContact().isContactRemoved(" Contacts here!"));
    }
}
