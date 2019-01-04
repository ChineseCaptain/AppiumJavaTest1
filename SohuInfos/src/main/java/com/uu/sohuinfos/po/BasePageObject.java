package com.uu.sohuinfos.po;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonObject;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * author：zhangguiyou
 * date: 2018/12/31.
 */
public class BasePageObject {

    AndroidDriver driver;

    public BasePageObject(AndroidDriver driver) {
        this.driver = driver;
    }



//    public void swipeScreen() {
//        driver.executeScript("mobile:swipe", ImmutableMap.of("direction", "up"));
//
////        driver.executeScript("mobile: shell", ImmutableMap.of("direction", "up"));
////        int width = driver.manage().window().getSize().width;//获取当前屏幕的宽度
////        int height = driver.manage().window().getSize().height;//获取当前屏幕的高
////        driver.executeScript("mobile: shell", String.format("input swipe %d %d %d %d %d", width/2,height*3/4, width/2,height/4, 1000));
//    }

    public void swipeScreen(String id, boolean down) {
        JsonObject object = new JsonObject();
        object.addProperty("elementId", id);
        object.addProperty("direction", down?"down":"up");
        driver.executeScript("mobile:swipe", object);
    }

    public void waitMoment(int time) {

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
