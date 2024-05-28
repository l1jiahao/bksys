package com.t6.bksys.service;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.entity.Record;
import com.t6.bksys.mapper.BookAlterStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookAlterStatusService {

    private final BookAlterStatusMapper bookAlterStatusMapper;

    @Autowired
    public BookAlterStatusService(BookAlterStatusMapper bookAlterStatusMapper) {
        this.bookAlterStatusMapper = bookAlterStatusMapper;
    }

    public JSONObject alterStatus(Long recordId, Integer newStatusId) {
        JSONObject response = new JSONObject();
        Record record = bookAlterStatusMapper.getRecordById(recordId);

        if (record == null) {
            response.put("code", 0);
            JSONObject message = new JSONObject();
            message.put("content", "没有找到该记录！");
            response.put("message", message);
            return response;
        }

        if (record.getStatusid().equals(newStatusId)) {
            response.put("code", 0);
            JSONObject message = new JSONObject();
            message.put("content", "该记录状态已经为" + newStatusId + "！");
            response.put("message", message);
            return response;
        }

        bookAlterStatusMapper.updateStatusById(recordId, newStatusId);
        response.put("code", 1);
        JSONObject message = new JSONObject();
        message.put("content", "状态修改成功");
        response.put("message", message);
        return response;
    }
}
