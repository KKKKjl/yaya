package com.example.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.app.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    List<User> getAllUsers();

    @Insert({"insert into user(nickname, password, create_time) values (#{nickname}, #{password}, #{create_time})"})
    void insertUserInfo(User user);

    @Select("select password from user where nickname = #{nickname}")
    String getPasswordHash(User user);

    @Select("select * from user where nickname = #{nickname}")
    User getUserInfo(@Param("nickname") String nickname);

    @Select("select id, nickname, email from user where nickname = #{nickname}")
    User getUser(@Param("nickname") String nickname);
}