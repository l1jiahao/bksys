package com.t6.bksys.service;

import com.t6.bksys.entity.Classroom;
import com.t6.bksys.mapper.GetLocationByRecordMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GetLocationByRecordService {

    private final GetLocationByRecordMapper locationMapper;
    private static final Logger logger = LoggerFactory.getLogger(GetLocationByRecordService.class);

    @Autowired
    public GetLocationByRecordService(GetLocationByRecordMapper locationMapper) {
        this.locationMapper = locationMapper;
    }

    public Map<String, Object> getLocationByRecordId(Integer recordId) {
        logger.info("Received recordId: {}", recordId);

        Integer seatId = locationMapper.getSeatIdByRecordId(recordId);
        logger.info("seatId: {}", seatId);
        if (seatId == null) {
            logger.warn("记录未找到: 无 seatId for recordId = {}", recordId);
            return null;
        }

        Map<String, Object> seatData = locationMapper.getSeatDataById(seatId);
        logger.info("seatData: {}", seatData);
        if (seatData == null) {
            logger.warn("记录未找到: 无 seatData for seatId = {}", seatId);
            return null;
        }

        Integer roomId = (Integer) seatData.get("room_id");
        Integer rowNum = (Integer) seatData.get("row_num");
        Integer colNum = (Integer) seatData.get("col_num");
        logger.info("roomId: {}, rowNum: {}, colNum: {}", roomId, rowNum, colNum);

        Classroom classroom = locationMapper.getClassroomById(roomId);
        logger.info("classroom: {}", classroom);
        if (classroom == null) {
            logger.warn("记录未找到: 无 classroom for roomId = {}", roomId);
            return null;
        }

        Map<String, Object> addressData = locationMapper.getAddressById(classroom.getaddress_id());
        logger.info("addressData: {}", addressData);
        if (addressData == null) {
            logger.warn("记录未找到: 无 addressData for address_id = {}", classroom.getaddress_id());
            return null;
        }

        Map<String, Object> locationData = new HashMap<>();
        locationData.put("room_id", roomId);
        locationData.put("address_id", classroom.getaddress_id());
        locationData.put("building", addressData.get("building"));
        locationData.put("floor", addressData.get("floor"));
        locationData.put("room_name", classroom.getRoomName());
        locationData.put("row_num", rowNum);
        locationData.put("col_num", colNum);

        logger.info("locationData: {}", locationData);
        return locationData;
    }
}
