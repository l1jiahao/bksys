package com.t6.bksys.controller;

import com.t6.bksys.service.GetLocationByRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class GetLocationByRecordController {

    private final GetLocationByRecordService locationService;
    private static final Logger logger = LoggerFactory.getLogger(GetLocationByRecordController.class);

    @Autowired
    public GetLocationByRecordController(GetLocationByRecordService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/record_address")
    public Map<String, Object> getLocation(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
        Integer recordId = (Integer) request.get("record_id");

        logger.info("record_id是: {}", recordId);

        if (recordId == null) {
            response.put("code", 0);
            response.put("message", "没有record_id");
            logger.warn("没有record_id");
        } else {
            Map<String, Object> locationData = locationService.getLocationByRecordId(recordId);
            if (locationData == null) {
                response.put("code", 0);
                response.put("message", "记录未找到");
                logger.warn("记录未找到: record_id = {}", recordId);
            } else {
                response.put("code", 1);
                response.put("message", locationData);
                logger.info("记录找到: {}", locationData);
            }
        }

        return response;
    }
}
