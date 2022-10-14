package com.is.isgroup.service.impl;

import com.is.isgroup.dao.UserRepository;
import com.is.isgroup.entity.User;
import com.is.isgroup.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> queryAll() {
        return userRepository.findAll();
    }

}

