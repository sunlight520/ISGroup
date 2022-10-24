package com.is.isgroup.controller;

import com.is.isgroup.entity.User;
import com.is.isgroup.service.UserService;
import com.is.isgroup.service.ex.PasswordNotMatchException;
import com.is.isgroup.service.ex.UserNotFoundException;
import com.is.isgroup.service.ex.UserRepeatLoginException;
import com.is.isgroup.service.ex.UsernameDuplicatedException;
import com.is.isgroup.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    @RequestMapping("/register")
    public JsonResult<User> register(User user){
        User user1 = userService.saveUser(user);
        return new JsonResult<User>(OK,user1);
    }
    @RequestMapping("/login")
    public JsonResult<User> login(HttpServletRequest request,String username, String password, HttpSession session) {
        // 调用业务对象的方法执行登录，并获取返回值
        String name = (String) session.getAttribute("username");
//        if (!Objects.equals(username, name)) {
//            throw new UserRepeatLoginException("用户已经登陆啦");
//        }

        User data = userService.login(username, password);
        //登录成功后，将uid和username存入到HttpSession中
        session.setAttribute("id", data.getId());
//        session.setAttribute("username", data.getUsername());
//         System.out.println("Session中的id=" + getIdFromSession(session));
         System.out.println("Session中的username=" + session.getAttribute("username"));
        // 将以上返回值和状态码OK封装到响应结果中并返回
        return new JsonResult<User>(OK, data);
    }
    @RequestMapping("/exit")
    public JsonResult<Void> exit(HttpSession session){
        session.invalidate();
        return new JsonResult<>(OK);
    }
    @RequestMapping("/logout")
    //退出就是将session中的用户id清理掉，需要操作session，参数要加上HttpServletRequest request
    public JsonResult<String> logout(HttpServletRequest servletRequest,HttpSession session){
        //清理session中保存的当前员工id
        //获取全局对象
        ServletContext context = ((HttpServletRequest) servletRequest).getServletContext();
        List<String> userList= (List<String>) context.getAttribute("userList");
        Map<String,HttpSession> sessionMap= (Map<String, HttpSession>) context.getAttribute("sessionMap");
        String username = (String) servletRequest.getSession().getAttribute("username");
        System.out.println();
        userList.remove(username);
        sessionMap.remove(username);
        return new JsonResult<>(OK,"退出成功");
    }
    @RequestMapping("/updatePassword")
    public JsonResult<Void> updatePassword(String oldPassword,String password,HttpSession session){
            String username = getUsernameFromSession(session);
            userService.updatePasswordByUsername(username,password,oldPassword);
            return new JsonResult<>(OK);
    }
    @RequestMapping("/changePrivilege")
    public JsonResult<Void> changePrivilege(String username,Integer level){
        userService.changeLevelByUsername(username,level);
        return new JsonResult<>(OK);
    }
}

