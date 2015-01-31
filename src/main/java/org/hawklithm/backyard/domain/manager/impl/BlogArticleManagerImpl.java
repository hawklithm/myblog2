package org.hawklithm.backyard.domain.manager.impl;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.hawklithm.backyard.constants.BlogContants;
import org.hawklithm.backyard.domain.dao.ArticleContentDAO;
import org.hawklithm.backyard.domain.dao.ArticleInfoDAO;
import org.hawklithm.backyard.domain.dataobject.*;
import org.hawklithm.backyard.domain.manager.BlogArticleManager;
import org.hawklithm.utils.blog.ContextThreadLocal;
import org.hawklithm.utils.blog.StringUtils;
import org.hawklithm.utils.common.ResultSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bluehawky on 2015/1/7 0007.
 */
@Service("articleManager")
public class BlogArticleManagerImpl implements BlogArticleManager{

    @Autowired
    @Qualifier("articleInfoDAO")
    private ArticleInfoDAO articleInfoDAO;

    @Autowired
    @Qualifier("articleContentDAO")
    private ArticleContentDAO articleContentDAO;

    @Override
    public boolean saveBlog(BlogArticleData data) {
        String text = data.getText();
        ArticleInfoDO info = new ArticleInfoDO();
        info.setArticleSize(text.toCharArray().length);
        info.setArticleTitle(data.getTitle());
        List<String> texts = StringUtils.splitString(text, BlogContants.BlogDetail.ARTICLE_LENGTH_PER_CONTENTS);
        List<ArticleContentDO> contents = Lists.newArrayList();
        long sortNum = 0;
        for (String body : texts){
            ArticleContentDO content = new ArticleContentDO();
            content.setArticleContent(body);
            content.setSortId(sortNum++);
            contents.add(content);
        }
        fillBlogArticleContentWithMd5(info, contents);
        fillBlogArticleContentWithCode(info,contents);
        articleInfoDAO.saveArticleInfo(info);
        articleContentDAO.saveArticleContents(contents);
        return true;
    }

    /**
     * 填充info和contents的articleCode
     * @param info
     * @param contents
     */
    private void fillBlogArticleContentWithCode(ArticleInfoDO info, List<ArticleContentDO> contents) {
        long codeNum=info.hashCode();
        for (ArticleContentDO article:contents) {
            codeNum^=article.hashCode();
        }
        String articleCode = String.valueOf(codeNum);
        info.setArticleCode(articleCode);
        for (ArticleContentDO article:contents) {
            article.setArticleCode(articleCode);
        }
    }

    @Override
    public ResultSupport<BlogContentDetail> getBlog(String articleCode, Long writerId) {
        try {
            BlogContentDetail detail = new BlogContentDetail();
            ArticleInfoDO info = articleInfoDAO.getArticleInfoByArticleCode(articleCode, writerId);
            List<ArticleContentDO> contents = articleContentDAO.queryArticleContentDOListByArticleCode(articleCode, writerId);
            detail.setArticleInfo(info);
            detail.setContents(contents);
            return ResultSupport.newSuccessResult(detail);
        }catch (Exception e){
            return ResultSupport.newErrorResult("get blog error. "+e.getMessage(),null);
        }
    }

    /**
     * 填充info的md5
     * @param info
     * @param content
     */
    private void fillBlogArticleContentWithMd5(ArticleInfoDO info ,List<ArticleContentDO> content){
        BlogUser currentUser = ContextThreadLocal.getCurrentUser();
        Hasher hasher = Hashing.md5().newHasher();
        hasher.putLong(currentUser.getUserId()).putString(info.getArticleTitle(), Charsets.UTF_8);
        for (ArticleContentDO article:content) {
            hasher.putString(article.getArticleContent(),Charsets.UTF_8);
        }
        info.setMd5Tag(hasher.hash().toString());
    }

}
