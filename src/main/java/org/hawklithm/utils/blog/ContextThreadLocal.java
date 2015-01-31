package org.hawklithm.utils.blog;

import org.hawklithm.backyard.domain.dataobject.BlogUser;

/**
 * Created by bluehawky on 2015/1/7 0007.
 */
public class ContextThreadLocal {
    private static ThreadLocal<BlogUser> currentUser = new ThreadLocal<BlogUser>();
    public static BlogUser getCurrentUser(){
        BlogUser user =  currentUser.get();
        if (user==null){
            user = new BlogUser();
        }
        return user;
    }

    public static void putCurrentUser(BlogUser user){
        currentUser.set(user);
    }

    public static void reset(){
        currentUser.remove();
    }
}
