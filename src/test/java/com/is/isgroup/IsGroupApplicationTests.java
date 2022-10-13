package com.is.isgroup;

import com.is.isgroup.dao.UserRepository;
import com.is.isgroup.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IsGroupApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    UserRepository userRepository;
    @Test
    void saveTest(){
        User user = new User();
        user.setAge(18);
        user.setName("LXP");
        userRepository.save(user);
    }
}
