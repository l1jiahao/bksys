package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.service.AlterStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classroom")
public class AlterStatusController {

    private final AlterStatusService alterStatusService;

    @Autowired
    public AlterStatusController(AlterStatusService alterStatusService) {
        this.alterStatusService = alterStatusService;
    }

    @PostMapping("/alter_status")
    public ResponseEntity<String> alterStatus(@RequestBody String body) {
        JSONObject jsonObject = JSONObject.parseObject(body);
        Integer roomId = jsonObject.getInteger("room_id");
        Integer statusId = jsonObject.getInteger("status_id");

        try {
            boolean isUpdated = alterStatusService.updateStatus(roomId, statusId);
            JSONObject response = new JSONObject();
            if (isUpdated) {
                response.put("code", 1);
                JSONObject message = new JSONObject();
                message.put("content", "状态修改成功!");
                response.put("message", message);
            } else {
                response.put("code", 0);
                response.put("message", "状态修改失败!");
            }
            return ResponseEntity.ok(response.toJSONString());
        } catch (Exception e) {
            JSONObject errorResponse = new JSONObject();
            errorResponse.put("code", 0);
            errorResponse.put("message", "出现错误: " + e.getMessage());
            return ResponseEntity.ok(errorResponse.toJSONString());
        }
    }
}
