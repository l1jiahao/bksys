package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.service.BookGetAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookGetAllController {

    private final BookGetAllService bookGetAllService;

    @Autowired
    public BookGetAllController(BookGetAllService bookGetAllService) {
        this.bookGetAllService = bookGetAllService;
    }

    @GetMapping("/get_all")
    public JSONObject getAllRecords() {
        return bookGetAllService.getAllRecords();
    }
}