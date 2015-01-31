package org.hawklithm.backyard.domain.manager;

import org.hawklithm.backyard.domain.dataobject.BlogArticleData;
import org.hawklithm.backyard.domain.dataobject.BlogContentDetail;
import org.hawklithm.utils.common.ResultSupport;

/**
 * Created by bluehawky on 2015/1/7 0007.
 * blog read and write manager
 */
public interface BlogArticleManager {

    /**
     * 保存博客文章
     * @param data
     * @return
     */
    public boolean saveBlog(BlogArticleData data);

    /**
     * 根据文章code和作者id获取文章内容
     * @param articleCode
     * @param writerId
     * @return
     */
    public ResultSupport<BlogContentDetail> getBlog(String articleCode,Long writerId);
}
