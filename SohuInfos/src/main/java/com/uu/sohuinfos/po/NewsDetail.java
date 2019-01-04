package com.uu.sohuinfos.po;

import com.uu.sohuinfos.config.PageConfig;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * 新闻详情
 *
 * author：zhangguiyou
 * date: 2018/12/31.
 */
public class NewsDetail extends BasePageObject {

    public NewsDetail(AndroidDriver driver) {
        super(driver);
    }

    /**
     * 开始模拟阅读
     */
    public void readNews() {
        for (int i = 0; i < 5; i++) {
            swipeScreen(PageConfig.ARITCLE_CONTENT_ID, true);
            waitMoment(2000);
        }
    }

    public void inputComment(String content) {
        MobileElement icon = (MobileElement) driver.findElementById(PageConfig.COMMENT_ICON_ID);
        icon.click();

        MobileElement editor = (MobileElement) driver.findElementById(PageConfig.COMMENT_EDITOR_ID);
        editor.sendKeys(content);

        MobileElement send = (MobileElement) driver.findElementById(PageConfig.COMMENT_SEND_ID);
        assert send.isEnabled();
        send.click();
    }

}
