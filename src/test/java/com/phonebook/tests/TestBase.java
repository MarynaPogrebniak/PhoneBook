package com.phonebook.tests;

import com.phonebook.framework.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", Browser.CHROME.browserName()));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

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

    @BeforeMethod
    public void startTest(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + " with data: " + Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: " + result.getMethod().getMethodName());
        } else  {
            logger.error("FAILED: " + result.getMethod().getMethodName());
        }
        logger.info("Stop test");
        logger.info("==================================================");
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
