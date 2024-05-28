package com.t6.bksys;

import com.t6.bksys.service.ClassroomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Random;

@Component
public class GenerateClassroomcode {

    private final ClassroomService classroomService;
    private final StringRedisTemplate stringRedisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(GenerateClassroomcode.class);

    //定时任务一 ： 每小时生成每个教室的随机码
    @Autowired
    public GenerateClassroomcode(ClassroomService classroomService, StringRedisTemplate stringRedisTemplate) {
        this.classroomService = classroomService;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Scheduled(fixedDelay=60*60*1000)
    public void updateRoomIdKeys() {
        List<Integer> roomIds = classroomService.getAllRoomIds();
        roomIds.forEach(roomId -> {
            int randomNumber = new Random().nextInt(900000) + 100000;
            logger.info("roomId:"+roomId+"更新签到码为"+randomNumber);
            stringRedisTemplate.opsForValue().set("room_id:" + roomId, String.valueOf(randomNumber));

        });
    }
}
