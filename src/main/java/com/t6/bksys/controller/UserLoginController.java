package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.service.UserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserLoginController {
    private final UserLoginService userLoginService;
    private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    @Autowired
    public UserLoginController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody JSONObject loginDetails) {
        logger.info("Received login request for account: {}", loginDetails.getString("account"));
        try {
            String account = loginDetails.getString("account");
            String password = loginDetails.getString("password");
            // 调用userService登录用户，并获取生成的token
            String token = userLoginService.loginUser(account, password);

            if (token.equals("Invalid login credentials")) {
                JSONObject response = new JSONObject();
                response.put("code", 0);
                response.put("message", "登录失败：用户名或密码错误");
                return ResponseEntity.ok(response.toJSONString());
            } else {
                JSONObject response = new JSONObject();
                response.put("code", 1);
                JSONObject messageContent = new JSONObject();
                messageContent.put("token", token);
                messageContent.put("content", "登录成功！");
                response.put("message", messageContent);
                return ResponseEntity.ok(response.toJSONString());
            }
        } catch (Exception e) {
            JSONObject response = new JSONObject();
            response.put("code", 0);
            response.put("message", "登录异常: " + e.getMessage());
            logger.error("Login exception", e);
            return ResponseEntity.ok(response.toJSONString());
        }
    }
}
