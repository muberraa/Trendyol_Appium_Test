package com.trendyol.methods;

import com.trendyol.model.SelectorInfo;
import com.trendyol.selector.Selector;

import com.trendyol.steps.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Methods {
    public static AppiumDriver<MobileElement> appiumDriver;
    protected static FluentWait<AppiumDriver<MobileElement>> appiumFluentWait;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public Methods() {
        this.appiumDriver = BaseTest.appiumDriver;
        appiumFluentWait = new FluentWait<AppiumDriver<MobileElement>>(this.appiumDriver);
    }

    public MobileElement findElementByKey(String key) {

        Selector selector = null;
        assert selector != null;
        SelectorInfo selectorInfo = selector.getSelectorInfo(key);
        By by = selectorInfo.getBy();
        MobileElement element;
        try {
            logger.info("findElement method called:  finding " + key);
            element = (MobileElement) appiumFluentWait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception ex) {
            Assert.fail(key + "Element is not found");
            throw ex;
        }
        return element;
    }

    public void click(String key) {

        findElementByKey(key).click();
    }


    public void sendKey(String key, String value) {
        findElementByKey(key).sendKeys(value);
    }


    }


