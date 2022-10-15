package com.is.isgroup.service;

import com.is.isgroup.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);
    User login(String name, String password);

    List<User> queryAll();
    User findUserById(Integer id);
    User findUserByName(String name);
}
