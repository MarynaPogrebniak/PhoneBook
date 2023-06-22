package com.phonebook.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.*;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", Browser.CHROME.browserName()));

    //@BeforeMethod
    @BeforeSuite
    public void setUp() {
        app.init();
    }


   // @AfterMethod(enabled = false)
    @AfterSuite(enabled = false)
    public void tearDown () {
        app.stop();
    }

}

// @BeforeTest - запуск перед 1м методом с аннотацией Test
    // @BeforeMethod отрабатываем перед каждым методом с аннотацией Тест
        // @BeforeClass запуск перед 1м методом в текущем классе
            // @BeforeSuite отработает 1 раз. все остальные методы будут запускаться в одном браузере
                // @BeforeGroups может объединить тесты в группы, если поставим атрибут groups
                //@AfterGroups
            //@AfterSuite
        //@AfterClass
    //@AfterMethod
//@AfterTest
