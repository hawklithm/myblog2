package org.hawklithm.backyard.persistence;

import org.hawklithm.backyard.domain.dataobject.ArticleInfoDO;

import java.util.List;
import java.util.Map;

/**
 * Created by bluehawky on 2014/12/16 0016.
 */
public interface ArticleInfoMapper {
    /**
     * 根据创建者进行分页查询
     * Long creatorId,int offset,int length
     * @return
     */
    public List<ArticleInfoDO> queryArticleInfoByCreatorIdAndOffset(Map<String,String> map);

    /**
     * 用来进行分页的全局查询
     * int offset,int length
     * @return
     */
    public List<ArticleInfoDO> queryArticleInfoByOffset(Map<String,String> map);

    public List<ArticleInfoDO> queryArticleInfoByCode(Map<String,String> map);

    public int countArticleInfoByCreatorId(Integer creatorId);

    public int insertArticleInfo(ArticleInfoDO info);

    public int updateArticleInfo(ArticleInfoDO info);
}
