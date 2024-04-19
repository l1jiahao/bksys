package com.t6.bksys;

import com.t6.bksys.service.MailUtil;
import com.t6.bksys.service.RecordRemindAfterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class SendbeforeEmail {
    private RecordRemindAfterService recordRemindAfterService;

    @Autowired
    private MailUtil mailUtil;

    @Autowired
    public SendbeforeEmail(RecordRemindAfterService recordRemindAfterService){
        this.recordRemindAfterService = recordRemindAfterService;
    }
    @Scheduled(cron = "45 0 * * * *") // 每天每个整点执行
    public void SendEmail() {
        List<String> emails = recordRemindAfterService.getremindRecord();
        emails.forEach(email -> {
            mailUtil.sendSimpleMail(email, "预约座位提醒", "您好，您预约的座位将在15分钟后到预约时间，请您尽快签到");
        });
    }

}