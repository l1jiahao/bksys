package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.service.BookAlterStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/book")
public class BookAlterStatusController {

    private final BookAlterStatusService bookAlterStatusService;

    @Autowired
    public BookAlterStatusController(BookAlterStatusService bookAlterStatusService) {
        this.bookAlterStatusService = bookAlterStatusService;
    }

    @PostMapping("/alter_status")
    public JSONObject alterStatus(@RequestBody String body) {
        JSONObject jsonObject = JSONObject.parseObject(body);
        Long recordId = jsonObject.getLong("record_id");
        Integer statusId = jsonObject.getInteger("status_id");

        return bookAlterStatusService.alterStatus(recordId, statusId);
    }
}
