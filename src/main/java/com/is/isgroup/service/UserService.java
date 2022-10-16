package com.is.isgroup.service;

import com.is.isgroup.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);
    User login(String username, String password);

    List<User> queryAll();
    User findUserById(Integer id);
    User findUserByUsername(String username);
    Integer updatePasswordByUsername(String username,String oldPassword,String password);
}
