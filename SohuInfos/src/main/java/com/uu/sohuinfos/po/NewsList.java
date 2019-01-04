package com.uu.sohuinfos.po;

import com.uu.sohuinfos.bean.SouhuNews;
import com.uu.sohuinfos.config.PageConfig;

import java.util.ArrayList;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/** 资讯列表
 * author：zhangguiyou
 * date: 2018/12/24.
 */
public class NewsList extends BasePageObject {


    private ArrayList<SouhuNews> newsList = new ArrayList<>();

    public NewsList(AndroidDriver driver) {
        super(driver);
    }

    public ArrayList<SouhuNews> getNewsList() {
        return newsList;
    }

    public void refreshNewsList() {
        newsList.clear();
        for (Object element : this.driver.findElementsById(PageConfig.ARTICLE_TITLE_ID)) {
            SouhuNews news = new SouhuNews();
            news.setElement((MobileElement) element);
            news.setTitle(((MobileElement) element).getText());
            newsList.add(news);
        }

    }

    /**
     * 进入一篇新闻
     *
     * @param news
     */
    public void enterArticle(SouhuNews news) {
        news.getElement().click();
    }

    public void swipeDown() {
        swipeScreen(PageConfig.ARTICLE_LIST_ID, true);
    }
}
