package com.uu.sohuinfos;

import com.uu.sohuinfos.bean.SouhuNews;
import com.uu.sohuinfos.po.NewsDetail;
import com.uu.sohuinfos.po.NewsList;
import com.uu.sohuinfos.po.Splash;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MyClass {

    MobileDriver driver;

    @BeforeTest
    public void setup() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("appPackage", "com.sohu.infonews");
//        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("automationName", "Espresso");
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "MI 6");
        cap.setCapability("udid", "2c9699f8");
        cap.setCapability("noReset", true);
        cap.setCapability("appActivity", "com.sohu.quicknews.splashModel.activity.SplashActivity");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);

            // 跳过开屏广告
            Splash splash = new Splash(driver);
            splash.waitMoment(500);
            splash.skipAd();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void start() {
        NewsList list = new NewsList(driver);
        list.waitMoment(1000);
        list.refreshNewsList();
        for (SouhuNews news : list.getNewsList()) {
            list.enterArticle(news);

            NewsDetail detail = new NewsDetail(driver);
            detail.readNews();
        }
        list.swipeDown();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
