package com.t6.bksys.service;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.entity.Record;
import com.t6.bksys.entity.Seat;
import com.t6.bksys.mapper.AvaliDeskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvaliDeskService {

    private final AvaliDeskMapper avaliDeskMapper;

    @Autowired
    public AvaliDeskService(AvaliDeskMapper avaliDeskMapper) {
        this.avaliDeskMapper = avaliDeskMapper;
    }


    public JSONObject getAvailableSeats(Integer roomId, String startTime, String endTime) {
        JSONObject response = new JSONObject();
        List<Seat> seats = avaliDeskMapper.getSeatsByRoomId(roomId);
        List<JSONObject> availableSeats = new ArrayList<>();

        for (Seat seat : seats) {
            List<Record> records = avaliDeskMapper.getRecordsBySeatIdAndTime(seat.getSeatId(), startTime, endTime);
            if (records.isEmpty()) {
                JSONObject seatInfo = new JSONObject();
                seatInfo.put("seat_id", seat.getSeatId());
                seatInfo.put("room_id", seat.getRoomId());
                seatInfo.put("bonus_id", seat.getBonusId());
                seatInfo.put("row_num", seat.getRowNum());
                seatInfo.put("col_num", seat.getColNum());
                availableSeats.add(seatInfo);
            }
        }

        response.put("code", 1);
        JSONObject message = new JSONObject();
        message.put("data", availableSeats);
        response.put("message", message);

        return response;
    }
}
