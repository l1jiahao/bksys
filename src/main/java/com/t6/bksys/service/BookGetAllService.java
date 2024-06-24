package com.t6.bksys.service;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.entity.Record;
import com.t6.bksys.mapper.BookGetAllMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookGetAllService {

    private final BookGetAllMapper bookGetAllMapper;

    @Autowired
    public BookGetAllService(BookGetAllMapper bookGetAllMapper) {
        this.bookGetAllMapper = bookGetAllMapper;
    }

    public JSONObject getAllRecords() {
        JSONObject response = new JSONObject();
        List<Record> records = bookGetAllMapper.getAllRecords();
        List<JSONObject> recordList = new ArrayList<>();

        for (Record record : records) {
            JSONObject recordJson = new JSONObject();
            recordJson.put("record_id", record.getRecordId());
            recordJson.put("seat_id", record.getSeatId());
            recordJson.put("status_id", record.getStatusid());
            recordJson.put("user_id", record.getUserid());
            recordJson.put("start_time", record.getStartTime().toString());
            recordJson.put("end_time", record.getEndTime().toString());
            recordList.add(recordJson);
        }

        response.put("code", 1);
        response.put("message", recordList);

        return response;
    }
}
