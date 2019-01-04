package com.uu.sohuinfos.po;

import com.uu.sohuinfos.config.PageConfig;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * 开屏广告
 *
 * author：zhangguiyou
 * date: 2018/12/31.
 */
public class Splash extends BasePageObject {

    public Splash(AndroidDriver driver) {
        super(driver);
    }

    public void skipAd() {
        MobileElement element = (MobileElement) driver.findElementById(PageConfig.SPLASH_SKIP_ID);
        element.click();
    }
}
