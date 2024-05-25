package com.t6.bksys.service;

import com.t6.bksys.SendafterEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClassroomCodeService {

    private final StringRedisTemplate stringRedisTemplate;
    private static final Logger logger = LoggerFactory.getLogger(SendafterEmail.class);
    @Autowired
    public ClassroomCodeService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public boolean checkClassroomCode(Integer roomId, String checkCode) {
        String storedCode = stringRedisTemplate.opsForValue().get("room_id:" + roomId);
        logger.info("此时正确的签到码为：",storedCode);
        return checkCode.equals(storedCode);
    }
}
