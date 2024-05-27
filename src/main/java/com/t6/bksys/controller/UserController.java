package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.entity.User;
import com.t6.bksys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{user_id}")
        public ResponseEntity<String> getUserByUser_id(@PathVariable String user_id) {

        try {
            User user = userService.getUserByUsername(user_id);

            JSONObject response = new JSONObject();
            response.put("code", 1);
            JSONObject messageContent = new JSONObject();
//            messageContent.put("token", token);
            messageContent.put("name", user.getName());
            messageContent.put("account", user.getAccount());
            messageContent.put("password", user.getPassword());
            messageContent.put("email", user.getEmail());
            messageContent.put("role_id", user.getRole_id());
            messageContent.put("user_id", user.getUser_id());
//            messageContent.put("toString",user.toString());

            messageContent.put("content", "获取用户信息成功！");
            response.put("message", messageContent);
            return ResponseEntity.ok(response.toJSONString());
        } catch (Exception e) {
            JSONObject response = new JSONObject();
            response.put("code", 0);
            response.put("message", "获取用户信息失败！: " + e.getMessage());
            return ResponseEntity.ok(response.toJSONString());
        }
    }


}