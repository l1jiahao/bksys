package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.entity.User;
import com.t6.bksys.service.UserAlterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserAlterController {
    private final UserAlterService userAlterService;
    private static final Logger logger = LoggerFactory.getLogger(UserAlterController.class);

    @Autowired
    public UserAlterController(UserAlterService userAlterService) {
        this.userAlterService = userAlterService;
    }

    @PostMapping("/alter")
    public ResponseEntity<String> updateUser(@RequestBody JSONObject inputJson) {
        try {
            // 解析用户信息
            User user = new User();
            user.setName(inputJson.getString("name"));
            user.setAccount(inputJson.getString("account"));
            user.setPassword(inputJson.getString("password"));
            user.setEmail(inputJson.getString("email"));
            user.setUser_id(inputJson.getInteger("user_id"));
            user.setRole_id(inputJson.getString("role_id"));

            // 调用 userService 更新用户信息
            boolean updateStatus = userAlterService.updateUser(user);
            JSONObject response = new JSONObject();
            JSONObject messageContent = new JSONObject();
            if (updateStatus) {
                response.put("code", 1);
                messageContent.put("content", String.format("用户“%s”信息更新成功!", user.getName()));
            } else {
                response.put("code", 0);
                messageContent.put("content", "更新失败，请检查日志!");
            }
            response.put("message", messageContent);
            return ResponseEntity.ok(response.toJSONString());
        } catch (Exception e) {
            logger.error("Error updating user: ", e);
            JSONObject response = new JSONObject();
            JSONObject messageContent = new JSONObject();
            messageContent.put("content", "更新失败: " + e.getMessage());
            response.put("code", 0);
            response.put("message", messageContent);
            return ResponseEntity.badRequest().body(response.toJSONString());
        }
    }
}
