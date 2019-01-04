package com.uu.sohuinfos.bean;

import io.appium.java_client.MobileElement;

/**
 * 新闻对象
 *
 * author：zhangguiyou
 * date: 2018/12/31.
 */
public class SouhuNews {

    private String title;

    private MobileElement element;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MobileElement getElement() {
        return element;
    }

    public void setElement(MobileElement element) {
        this.element = element;
    }
}
