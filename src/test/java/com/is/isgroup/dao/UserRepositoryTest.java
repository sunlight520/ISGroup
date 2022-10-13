package com.is.isgroup.dao;

import com.is.isgroup.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Test
     public void saveTest(){
        User user = new User();
        user.setAge(18);
        user.setName("LXP");
        userRepository.save(user);
    }
}
