package com.is.isgroup.service.impl;

import com.is.isgroup.dao.UserRepository;
import com.is.isgroup.entity.User;
import com.is.isgroup.service.UserService;
import com.is.isgroup.service.ex.*;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserRepository userRepository;

    @Override
    public User saveUser(User user){
        String username = user.getUsername();
        // 调用持久层的User findByUsername(String username)方法，根据用户名查询用户数据
        User result = userRepository.findUserByUsername(username);
        // 判断查询结果是否不为null
        if (result != null) {
            // 是：表示用户名已被占用，则抛出UsernameDuplicateException异常
            throw new UsernameDuplicateException("尝试注册的用户名[" + username + "]已经被占用");
        }
        String salt = UUID.randomUUID().toString().toUpperCase();
        user.setSalt(salt);
        String oldPassword = user.getPassword();
        // 调用getMd5Password()方法，将参数password和salt结合起来进行加密
        String md5Password = getMD5Password(oldPassword, salt);
//         判断查询结果中的密码，与以上加密得到的密码是否不一致
        user.setPassword(md5Password);
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        // 调用userMapper的findByUsername()方法，根据参数username查询用户数据
        User result = userRepository.findUserByUsername(username);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出UserNotFoundException异常
            throw new UserNotFoundException("用户数据不存在的错误");
        }
        // 判断查询结果中的isDelete是否为1
//        if (result.getIsDelete() == 1) {
//            // 是：抛出UserNotFoundException异常
//            throw new UserNotFoundException("用户数据不存在的错误");
//        }
        // 从查询结果中获取盐值
        String salt = result.getSalt();
        // 调用getMd5Password()方法，将参数password和salt结合起来进行加密
        String md5Password = getMD5Password(password, salt);
//         判断查询结果中的密码，与以上加密得到的密码是否不一致
        if (!result.getPassword().equals(md5Password)) {
            // 是：抛出PasswordNotMatchException异常
            throw new PasswordNotMatchException("密码验证失败的错误");
        }
        // 创建新的User对象
        User user = new User();
        // 将查询结果中的uid、username、avatar封装到新的user对象中
        user.setId(result.getId());
        user.setUsername(result.getUsername());
        // 返回新的user对象
        return user;
    }

    @Override
    public List<User> queryAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public Integer updatePasswordByUsername(String username, String password,String oldPassword) {
        User result  = userRepository.findUserByUsername(username);
        String dataBaseOldPassword = result.getPassword();
        String salt = result.getSalt();
        // 调用getMd5Password()方法，将参数password和salt结合起来进行加密
        String oldMd5Password = getMD5Password(oldPassword, salt);
//         判断查询结果中的密码，与以上加密得到的密码是否不一致
        if (!oldMd5Password.equals(dataBaseOldPassword)) {
            // 是：抛出PasswordNotMatchException异常
            throw new PasswordNotMatchException("原密码错误");
        }
        String newMd5Password = getMD5Password(password,salt);
        return userRepository.updatePasswordByUsername(username,newMd5Password);
    }

    @Override
    public Integer changeLevelByUsername(String username, Integer isLandlord) {
        return userRepository.changeLevelByUsername(username,isLandlord);
    }

    private String getMD5Password(String password,String salt){
        for (int i=0;i<3;i++){
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        return password;
    }
}

