package com.t6.bksys.service;

import com.t6.bksys.entity.Record;
import com.t6.bksys.entity.Seat;
import com.t6.bksys.mapper.ClassroomCodeMapper;
import com.t6.bksys.SendafterEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClassroomCodeService {

    private final StringRedisTemplate stringRedisTemplate;
    private final ClassroomCodeMapper classroomCodeMapper;
    private static final Logger logger = LoggerFactory.getLogger(SendafterEmail.class);

    @Autowired
    public ClassroomCodeService(StringRedisTemplate stringRedisTemplate, ClassroomCodeMapper classroomCodeMapper) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.classroomCodeMapper = classroomCodeMapper;
    }

    public boolean checkClassroomCode(Integer recordId, String checkCode) {
        Record record = classroomCodeMapper.findRecordById(recordId);
        if (record == null) {
            logger.info("Record not found for record_id: " + recordId);
            return false;
        }

        Seat seat = classroomCodeMapper.findSeatById(record.getSeatId());
        if (seat == null) {
            logger.info("Seat not found for seat_id: " + record.getSeatId());
            return false;
        }

        Integer roomId = seat.getRoomId();
        String storedCode = stringRedisTemplate.opsForValue().get("room_id:" + roomId);
        logger.info("此时正确的签到码为：{}", storedCode);

        if (checkCode.equals(storedCode)) {
            if (record.getStatusid() == 1 || record.getStatusid() == 2) {
                classroomCodeMapper.updateRecordStatus(recordId, 2);
            }
            return true;
        } else if (record.getStatusid() == 3 || record.getStatusid() == 4) {
            return false;
        }
        return false;
    }
}
