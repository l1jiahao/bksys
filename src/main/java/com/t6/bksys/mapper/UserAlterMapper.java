package com.t6.bksys.mapper;

import com.t6.bksys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserAlterMapper {
    @Update("UPDATE user SET name = #{user.name}, password = #{user.password}, email = #{user.email} WHERE account = #{user.account}")
    void updateUser(@Param("user") User user);
}