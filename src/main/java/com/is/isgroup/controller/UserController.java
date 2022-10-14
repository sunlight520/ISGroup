package com.is.isgroup.controller;

import com.is.isgroup.entity.User;
import com.is.isgroup.service.UserService;
import com.is.isgroup.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController{
    @Autowired
    UserService userService;
    @PostMapping("/saveUser")
    @ResponseBody
    public JsonResult<User> saveUser(@RequestBody User user){
        User result = userService.saveUser(user);
        return new JsonResult<User>(OK,result);
    }
    @GetMapping("/queryAllUser")
    public JsonResult<List> queryAll(){
        List<User> userList =userService.queryAll();
        return new JsonResult<List>(OK,userList);
    }

}

