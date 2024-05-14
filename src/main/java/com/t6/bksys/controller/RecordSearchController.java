package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.entity.Record;
import com.t6.bksys.service.RecordSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecordSearchController {
    private final RecordSearchService recordSearchService;

    @Autowired
    public RecordSearchController(RecordSearchService recordSearchService) {
        this.recordSearchService = recordSearchService;
    }

    @PostMapping("/book/get_history")
    public ResponseEntity<String> searchRecord(@RequestBody String body) {
        JSONObject jsonObject = JSONObject.parseObject(body);
        Integer userId = jsonObject.getInteger("user_id");

        try {
            List<Record> records = recordSearchService.getRecordsByUserId(userId);
            if (records != null && !records.isEmpty()) {
                JSONObject successMessage = new JSONObject();
                successMessage.put("code", 1);

                JSONArray recordsJson = new JSONArray();
                for (Record record : records) {
                    JSONObject recordJson = new JSONObject();
                    recordJson.put("record_id", record.getRecordId());
                    recordJson.put("seat_id", record.getSeatId());
                    recordJson.put("endTime", record.getEndTime().toString());
                    recordJson.put("startTime", record.getStartTime().toString());
                    recordJson.put("status_id", record.getStatusid());
                    recordJson.put("user_id", record.getUserid());
                    recordsJson.add(recordJson);
                }
                JSONObject messageDetails = new JSONObject();
                messageDetails.put("data", recordsJson); // 添加记录数组
                successMessage.put("message", messageDetails);
                return ResponseEntity.ok(successMessage.toJSONString());
            } else {
                JSONObject failMessage = new JSONObject();
                failMessage.put("code", 0);
                failMessage.put("message", "没有找到相关记录");
                return ResponseEntity.ok(failMessage.toJSONString());
            }
        } catch (Exception e) {
            JSONObject failMessage = new JSONObject();
            failMessage.put("ret_type", 0);
            failMessage.put("message", e.getMessage() + "访问/获取失败");
            return ResponseEntity.ok(failMessage.toJSONString());
        }
    }
}
