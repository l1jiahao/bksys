package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.entity.Address;
import com.t6.bksys.service.InsertFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class InsertFloorController {

    private final InsertFloorService insertFloorService;

    @Autowired
    public InsertFloorController(InsertFloorService insertFloorService) {
        this.insertFloorService = insertFloorService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBuildingInfo(@RequestBody Address address) {
        insertFloorService.addAddress(address);
        JSONObject responseJson = new JSONObject();
        responseJson.put("code", 1);
        JSONObject messageJson = new JSONObject();
        messageJson.put("content", "创建成功");
        responseJson.put("message", messageJson);
        return new ResponseEntity<>(responseJson.toJSONString(), HttpStatus.OK);
    }
}
