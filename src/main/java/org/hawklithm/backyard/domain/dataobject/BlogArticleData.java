package org.hawklithm.backyard.domain.dataobject;

import java.util.Date;

/**
 * Created by bluehawky on 2015/1/7 0007.
 * 博客内容,用户传入的博客数据，跟文章有关的部分
 */
public class BlogArticleData {

    /**
     * 标题
     */
    private String title;
    /**
     * 正文
     */
    private String text;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
