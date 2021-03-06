package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

// 持久层接口 - MyBatis中无需显式实现
public interface UserMapper {
    List<User> getUserList();

    // getUserByUsername
    @Select("select * from user where username=#{username}")
    User getUserByUsername(String username);

    // insertUser
    // 此处密码已使用MD5加密存储
    @Insert("insert into test.user(username,password,email,phone) values(#{username}, #{password}, #{email}, #{phone})")
    @Options(useGeneratedKeys = true)
    int insertUser(String username, String password, String email, String phone);

    @Select("select * from user where email=#{email}")
    User getUserByEmail(String email);

    @Update("UPDATE user SET password=#{password} WHERE username=#{username};")
    int updateUserPwd(String username, String password);
}
