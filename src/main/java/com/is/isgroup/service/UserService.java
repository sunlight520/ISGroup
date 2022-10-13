package com.is.isgroup.service;

import com.is.isgroup.entity.User;
import com.is.isgroup.util.Result;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Result saveUser(User user);

    /**
     * 查询所有user
     *
     * @return
     */
    Result queryAll();

    /**
     * 通过name和age查询
     *
     * @param name
     * @param age
     * @return
     */
    Result getByNameAndAge(String name, int age);

}
