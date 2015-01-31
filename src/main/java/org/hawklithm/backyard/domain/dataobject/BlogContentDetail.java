package org.hawklithm.backyard.domain.dataobject;


import java.util.List;

/**
 * Created by bluehawky on 2015/1/7 0007.
 * 博客文章详情
 */
public class BlogContentDetail {

    /**
     * 文章信息
     */
    private ArticleInfoDO articleInfo;

    /**
     * 文章内容
     */
    private List<ArticleContentDO> contents;

    public ArticleInfoDO getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(ArticleInfoDO articleInfo) {
        this.articleInfo = articleInfo;
    }

    public List<ArticleContentDO> getContents() {
        return contents;
    }

    public void setContents(List<ArticleContentDO> contents) {
        this.contents = contents;
    }
}
