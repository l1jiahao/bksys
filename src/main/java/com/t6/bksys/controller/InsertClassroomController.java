package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.SendafterEmail;
import com.t6.bksys.entity.Classroom;
import com.t6.bksys.service.InsertClassroomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classroom")
public class InsertClassroomController {
    private final InsertClassroomService insertClassroomService;
    private static final Logger logger = LoggerFactory.getLogger(SendafterEmail.class);
    @Autowired
    public InsertClassroomController(InsertClassroomService insertClassroomService) {
        this.insertClassroomService = insertClassroomService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> addClassroom(@RequestBody Classroom classroom) {
        logger.info("Received classroom: {}", classroom);
        if (classroom.getaddress_id() == null) {
            JSONObject response = new JSONObject();
            response.put("code", 0);
            response.put("message", "创建失败: 'address_id' 不能为空");
            return ResponseEntity.ok(response.toJSONString());
        }
        try {
            insertClassroomService.addClassroom(classroom);
            JSONObject response = new JSONObject();
            response.put("code", 1);
            JSONObject messageContent = new JSONObject();
            messageContent.put("content", "创建成功!");
            response.put("message", messageContent);
            return ResponseEntity.ok(response.toJSONString());
        } catch (Exception e) {
            JSONObject response = new JSONObject();
            response.put("code", 0);
            response.put("message", "创建失败: " + e.getMessage());
            return ResponseEntity.ok(response.toJSONString());
        }
    }

}
