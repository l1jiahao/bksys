package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.service.ClassroomCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class ClassroomCodeController {

    private final ClassroomCodeService classroomCodeService;

    @Autowired
    public ClassroomCodeController(ClassroomCodeService classroomCodeService) {
        this.classroomCodeService = classroomCodeService;
    }

    @PostMapping("/assign")
    public ResponseEntity<String> checkClassroomCode(@RequestBody JSONObject requestBody) {
        Integer recordId = requestBody.getInteger("record_id");
        String checkCode = requestBody.getString("check_code");

        boolean isValid = classroomCodeService.checkClassroomCode(recordId, checkCode);

        JSONObject response = new JSONObject();
        if (isValid) {
            response.put("code", 1);
            response.put("message", "签到码有效");
        } else {
            response.put("code", 0);
            response.put("message", "签到码无效");
        }

        return ResponseEntity.ok(response.toJSONString());
    }
}
