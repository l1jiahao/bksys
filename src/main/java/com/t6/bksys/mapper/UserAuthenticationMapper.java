package com.t6.bksys.mapper;

import com.t6.bksys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserAuthenticationMapper {
    @Select("SELECT * FROM user WHERE account = #{account} AND password = #{password}")
    User findByAccountAndPassword(@Param("account") String account, @Param("password") String password);
}
