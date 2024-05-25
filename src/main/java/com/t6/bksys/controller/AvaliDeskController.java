package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.service.AvaliDeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classroom")
public class AvaliDeskController {

    private final AvaliDeskService avaliDeskService;

    @Autowired
    public AvaliDeskController(AvaliDeskService avaliDeskService) {
        this.avaliDeskService = avaliDeskService;
    }

    @PostMapping("/avali_desk")
    public JSONObject getAvailableSeats(@RequestBody String body) {
        JSONObject jsonObject = JSONObject.parseObject(body);
        Integer roomId = jsonObject.getInteger("room_id");
        String startTime = jsonObject.getString("start_time");
        String endTime = jsonObject.getString("end_time");

        return avaliDeskService.getAvailableSeats(roomId, startTime, endTime);
    }
}
