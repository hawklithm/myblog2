package org.hawklithm.utils.common;

import com.google.common.base.Optional;

import java.io.Serializable;

/**
 * Created by bluehawky on 2015/1/7 0007.
 */
public class ResultSupport<T> implements Serializable{
    private Optional<T> result;

    private String errorCode;
    private String msg;
    private boolean success =false;

    /**
     * 生成成功的结果
     * @param object
     * @param <T>
     * @return
     */
    public static <T> ResultSupport<T> newSuccessResult(T object){
        Optional<T> r = Optional.of(object);
        ResultSupport<T> result = new ResultSupport<T>();
        result.result = r;
        result.setSuccess(true);
        return result;
    }
    public T getModel(){
        return result.orNull();
    }
    public String getErrorCode(){
        return errorCode;
    }
    public String getMessage(){
        return msg;
    }
    public static <T> ResultSupport<T> newErrorResult(String message,String code){
        Optional<T> r = Optional.absent();
        ResultSupport<T> result = new ResultSupport<T>();
        result.result = r;
        result.errorCode = code;
        result.msg = message;
        return result;
    }
    public boolean isSuccess(){
        return success;
    }
    public void setSuccess(boolean bool){
        success = bool;
    }
}
