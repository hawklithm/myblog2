package org.hawklithm.backyard.web.controller;

import org.hawklithm.backyard.domain.dataobject.BlogContentDetail;
import org.hawklithm.backyard.domain.manager.BlogArticleManager;
import org.hawklithm.utils.common.ResultSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bluehawky on 2015/1/20 0020.
 */
@RestController
public class BlogArticleReadService {
    @Autowired
    @Qualifier("articleManager")
    private BlogArticleManager articleManager;


    @RequestMapping("/query/article/info")
    public BlogContentDetail queryArticleInfo(@RequestParam(value="writerId", defaultValue="0") long writerId,
                                      @RequestParam(value="articleCode",defaultValue = "null") String articleCode
    ) {
        ResultSupport<BlogContentDetail> result = articleManager.getBlog(articleCode, writerId);
        if (result.isSuccess()){
            return result.getModel();
        }
        return null;
    }
}
