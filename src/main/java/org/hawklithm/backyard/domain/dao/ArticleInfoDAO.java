package org.hawklithm.backyard.domain.dao;

import org.hawklithm.backyard.domain.dataobject.ArticleInfoDO;

import java.util.List;

/**
 * Created by bluehawky on 2014/12/16 0016.
 */
public interface ArticleInfoDAO {
    /**
     * 分页获取指定创建者的文章信息
     * @param creatorId
     * @param page
     * @return
     */
    public List<ArticleInfoDO> getArticleInfoByCreatorIdAndPage(long creatorId,int page,int pageSize);


    /**
     * 保存文章信息
     * @param info
     * @return
     */
    public int saveArticleInfo(ArticleInfoDO info);

    /**
     * 查询指定code的文章信息
     * @param articleCode
     * @return
     */
    public ArticleInfoDO getArticleInfoByArticleCode(String articleCode,long creatorId);
}
