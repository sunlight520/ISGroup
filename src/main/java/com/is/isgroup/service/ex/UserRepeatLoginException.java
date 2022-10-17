package com.is.isgroup.service.ex;

public class UserRepeatLoginException extends ServiceException{
    public UserRepeatLoginException() {
    }

    public UserRepeatLoginException(String message) {
        super(message);
    }

    public UserRepeatLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserRepeatLoginException(Throwable cause) {
        super(cause);
    }

    public UserRepeatLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
