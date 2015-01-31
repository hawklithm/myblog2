package org.hawklithm.backyard.domain.dao.impl;

import com.google.common.collect.Maps;
import org.hawklithm.backyard.domain.dao.ArticleInfoDAO;
import org.hawklithm.backyard.domain.dataobject.ArticleInfoDO;
import org.hawklithm.backyard.persistence.ArticleInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bluehawky on 2014/12/16 0016.
 */
@Repository("articleInfoDAO")
public class ArticleInfoDAOImpl implements ArticleInfoDAO {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;


    @Override
    public int saveArticleInfo(ArticleInfoDO info) {
        return articleInfoMapper.insertArticleInfo(info);
    }

    @Override
    public ArticleInfoDO getArticleInfoByArticleCode(String articleCode,long creatorId) {
        Map<String,String> mapper = Maps.newHashMap();
        mapper.put("articleCode",articleCode);
        mapper.put("creatorId",String.valueOf(creatorId));
        List<ArticleInfoDO> infos = articleInfoMapper.queryArticleInfoByCode(mapper);
        return infos.get(0);
    }

    @Override
    public List<ArticleInfoDO> getArticleInfoByCreatorIdAndPage(long creatorId, int page,int pageSize) {
        Map<String,String> params = new HashMap<String,String>();
        params.put("creatorId",String.valueOf(creatorId));
        params.put("offset",String.valueOf(page));
        params.put("length",String.valueOf(pageSize));
        return articleInfoMapper.queryArticleInfoByCreatorIdAndOffset(params);
    }

}
