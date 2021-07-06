package com.trendyol.steps;

<<<<<<< HEAD
import com.thoughtworks.gauge.Step;
import com.trendyol.methods.Methods;
import org.junit.Assert;


public class StepImplementation extends BaseTest {
    private Methods methods;

    public StepImplementation(){
        methods = new Methods();
    }

    @Step("<key> butonuna tıkla")
    public void Click(String key) {

        methods.click(key);
=======
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.trendyol.model.SelectorInfo;
import com.trendyol.selector.Selector;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StepImplementation extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(getClass());

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
            Assert.fail(key + " sayfada görüntülenemedi!!!");
            throw ex;
        }
        return element;
    }


    public void click(String key){
        WebElement element=findElementByKey(key);
        element.click();

    }

    public void sendKey(String key, String value)
    {
        WebElement element=findElementByKey(key);
        element.sendKeys(value);
    }

    public static void wait (int sure){

        try {
            Thread.sleep(sure*1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    @Step("<key> butonuna tıkla")
    public void Click(String key) {
        click(key);
>>>>>>> 95bc9e54f1a05732e446dbe91a99c6bbeee0da9d
    }

    @Step("<key> alanına <text> yaz")
    public void textSendKeys(String key, String text) {
<<<<<<< HEAD
        methods.sendKey(key, text);


    }

    @Step("<key> saniye bekle")
    public void wait(int key) throws InterruptedException {
        appiumDriver.wait(key);
    }


    @Step("<key> alanı yoksa <text> yazdır")
    public void getButtonControl(String key, String text) {
        Assert.assertTrue(text, methods.findElementByKey(key).isDisplayed());
    }


=======
        sendKey(key,text);


    }
    @Step("<key> saniye bekle")
    public void bekle(int key) throws InterruptedException {
        Thread.sleep(key*1000);
    }


    @Step("Sayfada <key> alanı yoksa <mesaj> yazdır")
    public void getButtonControl(String key, String msg)
    {

        Assert.assertTrue(msg,findElementByKey(key).isDisplayed());
    }



>>>>>>> 95bc9e54f1a05732e446dbe91a99c6bbeee0da9d
}



