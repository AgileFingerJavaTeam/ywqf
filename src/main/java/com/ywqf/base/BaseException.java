package com.ywqf.base;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
public class BaseException extends RuntimeException{

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

}
