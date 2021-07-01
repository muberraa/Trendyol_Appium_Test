package com.trendyol.steps;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.trendyol.selector.SelectorFactory;
import com.trendyol.selector.SelectorType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Selector;

import java.time.Duration;



public class BaseTest {
    protected static AppiumDriver<MobileElement> appiumDriver;
    protected static FluentWait<AppiumDriver<MobileElement>> appiumFluentWait;
    protected boolean localAndroid = true;
    protected static Selector selector;

    @BeforeScenario
    public void beforeScenario() throws MalformedURLException {
        System.out.println("Test!!!!");
        if (StringUtils.isEmpty(System.getenv("key"))) {
            if (localAndroid) {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities
                        .setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                // desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
                desiredCapabilities
                        .setCapability(AndroidMobileCapabilityType.APP_PACKAGE,
                                "trendyol.com");
                desiredCapabilities
                        .setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
                                "com.trendyol.ui.splash.SplashActivity");
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
                //desiredCapabilities
                //      .setCapability(MobileCapabilityType.NO_RESET, true);
                // desiredCapabilities
                //       .setCapability(MobileCapabilityType.FULL_RESET, false);
                desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                appiumDriver = new AndroidDriver(url, desiredCapabilities);
            }
        }
        selector = (Selector) SelectorFactory
                .createElementHelper(SelectorType.ANDROID);
        appiumFluentWait = new FluentWait<AppiumDriver<MobileElement>>(appiumDriver);
        appiumFluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(450))
                .ignoring(NoSuchElementException.class);
    }

    @AfterScenario
    public void afterScenario() {
        if (appiumDriver != null)
            appiumDriver.quit();
    }
}