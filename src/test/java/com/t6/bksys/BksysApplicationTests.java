package com.t6.bksys;


import com.t6.bksys.service.MailUtil;
import com.t6.bksys.service.RecordRemindAfterService;
import com.t6.bksys.service.RecordSearchService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import com.t6.bksys.mapper.RecordRemindBeforeMapper;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
class BksysApplicationTests {
    @Autowired
    private MailUtil mailUtil;

    @Autowired
    private RecordRemindBeforeMapper recordRemindBeforeMapper;

    @Autowired
    private RecordSearchService recordSearchService;

    private RecordRemindAfterService recordRemindAfterService;
    private static final Logger logger = LoggerFactory.getLogger(SendafterEmail.class);
    @Autowired
    public BksysApplicationTests(RecordRemindAfterService recordRemindAfterService){
        this.recordRemindAfterService = recordRemindAfterService;
    }

    @Test
    void contextLoads() {
        List<String> emails = recordRemindAfterService.getremindRecord();
        emails.forEach(email -> {
            logger.info(email);
        });
    }
    @Test
    void redis_test(){
        List<String> emails = recordRemindBeforeMapper.getRecordsWithinTimeRangeBefore();
        emails.forEach(email->{
            logger.info(email);
            System.out.println(email);;

        });
        mailUtil.sendSimpleMail("1260239718@qq.com","here","here");
//        Jedis jedis = new Jedis("127.0.0.1",6379);
//
//        // 座位ID和日期
//        String seatKey = "reservation:seat_1:2024-03-26";
//        String seatKeys = "seat_id():time(xxxx-xx-xx)";
//
//        // 将9点到10点的时间段标记为已预约
//        // 使用位图表示每个小时的预约状态，这里示例仅考虑24小时
//        jedis.setbit(seatKey, 9, true);
//
//        // 检查某个时间段是否已被预约
//        boolean isBooked = jedis.getbit(seatKey, 9);
//        System.out.println("9点到10点是否已预约: " + isBooked);
//
//        // 关闭连接
//        jedis.close();
    }
    @Test
    void RecordSearchtest(){
        System.out.println(recordSearchService.getRecordsByUserId(4));
    }

}
