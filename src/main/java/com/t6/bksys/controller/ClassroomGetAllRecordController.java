package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.service.ClassroomGetAllRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classroom")
public class ClassroomGetAllRecordController {

    private final ClassroomGetAllRecordService classroomGetAllRecordService;

    @Autowired
    public ClassroomGetAllRecordController(ClassroomGetAllRecordService classroomGetAllRecordService) {
        this.classroomGetAllRecordService = classroomGetAllRecordService;
    }

    @GetMapping("/get_all_record")
    public JSONObject getAllRecords() {
        return classroomGetAllRecordService.getAllRecords();
    }
}
