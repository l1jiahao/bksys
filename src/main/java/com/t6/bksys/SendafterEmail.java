package com.t6.bksys;

import com.t6.bksys.service.MailUtil;
import com.t6.bksys.service.RecordRemindAfterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

@Component
public class SendafterEmail {
    private RecordRemindAfterService recordRemindAfterService;
    private static final Logger logger = LoggerFactory.getLogger(SendafterEmail.class);

    @Autowired
    private MailUtil mailUtil;

    @Autowired
    public SendafterEmail(RecordRemindAfterService recordRemindAfterService){
        this.recordRemindAfterService = recordRemindAfterService;
    }
    @Scheduled(fixedDelay=60*60*30) // 每天每个整点执行
    public void SendEmail() {
        logger.info(" SendEmail" );
        List<String> emails = recordRemindAfterService.getremindRecord();
        emails.forEach(email -> {
            try {
                mailUtil.sendSimpleMail(email, "预约座位提醒", "您好，您预约的座位已过期10分钟，请您尽快签到");
                logger.info("邮件成功发送到：" + email);
            } catch (Exception e) {
                logger.error("发送邮件到 " + email + " 时发生错误", e);
            }
        });
    }


}
