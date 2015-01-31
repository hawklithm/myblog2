package org.hawklithm.backyard.domain.dao;

import org.hawklithm.backyard.domain.dataobject.ArticleContentDO;

import java.util.List;

/**
 * Created by bluehawky on 2014/12/20 0020.
 */
public interface ArticleContentDAO {

    /**
     * 根据articleCode查询文章详情
     * @param articleCode
     * @return
     */
    public List<ArticleContentDO> queryArticleContentDOListByArticleCode(String articleCode,long creatorId);

    /**
     * 保存文章详情
     * @param contents
     * @return
     */
    public int saveArticleContents(List<ArticleContentDO> contents);

    /**
     * 更新文章详情
     * @param contents
     * @return
     */
    public int updateArticleContents(List<ArticleContentDO> contents) throws Exception;

    /**
     * 删除文章详情
     * @param contents
     * @return
     */
    public int deleteArticleContentsByArticleCode(String code);

}
