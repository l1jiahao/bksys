package com.t6.bksys.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.entity.User;
import com.t6.bksys.service.UserRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRegistrationController {
    private final UserRegistrationService userRegistrationService;
    private static final Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping("/sign_up")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        logger.info("Received registration request for user: {}", user);
        try {
            // 调用userService注册用户，并获取生成的token
            String token = userRegistrationService.registerUser(user);
            JSONObject response = new JSONObject();
            response.put("code", 1);
            JSONObject messageContent = new JSONObject();
            messageContent.put("content", String.format("用户“%s”创建成功!", user.getName()));
            messageContent.put("token", token);
            response.put("message", messageContent);
            return ResponseEntity.ok(response.toJSONString());
        } catch (Exception e) {
            JSONObject response = new JSONObject();
            response.put("code", 0);
            response.put("message", "注册失败: " + e.getMessage());
            System.out.println(e);
            return ResponseEntity.ok(response.toJSONString());
        }
    }
}
