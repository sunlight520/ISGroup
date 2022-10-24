package com.is.isgroup.controller;

import com.is.isgroup.service.ex.*;
import com.is.isgroup.util.JsonResult;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

public class BaseController {
    public static final int OK = 200;
    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<Void>(e);
        if (e instanceof UsernameDuplicateException) {
            result.setState(4000);
        } else if (e instanceof UserNotFoundException) {
            result.setState(4001);
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
        } else if (e instanceof AddressCountLimitException) {
            result.setState(4003);
        } else if (e instanceof AddressNotFoundException) {
            result.setState(4004);
        } else if (e instanceof AccessDeniedException) {
            result.setState(4005);
        } else if (e instanceof ProductNotFoundException) {
            result.setState(4006);
        } else if (e instanceof CartNotFoundException) {
            result.setState(4007);
        } else if (e instanceof InsertException) {
            result.setState(5000);
        } else if (e instanceof UpdateException) {
            result.setState(5001);
        } else if (e instanceof DeleteException) {
            result.setState(5002);
        } else if (e instanceof UserRepeatLoginException) {
            result.setState(5003);
        }

//        else if (e instanceof FileEmptyException) {
//            result.setState(6000);
//        } else if (e instanceof FileSizeException) {
//            result.setState(6001);
//        } else if (e instanceof FileTypeException) {
//            result.setState(6002);
//        } else if (e instanceof FileStateException) {
//            result.setState(6003);
//        } else if (e instanceof FileUploadIOException) {
//            result.setState(6004);
//        }
        return result;
    }
    protected final Integer getIdFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("id").toString());
    }

    /**
     * 从HttpSession对象中获取用户名
     * @param session HttpSession对象
     * @return 当前登录的用户名
     */
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }
}
