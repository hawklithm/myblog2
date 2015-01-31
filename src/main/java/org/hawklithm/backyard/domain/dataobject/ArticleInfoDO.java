package org.hawklithm.backyard.domain.dataobject;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by bluehawky on 2014/12/16 0016.
 */
public class ArticleInfoDO implements Serializable{
    /**
     * 文章信息id
     */
    private Long id;

    /**
     * 文章唯一标识码
     */
    private String articleCode;
    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章创建者id
     */
    private Long creatorId;
    /**
     * 文章状态
     */
    private Integer status;
    /**
     * 文章创建时间
     */
    private Date gmtCreated;
    /**
     * 修改时间
     */
    private Date gmtModified;
    /**
     * 文章正文长度
     */
    private Integer articleSize;

    /**
     * md5标识码
     */
    private String md5Tag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getArticleSize() {
        return articleSize;
    }

    public void setArticleSize(Integer articleSize) {
        this.articleSize = articleSize;
    }

    public String getMd5Tag() {
        return md5Tag;
    }

    public void setMd5Tag(String md5Tag) {
        this.md5Tag = md5Tag;
    }
}
