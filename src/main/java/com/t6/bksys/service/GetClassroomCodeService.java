package com.t6.bksys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class GetClassroomCodeService {

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public GetClassroomCodeService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public String getCheckCode(Integer roomId) {
        return stringRedisTemplate.opsForValue().get("room_id:" + roomId);
    }
}
