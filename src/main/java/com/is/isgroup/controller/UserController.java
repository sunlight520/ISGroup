package com.is.isgroup.controller;

import com.is.isgroup.entity.User;
import com.is.isgroup.service.UserService;
import com.is.isgroup.service.ex.UsernameDuplicatedException;
import com.is.isgroup.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    @RequestMapping("/reg")
    public JsonResult<User> reg(User user){
        User user1 = userService.saveUser(user);
        return new JsonResult<User>(OK,user1);
    }

    @RequestMapping("/login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        // 调用业务对象的方法执行登录，并获取返回值
        User data = userService.login(username, password);
        //登录成功后，将uid和username存入到HttpSession中
        session.setAttribute("id", data.getId());
        session.setAttribute("username", data.getUsername());
         System.out.println("Session中的id=" + getIdFromSession(session));
         System.out.println("Session中的username=" + getUsernameFromSession(session));
        // 将以上返回值和状态码OK封装到响应结果中并返回
        return new JsonResult<User>(OK, data);
    }
    @RequestMapping("/updatePassword")
    public JsonResult<Void> updatePassword(String password,HttpSession session){
            String username = getUsernameFromSession(session);
            userService.updatePasswordByUsername(username,password);
            return new JsonResult<>(OK);
    }

}

