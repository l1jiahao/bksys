package com.t6.bksys;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class BksysApplicationTests {

    @Test
    void contextLoads() {

    }
    @Test
    void redis_test(){
        Jedis jedis = new Jedis("127.0.0.1",6379);

        // 座位ID和日期
        String seatKey = "reservation:seat_1:2024-03-26";
        String seatKeys = "seat_id():time(xxxx-xx-xx)";

        // 将9点到10点的时间段标记为已预约
        // 使用位图表示每个小时的预约状态，这里示例仅考虑24小时
        jedis.setbit(seatKey, 9, true);

        // 检查某个时间段是否已被预约
        boolean isBooked = jedis.getbit(seatKey, 9);
        System.out.println("9点到10点是否已预约: " + isBooked);

        // 关闭连接
        jedis.close();
    }

}
