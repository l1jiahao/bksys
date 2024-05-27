package com.t6.bksys.mapper;

import com.t6.bksys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserAlterMapper {
    @Update("UPDATE user SET name = #{user.name}, password = #{user.password}, account = #{user.account}, role_id = #{user.role_id}, email = #{user.email} WHERE user_id = #{user.user_id}")
    void updateUser(@Param("user") User user);
}