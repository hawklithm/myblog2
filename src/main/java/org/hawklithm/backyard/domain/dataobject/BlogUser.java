package org.hawklithm.backyard.domain.dataobject;

import java.io.Serializable;

/**
 * Created by bluehawky on 2015/1/7 0007.
 */
public class BlogUser implements Serializable{
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
