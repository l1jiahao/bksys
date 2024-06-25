package com.t6.bksys;

import com.t6.bksys.service.MailUtil;
import com.t6.bksys.service.RecordRemindAfterService;
import com.t6.bksys.service.RecordRemindBeforeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class SendbeforeEmail {
    private RecordRemindBeforeService recordRemindBeforeService;

    @Autowired
    private MailUtil mailUtil;
    private static final Logger logger = LoggerFactory.getLogger(SendbeforeEmail.class);
    @Autowired
    public SendbeforeEmail(RecordRemindBeforeService recordRemindBeforeService){
        this.recordRemindBeforeService = recordRemindBeforeService;
    }
    @Scheduled(fixedDelay=60*60*60) // 每天每个整点执行
    public void SendEmail() {
        logger.info(" SendEmail" );
        List<String> emails = recordRemindBeforeService.getremindRecord();
        emails.forEach(email -> {
            try {
                mailUtil.sendSimpleMail(email, "预约座位提醒", "您好，您好，您预约的座位将在15分钟后到预约时间，请您尽快签到");
                logger.info("邮件成功发送到：" + email);
            } catch (Exception e) {
                logger.error("发送邮件到 " + email + " 时发生错误", e);
            }
        });
    }

}