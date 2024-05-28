package com.t6.bksys.controller;

import com.t6.bksys.service.GetClassroomCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/classroom")
public class GetClassroomCodeController {

    private final GetClassroomCodeService classroomCodeService;

    @Autowired
    public GetClassroomCodeController(GetClassroomCodeService classroomCodeService) {
        this.classroomCodeService = classroomCodeService;
    }

    @PostMapping("/captcha")
    public Map<String, Object> getCheckCode(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
        Integer roomId = (Integer) request.get("room_id");

        if (roomId == null) {
            response.put("code", 0);
            response.put("message", "没有room_id");
        } else {
            String checkCode = classroomCodeService.getCheckCode(roomId);
            if (checkCode == null) {
                response.put("code", 0);
                response.put("message", "没有room_id");
            } else {
                Map<String, String> message = new HashMap<>();
                message.put("check_code", checkCode);
                response.put("code", 1);
                response.put("message", message);
            }
        }

        return response;
    }
}
