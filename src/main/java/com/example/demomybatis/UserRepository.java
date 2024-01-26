package com.example.demomybatis;


import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository {

    @Select("""
            SELECT * FROM user_tb
            """)
    @Results(id = "user", value = {
            @Result(property = "userId", column = "id"),
    }
    )
    List<User> getAllUser();


    @Select("""
            SELECT * from user_tb where id=#{userId}
            """)
    @ResultMap(value = "user")
    User getById(Integer userId);

    @Select("""
            insert into user_tb(username,email,password) values (#{user.username},#{user.email},#{user.password}) returning *
            """)
    @ResultMap(value = "user")
    User create(@Param("user") User user);

    @Select("""
            Delete from user_tb where id=#{userId} returning *
            """)
    @ResultMap(value = "user")
    User deleteById(Integer userId);

    @Select("""
            update user_tb set username=#{user.username},email=#{user.email},password=#{user.password} 
            where id=#{userId} returning * 
            """)
    @ResultMap(value = "user")
    User updateById(Integer userId, User user);
}
