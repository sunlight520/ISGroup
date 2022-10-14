package com.is.isgroup.service;

import com.is.isgroup.entity.User;
import com.is.isgroup.util.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);
    List<User> queryAll();

}
