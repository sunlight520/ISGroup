package com.is.isgroup.service;

import com.is.isgroup.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void saveTest(){
            User user = new User();
            user.setUsername("LXPoo1");
            userService.saveUser(user);

    }

    @Test
    public void findUserByIdTest(){
        User user = userService.findUserById(14);
        System.out.println(user);
    }
    @Test
    public void updatePasswordTest(){
    }
}
