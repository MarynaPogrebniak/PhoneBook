package com.phonebook.tests;

import com.phonebook.model.Contact;
import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

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
     }

    @Test
    public void removeContactTest() {

        int sizeBefore = app.getContact().sizeOfContacts();

        app.getContact().removeContact();

        app.getContact().pause(1000);

        int sizeAfter = app.getContact().sizeOfContacts();

        Assert.assertEquals(sizeAfter, sizeBefore - 1);
//        Assert.assertTrue(app.getContact().isContactRemoved(" Contacts here!"));
    }
}
