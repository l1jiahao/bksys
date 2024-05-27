package com.t6.bksys.mapper;

import com.t6.bksys.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE user_id = #{user_id}")
    @Results({
            @Result(column = "user_id", property = "user_id"),
            @Result(column = "name", property = "name"),
            @Result(column = "account", property = "account"),
            @Result(column = "password", property = "password"),
            @Result(column = "email", property = "email"),
            @Result(column = "role_id", property = "role_id")
    })
    User selectByUserId(@Param("user_id") String user_id);
}
