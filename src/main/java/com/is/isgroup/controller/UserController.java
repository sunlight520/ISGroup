package com.is.isgroup.controller;

import com.is.isgroup.entity.User;
import com.is.isgroup.service.UserService;
import com.is.isgroup.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;
    @PersistenceContext
    //用来得到hibernate中的session，然后通过session去执行我们直接写的sql操作
    private EntityManager entityManager;
    /**
     * 保存user
     * @param user
     * @return
     */
    @PostMapping("/saveUser")
    @ResponseBody
    public Result saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    /**
     * 查询所有user
     * @return
     */
    @GetMapping("/queryAll")
    public Result queryAll(){
        return userService.queryAll();
    }

    /**
     * 通过name和age查询
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/getByNameAndAge")
    public Result getByNameAndAge(String name,int age){

        return userService.getByNameAndAge(name,age);
    }

}

