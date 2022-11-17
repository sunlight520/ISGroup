package com.is.isgroup.filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class loginFilterTest implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpSession session= request.getSession(false);
        ServletContext context=request.getServletContext();
        String userName = (String)request.getSession().getAttribute("username");
        System.out.println("obj:"+userName);
        if (userName==null){
            response.sendRedirect("http://127.0.0.1:8080/web/login.html");
        }else {
            if (context.getAttribute("userList") == null){
                //如果第一次登录这个客户端，就创建列表，加入用户
                List<String> userList = new ArrayList<String>();
                userList.add(userName);
                context.setAttribute("userList",userList);
            }else {
                //如果不是第一次登录
                List<String> userList= (List<String>) context.getAttribute("userList");
                //就判断用户列表中是否有此用户
                if (!userList.contains(userName)){
                    //如果不包含该用户，就添加进去
                    userList.add(userName);
                }else {
//                  response.sendRedirect("/web/main.html");
//                    response.sendRedirect("http://127.0.0.1:8080/web/login.html");
                    //用于销毁session
                    System.out.println("重复登录啦");
                }
                System.out.println(userList);
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
