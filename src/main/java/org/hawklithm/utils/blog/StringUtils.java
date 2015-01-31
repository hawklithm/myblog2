package org.hawklithm.utils.blog;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by bluehawky on 2015/1/7 0007.
 */
public class StringUtils {
    /**
     * 将字符串分解成多个指定长度的串
     * @param orig
     * @param perLen
     * @return
     */
    public static List<String> splitString(String orig,int perLen){
        List<String> result =Lists.newArrayList();
        int count = 0;
        StringBuilder builder = new StringBuilder(perLen);
        for (char c : orig.toCharArray()){
            builder.append(c);
            count++;
            if (count>=perLen){
                result.add(builder.toString());
                builder = new StringBuilder(perLen);
            }
        }
        return result;
    }
}
