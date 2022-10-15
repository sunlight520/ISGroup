package com.is.isgroup.controller;

import com.is.isgroup.entity.User;
import com.is.isgroup.service.UserService;
import com.is.isgroup.service.ex.UsernameDuplicatedException;
import com.is.isgroup.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    @RequestMapping("/saveUser")

    public JsonResult<User> saveUser(User user){
        User user1 = userService.saveUser(user);
        return new JsonResult<User>(OK,user1);
    }
//    @GetMapping("/queryAllUser")
//    public JsonResult<List> queryAll(){
//        List<User> userList =userService.queryAll();
//        return new JsonResult<List>(OK,userList);
//    }

}

