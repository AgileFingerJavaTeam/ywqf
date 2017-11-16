package com.ywqf.exception.db;

import com.ywqf.base.BaseException;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class DeleteInnerErrorException extends BaseException {
    public DeleteInnerErrorException(String message) {
        super(message);
    }

    public DeleteInnerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
