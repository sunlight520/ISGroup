package com.is.isgroup.filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class loginFilterTest implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        ServletContext context = request.getServletContext();
        String userName = (String) request.getSession().getAttribute("username");
        System.out.println("obj:" + userName);
        if (userName == null) {
            response.sendRedirect("http://127.0.0.1:8080/web/login.html");
        }else {
            if (context.getAttribute("sessionMap") == null) {
                Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();
                sessionMap.put(userName, session);
                context.setAttribute("sessionMap", sessionMap);
            } else {
                Map<String, HttpSession> sessionMap = (Map<String, HttpSession>) context.getAttribute("sessionMap");
                if (!sessionMap.containsKey(userName)) {
                    sessionMap.put(userName, session);
                }else {
                    System.out.println("重复登录啦");
                    response.sendRedirect("/web/main.html");
                }
            }
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
