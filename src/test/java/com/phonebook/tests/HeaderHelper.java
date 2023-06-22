package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends BaseHelper {
    public HeaderHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoPresent() {
        return isElementPresent(By.xpath("//h1[contains(text(),'PHONEBOOK')]"));
    }

    public boolean isHomeLinkPresent() {
        return isElementPresent(By.xpath("//a[.='HOME']"));
    }

    public boolean isAboutLinkPresent() {
        return isElementPresent(By.xpath("//a[.='ABOUT']"));
    }

    public void clickOnLoginLink() {
        click(By.xpath("//a[.='LOGIN']"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[.='Sign Out']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[.='LOGIN']"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }
}
