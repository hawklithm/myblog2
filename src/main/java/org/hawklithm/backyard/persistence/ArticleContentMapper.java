package org.hawklithm.backyard.persistence;

import org.hawklithm.backyard.domain.dataobject.ArticleContentDO;

import java.util.List;
import java.util.Map;

/**
 * Created by bluehawky on 2014/12/20 0020.
 */
public interface ArticleContentMapper{
    List<ArticleContentDO> queryByArticleCode(String articleCode,long creatorId);

    int saveArticleContent(Map<String,Object> map);

    int deleteArticleContentByArticleCodeLogically(String articleCode);

    int queryArticleContentCountByArticleCode(String articleCode);

    int updateArticleContentByArticleCodeAndSortId(ArticleContentDO content);
}
