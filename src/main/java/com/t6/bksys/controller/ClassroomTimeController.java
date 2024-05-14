package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.entity.Classroom;
import com.t6.bksys.service.ClassroomTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classroom")
public class ClassroomTimeController {

    private final ClassroomTimeService classroomTimeService;

    @Autowired
    public ClassroomTimeController(ClassroomTimeService classroomTimeService) {
        this.classroomTimeService = classroomTimeService;
    }

    @PostMapping("/alter_time")
    public ResponseEntity<String> alterClassroomTime(@RequestBody Classroom classroom) {
        try {
            classroomTimeService.alterClassroomTime(classroom);
            JSONObject responseJson = new JSONObject();
            responseJson.put("code", 1);
            JSONObject messageJson = new JSONObject();
            messageJson.put("content", "修改成功!");
            responseJson.put("message", messageJson);
            return new ResponseEntity<>(responseJson.toJSONString(), HttpStatus.OK);
        }catch(Exception e){
            JSONObject responseJson = new JSONObject();
            responseJson.put("code", 0);
            JSONObject messageJson = new JSONObject();
            messageJson.put("content", "修改失败！");
            responseJson.put("message", messageJson);
            return new ResponseEntity<>(responseJson.toJSONString(), HttpStatus.OK);

        }
    }
}
