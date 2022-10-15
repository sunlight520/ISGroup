package com.is.isgroup.service.impl;

import com.is.isgroup.dao.UserRepository;
import com.is.isgroup.entity.User;
import com.is.isgroup.service.UserService;
import com.is.isgroup.service.ex.InsertException;
import com.is.isgroup.service.ex.UsernameDuplicatedException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String username = user.getName();
        //调用findByUsername,判断用户是否被注册
        User result = userRepository.findUserByName(username);
        if (result != null){
            throw new UsernameDuplicatedException("用户名被占用");
        }
        //        String oldPassword = user.getPassword();
        //随机生成盐值
//        String salt = UUID.randomUUID().toString().toUpperCase();
        //密码加密
//        String md5Password = getMD5Password(oldPassword,salt);
//        补全数据is_delete = 0
//        user.setPassword(oldPassword);
//        user.setIsLandlord(0);
//        user.setName(username);
        return userRepository.save(user);
    }

    @Override
    public List<User> queryAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findUserByName(name);
    }
    private String getMD5Password(String password,String salt){
        for (int i=0;i<3;i++){
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        return password;
    }
}

