package com.t6.bksys.service;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.entity.Seat;
import com.t6.bksys.mapper.AlterBonusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlterBonusService {

    private final AlterBonusMapper alterBonusMapper;

    @Autowired
    public AlterBonusService(AlterBonusMapper alterBonusMapper) {
        this.alterBonusMapper = alterBonusMapper;
    }

    public JSONObject updateSeatBonus(JSONObject request) {
        JSONObject response = new JSONObject();
        Long seatId = request.getLong("seat_id");
        Integer bonusId = request.getInteger("bonus_id");

        try {
            Seat seat = alterBonusMapper.getSeatById(seatId);
            if (seat != null) {
                alterBonusMapper.updateBonusId(seatId, bonusId);
                response.put("code", 1);
                JSONObject message = new JSONObject();
                message.put("content", "修改成功");
                response.put("message", message);
            } else {
                response.put("code", 0);
                JSONObject message = new JSONObject();
                message.put("content", "未能找到该座位");
                response.put("message", message);
            }
        } catch (Exception e) {
            response.put("code", 0);
            JSONObject message = new JSONObject();
            message.put("content", "未能找到该座位");
            response.put("message", message);
        }

        return response;
    }
}

