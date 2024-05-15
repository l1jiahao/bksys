package com.t6.bksys.mapper;

import com.t6.bksys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRegistrationMapper {
    @Insert("INSERT INTO user(name, account, password, email, role_id)" +
            " VALUES(#{name}, #{account}, #{password}, #{email}, 1)")
    @Options(useGeneratedKeys = true, keyProperty = "user_id")
    void insertUser(User user);
}


