package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/do_book")
    public ResponseEntity<String> do_book(@RequestBody String body) {
        JSONObject jsonObject = JSONObject.parseObject(body);
        Long userId = jsonObject.getLong("user_id");
        Long seatId = jsonObject.getLong("seat_id");
        String startTime = jsonObject.getString("start_time");
        String endTime = jsonObject.getString("end_time");

        JSONObject response = bookService.reserveSeat(userId, seatId, startTime, endTime);
        return ResponseEntity.ok(response.toJSONString());
    }
}
