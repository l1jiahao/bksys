package com.t6.bksys.service;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class BookService {

    private final BookMapper bookMapper;

    @Autowired
    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public JSONObject reserveSeat(Long userId, Long seatId, String startTime, String endTime) {
        JSONObject response = new JSONObject();

        try {
            // 查询seat id对应的room id
            Integer roomId = bookMapper.getRoomIdBySeatId(seatId);
            if (roomId == null) {
                response.put("code", 0);
                response.put("message", "座位不存在!");
                return response;
            }

            // 查询room id对应的status id
            Integer statusId = bookMapper.getStatusIdByRoomId(roomId);

            // 教室未开放
            if (statusId != 1) {
                response.put("code", 0);
                JSONObject message = new JSONObject();
                message.put("content", "教室未开放!");
                response.put("message", message);
                return response;
            }

            // 转换时间，确保时间字符串格式正确
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime start;
            LocalDateTime end;
            try {
                start = LocalDateTime.parse(startTime,formatter);
                end = LocalDateTime.parse(endTime, formatter);
            } catch (DateTimeParseException e) {
                response.put("code", 0);
                response.put("message", "时间格式错误: " + e.getMessage());
                response.put("message2",startTime);
                return response;
            }

            // 查询座位预约记录
            List<JSONObject> records = bookMapper.getRecordsBySeatId(seatId);
            String start1 = null;
            String end1 = null;
            // 检查时间冲突
            for (JSONObject record : records) {
                start1 = record.getString("start_time");
                end1 = record.getString("end_time");
                if(start1.length()==16){
                    start1 = start1+":00";
                }
                if(end1.length()==16){
                    end1 = end1 + ":00";
                }
                LocalDateTime existingStart = LocalDateTime.parse(start1.replace('T',' '), formatter);
                LocalDateTime existingEnd = LocalDateTime.parse(end1.replace('T',' '), formatter);
                if (!(end.isBefore(existingStart) || start.isAfter(existingEnd))) {
                    response.put("code", 0);
                    JSONObject message = new JSONObject();
                    message.put("content", "时间冲突，座位已经被占用!");
                    response.put("message", message);
                    return response;
                }
            }

            // 创建预约记录
            bookMapper.createRecord(seatId, userId, start, end, 1);

            response.put("code", 1);
            JSONObject message = new JSONObject();
            message.put("content", "预约成功!");
            response.put("message", message);
            return response;
        } catch (Exception e) {
            response.put("code", 0);
            response.put("message", "出现错误: " + e.getMessage());
            e.printStackTrace(); // 打印异常堆栈信息
            return response;
        }
    }
}
