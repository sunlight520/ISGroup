package com.is.isgroup.dao;

import com.is.isgroup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserById(Integer id);
    User findUserByName(String name);
}

