package com.is.isgroup.dao;

import com.is.isgroup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserById(Integer id);
    User findUserByUsername(String username);
    @Modifying
    @Transactional
    @Query(value = "UPDATE t_user  SET password=:#{#password} where username=:#{#username}",nativeQuery = true)
    Integer updatePasswordByUsername(@Param("username") String username, String password);
    @Modifying
    @Transactional
    @Query(value = "UPDATE t_user  SET is_landlord=:#{#isLandlord} where username=:#{#username}",nativeQuery = true)
    Integer changeLevelByUsername(@Param("username") String username, Integer isLandlord);
}

