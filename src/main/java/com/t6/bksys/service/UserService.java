package com.t6.bksys.service;

import com.t6.bksys.entity.User;
import com.t6.bksys.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    public User getUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
}
