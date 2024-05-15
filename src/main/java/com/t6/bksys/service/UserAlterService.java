package com.t6.bksys.service;

import com.t6.bksys.entity.User;
import com.t6.bksys.mapper.UserAlterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAlterService {
    private final UserAlterMapper userAlterMapper;

    @Autowired
    public UserAlterService(UserAlterMapper userAlterMapper) {
        this.userAlterMapper = userAlterMapper;
    }

    @Transactional
    public boolean updateUser(User user) {
        try {
            // 更新用户信息
            userAlterMapper.updateUser(user);
            return true;
        } catch (Exception e) {
            // 处理可能的异常，比如数据库操作失败等
            System.err.println("Error updating user: " + e.getMessage());
            return false;
        }
    }
}
