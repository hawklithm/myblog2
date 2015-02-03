package org.hawklithm.backyard.test;

import com.google.common.collect.Lists;
import hello.ScheduledTasks;
import org.hawklithm.backyard.config.Application;
import org.hawklithm.backyard.config.DataConfig;
import org.hawklithm.backyard.domain.dao.ArticleContentDAO;
import org.hawklithm.backyard.domain.dataobject.ArticleContentDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by bluehawky on 2014/12/21 0021.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataConfig.class,Application.class, ScheduledTasks.class})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class JUnitTest {
    @Autowired
    private ArticleContentDAO articleContentDAO;
    @Test
    public void savePersonTest(){
        ArticleContentDO content  = new ArticleContentDO();
        content.setArticleCode("heheheheheh");
        content.setArticleId(1251351L);
        content.setArticleContent("test test test");
        content.setSortId(1L);
        content.setStatus(0);
        articleContentDAO.saveArticleContents(Lists.newArrayList(content));
    }

    @Test
    public void getDataTest(){
        List<ArticleContentDO> ans = articleContentDAO.queryArticleContentDOListByArticleCode("heheheheheh",1251351L);
        assert CollectionUtils.isEmpty(ans);
    }

    @Test
    public void updateDataTest(){
//        articleContentDAO.updateArticleContents();
    }
}
