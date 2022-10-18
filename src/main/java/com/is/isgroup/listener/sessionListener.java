package com.is.isgroup.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import java.util.Map;

public class sessionListener implements HttpSessionAttributeListener, HttpSessionListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        //获取session
        HttpSession session=event.getSession();
        //通过session来获取context上下文对象
        ServletContext context=session.getServletContext();
        //获得用户名
        String userName= (String) session.getAttribute("userName");
        //判断sessionId是否于之前登录时sessionMap里存的相同
        Map<String,HttpSession> sessionMap = (Map<String, HttpSession>) context.getAttribute("sessionMap");
        String sessionId=sessionMap.get(userName).getId();
        if (!session.getId().equals(sessionId)){
            sessionMap.remove(userName);
        }
        sessionMap.put(userName,session);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("destory");
    }
}