package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.entity.Classroom;
import com.t6.bksys.service.FindClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class FindClassroomController {

    private final FindClassroomService classroomService;

    @Autowired
    public FindClassroomController(FindClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @PostMapping("/find")
    public ResponseEntity<String> findClassrooms(@RequestBody JSONObject requestBody) {
        String building = requestBody.getString("building");
        Integer floor = requestBody.getInteger("floor");

        try {
            List<Classroom> classrooms = classroomService.findClassroomsByBuildingAndFloor(building, floor);
            JSONObject response = new JSONObject();
            response.put("code", 1);
            JSONArray classroomArray = new JSONArray();

            for (Classroom classroom : classrooms) {
                JSONObject jsonClassroom = new JSONObject();
                jsonClassroom.put("room_id", classroom.getRoomId());
                jsonClassroom.put("address_id", classroom.getaddress_id());
                jsonClassroom.put("room_name", classroom.getRoomName());
                jsonClassroom.put("row_count", classroom.getRowCount());
                jsonClassroom.put("col_count", classroom.getColCount());
                jsonClassroom.put("open_time", classroom.getOpenTime().toString());
                jsonClassroom.put("close_time", classroom.getCloseTime().toString());
                jsonClassroom.put("status", getStatusName(classroom.getStatusId()));
                classroomArray.add(jsonClassroom);
            }

            response.put("message", classroomArray);
            return ResponseEntity.ok(response.toJSONString());
        } catch (Exception e) {
            JSONObject failMessage = new JSONObject();
            failMessage.put("code", 0);
            failMessage.put("message", "查询失败: " + e.getMessage());
            return ResponseEntity.badRequest().body(failMessage.toJSONString());
        }
    }

    private String getStatusName(Integer statusId) {
        switch (statusId) {
            case 1:
                return "开放";
            case 2:
                return "已关闭";
            case 3:
                return "暂停使用";
            default:
                return "未知状态";
        }
    }
}
