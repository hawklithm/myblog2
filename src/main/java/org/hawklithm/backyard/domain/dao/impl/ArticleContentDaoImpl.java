package org.hawklithm.backyard.domain.dao.impl;

import com.google.common.collect.Maps;
import org.hawklithm.backyard.domain.dao.ArticleContentDAO;
import org.hawklithm.backyard.domain.dataobject.ArticleContentDO;
import org.hawklithm.backyard.persistence.ArticleContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by bluehawky on 2014/12/20 0020.
 */
@Repository("articleContentDAO")
public class ArticleContentDaoImpl implements ArticleContentDAO {

    @Autowired
    private ArticleContentMapper articleContentMapper;
    @Override
    public List<ArticleContentDO> queryArticleContentDOListByArticleCode(String articleCode,long creatorId) {
        return articleContentMapper.queryByArticleCode(articleCode,creatorId);
    }

    @Override
    @Transactional
    public int saveArticleContents(List<ArticleContentDO> contents) {
        int count = 0;
        for (ArticleContentDO content : contents) {
            Map<String,Object> map = Maps.newHashMap();
            map.put("articleCode",content.getArticleCode());
            map.put("articleContent",content.getArticleContent());
            map.put("sortId",content.getSortId());
            map.put("status",content.getStatus());
            count+=articleContentMapper.saveArticleContent(map);
        }
        return count;
    }

    @Override
    @Transactional
    public int updateArticleContents(List<ArticleContentDO> contents) throws Exception {
        int count = 0;
        for (ArticleContentDO content : contents) {
            if (content.getArticleCode()!=null&&content.getSortId()!=null) {
                count+=articleContentMapper.updateArticleContentByArticleCodeAndSortId(content);
            }else{
                throw new Exception("please check the parameters");
            }
        }
        return count;
    }


    @Override
    @Transactional
    public int deleteArticleContentsByArticleCode(String code){
        return articleContentMapper.deleteArticleContentByArticleCodeLogically(code);
    }
}
