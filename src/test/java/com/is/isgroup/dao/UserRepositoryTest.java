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
        user.setUsername("LXP");
//        save返回值User
        userRepository.save(user);
    }
    @Test
    public void deleteUserTest(){
        userRepository.deleteById(9);
    }
    @Test
    public void findUserByIdTest(){
        User user = userRepository.findUserById(14);
        System.out.println(user);
    }
    @Test
    public void insertUserTest(){
        User user = new User();
        user.setUsername("LXS");
        user.setIsLandlord(1);
        user.setPassword("0610");
        User row = userRepository.save(user);
        System.out.println(row);
    }
    @Test
    public void updatePasswordTest(){
        String name = "LXPoo";
        userRepository.updatePasswordByUsername(name,"LOVE");
    }
}
