package com.t6.bksys.mapper;

import com.t6.bksys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserLoginMapper {

    /**
     * 根据账号和密码从数据库中检索用户。
     *
     * @param account  用户的账号
     * @param password 用户的密码
     * @return 如果账号和密码匹配则返回用户对象，否则返回 null。
     */
    @Select("SELECT * FROM user WHERE account = #{account} AND password = #{password}")
    User loginUser(@Param("account") String account, @Param("password") String password);
}
