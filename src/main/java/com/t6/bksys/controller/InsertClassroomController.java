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
        if (classroom.getaddress_id() == null || classroom.getRoomName() == null || classroom.getRoomName().isEmpty()) {
            JSONObject response = new JSONObject();
            response.put("code", 0);
            response.put("message", "创建失败: 'address_id' 和 'room_name' 不能为空");
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

    @PostMapping("/newseat")
    public ResponseEntity<String> addSpecifiedSeat(@RequestBody JSONObject request) {
        Integer roomId = request.getInteger("room_id");
        Integer rowNum = request.getInteger("row_num");
        Integer colNum = request.getInteger("col_num");

        if (roomId == null || rowNum == null || colNum == null) {
            JSONObject response = new JSONObject();
            response.put("code", 0);
            response.put("message", "缺少必要参数");
            return ResponseEntity.ok(response.toJSONString());
        }

        try {
            insertClassroomService.addSpecifiedSeat(roomId, rowNum, colNum);
            JSONObject response = new JSONObject();
            response.put("code", 1);
            response.put("message", "座位添加成功");
            return ResponseEntity.ok(response.toJSONString());
        } catch (Exception e) {
            JSONObject response = new JSONObject();
            response.put("code", 0);
            response.put("message", "座位添加失败: " + e.getMessage());
            return ResponseEntity.ok(response.toJSONString());
        }
    }
}
