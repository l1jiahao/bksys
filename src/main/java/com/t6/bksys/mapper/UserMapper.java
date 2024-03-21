package com.t6.bksys.mapper;

import com.t6.bksys.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("""
            select user.user_id, user.name, user.account, user.password, role.role_type
            from user, role
            where user.name = #{username} and role.role_id=user.role_id""")
    @Results({
            @Result(column = "user_id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "account", property = "account"),
            @Result(column = "password", property = "password"),
            @Result(column = "role_type", property = "role_type")
    })
    User selectByUsername(@Param("username") String username);
}
