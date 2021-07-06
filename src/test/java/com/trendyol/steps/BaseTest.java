package com.trendyol.steps;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
<<<<<<< HEAD

import com.trendyol.selector.Selector;
=======
>>>>>>> 95bc9e54f1a05732e446dbe91a99c6bbeee0da9d
import com.trendyol.selector.SelectorFactory;
import com.trendyol.selector.SelectorType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
<<<<<<< HEAD
=======
import org.apache.commons.lang.StringUtils;
>>>>>>> 95bc9e54f1a05732e446dbe91a99c6bbeee0da9d
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;

import java.net.MalformedURLException;
import java.net.URL;
<<<<<<< HEAD
import java.time.Duration;


public class BaseTest {
    public static AppiumDriver<MobileElement> appiumDriver;
    protected static FluentWait<AppiumDriver<MobileElement>> appiumFluentWait;
    protected static Selector selector ;



    @BeforeScenario
    public void beforeScenario() throws MalformedURLException {

        System.out.println("Test!!!!");
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities
                        .setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
=======
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
>>>>>>> 95bc9e54f1a05732e446dbe91a99c6bbeee0da9d
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
                desiredCapabilities
                        .setCapability(AndroidMobileCapabilityType.APP_PACKAGE,
                                "trendyol.com");
                desiredCapabilities
                        .setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
                                "com.trendyol.ui.splash.SplashActivity");
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
<<<<<<< HEAD
                desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                appiumDriver = new AndroidDriver(url, desiredCapabilities);

        selector = SelectorFactory
                .createElementHelper(SelectorType.ANDROID);
        //appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
=======
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
>>>>>>> 95bc9e54f1a05732e446dbe91a99c6bbeee0da9d
        appiumFluentWait = new FluentWait<AppiumDriver<MobileElement>>(appiumDriver);
        appiumFluentWait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(450))
                .ignoring(NoSuchElementException.class);
<<<<<<< HEAD

=======
>>>>>>> 95bc9e54f1a05732e446dbe91a99c6bbeee0da9d
    }

    @AfterScenario
    public void afterScenario() {
        if (appiumDriver != null)
            appiumDriver.quit();
    }
}