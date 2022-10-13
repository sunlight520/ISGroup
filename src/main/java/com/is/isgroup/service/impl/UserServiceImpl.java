package com.is.isgroup.service.impl;

import com.is.isgroup.dao.UserRepository;
import com.is.isgroup.entity.User;
import com.is.isgroup.service.UserService;
import com.is.isgroup.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserRepository userRepository;

    @Override
    public Result saveUser(User user) {
        User save = userRepository.save(user);
        return new Result(save);
    }

    @Override
    public Result queryAll() {
        List<User> list = userRepository.findAll();
        return new Result(list);
    }

    @Override
    public Result getByNameAndAge(String name, int age) {
        List <User> list = userRepository.getByNameAndAge(name, age);
        return new Result(list);
    }
}

