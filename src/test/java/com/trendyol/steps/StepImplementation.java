package com.trendyol.steps;

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
    }

    @Step("<key> alanına <text> yaz")
    public void textSendKeys(String key, String text) {
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


}



