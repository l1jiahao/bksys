package com.t6.bksys.service;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.entity.Record;
import com.t6.bksys.entity.Seat;
import com.t6.bksys.mapper.ClassroomGetAllRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClassroomGetAllRecordService {

    private final ClassroomGetAllRecordMapper classroomGetAllRecordMapper;

    @Autowired
    public ClassroomGetAllRecordService(ClassroomGetAllRecordMapper classroomGetAllRecordMapper) {
        this.classroomGetAllRecordMapper = classroomGetAllRecordMapper;
    }

    public JSONObject getAllRecords() {
        JSONObject response = new JSONObject();
        List<Seat> seats = classroomGetAllRecordMapper.getAllSeats();
        Map<Integer, JSONObject> classroomMap = new HashMap<>();

        for (Seat seat : seats) {
            Integer roomId = seat.getRoomId();
            List<Record> records = classroomGetAllRecordMapper.getRecordsBySeatId(seat.getSeatId());

            JSONObject classroomData = classroomMap.getOrDefault(roomId, new JSONObject());
            classroomData.put("classroom", roomId.toString());
            classroomData.put("count", classroomData.getIntValue("count") + records.size());

            long signCount = records.stream().filter(record -> record.getStatusid() == 2).count();
            classroomData.put("sign_count", classroomData.getIntValue("sign_count") + signCount);

            classroomMap.put(roomId, classroomData);
        }

        response.put("code", 1);
        response.put("message", new ArrayList<>(classroomMap.values()));

        return response;
    }
}
