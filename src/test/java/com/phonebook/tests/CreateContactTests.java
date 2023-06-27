package com.phonebook.tests;

import com.phonebook.framework.DataProviders;
import com.phonebook.model.Contact;
import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
        // click on Login Link
        // driver.findElement(By.xpath("//a[.='LOGIN']")).click();
        app.getHeader().clickOnLoginLink();

        // enter email field
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("sam@gmail.com")
                .setPassword("Sam123$-$_"));

        // click on Login button
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        // click on the ADD link
        app.getHeader().clickOnAddLink();
        // int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        // fill in the add contact form
        app.getContact().fillAddContactForm(new Contact()
                .setName("Karin")
                .setLastname("Jackson")
                .setPhone("01520234561")
                .setEmail("jackson@gmail.com")
                .setAddress("Berlin")
                .setDesc("friend"));

        // click on the Save button
        app.getContact().clickOnSaveButton();

        // assert the contact is added
        Assert.assertTrue(app.getContact().isContactCreated("Karin"));
    }

    @Test (dataProviderClass = DataProviders.class, dataProvider = "addContactFromCsvFile")
    public void addContactFromCsvFilePositiveTest(Contact contact) {
        app.getHeader().clickOnAddLink();
        app.getContact().fillAddContactForm(contact);

        app.getContact().clickOnSaveButton();
    }

    @Test (dataProviderClass = DataProviders.class, dataProvider = "addNegativeContactFromCsvFile")
    public void addContactFromCsvFileNegativeTest(Contact contact) {
        app.getHeader().clickOnAddLink();
        app.getContact().fillAddContactForm(contact);

        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getUser().isAlertPresent());

    }
    @AfterMethod
    public void postCondition () {
        app.getContact().removeContact();
    }
}
