package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignOutButton();
        }
        // click on Login Link
        // driver.findElement(By.xpath("//a[.='LOGIN']")).click();
        app.clickOnLoginLink();

        // enter email field
        app.fillLoginRegistrationForm(new User()
                .setEmail("sam@gmail.com")
                .setPassword("Sam123$-$_"));

        // click on Login button
        app.clickOnLoginButton();

    }

    @Test
    public void addContactPositiveTest() {
        // click on the ADD link
        app.clickOnAddLink();
        // int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        // fill in the add contact form
        app.fillAddContactForm("Karin", "Jackson", "01520234561", "jackson@gmail.com", "Berlin", "friend");

        // click on the Save button
        app.clickOnSaveButton();

        // assert the contact is added
        Assert.assertTrue(app.isContactCreated("Karin"));
    }

    @AfterMethod
    public void removeUser () {
        app.removeContact();
    }
}
