package com.t6.bksys.service;

import com.t6.bksys.mapper.BookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class ScheduledTaskService {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTaskService.class);

    private final TaskScheduler taskScheduler;
    private final BookMapper bookMapper;

    @Autowired
    public ScheduledTaskService(TaskScheduler taskScheduler, BookMapper bookMapper) {
        this.taskScheduler = taskScheduler;
        this.bookMapper = bookMapper;
    }

    public void scheduleStatusCheck(Long recordId, LocalDateTime startTime) {
        LocalDateTime checkTime = startTime.plusMinutes(15);
        Date checkDate = Date.from(checkTime.atZone(ZoneId.systemDefault()).toInstant());

        logger.info("Scheduling status check for record ID: {} at {}", recordId, checkDate);

        taskScheduler.schedule(() -> checkAndUpdateStatus(recordId), checkDate);
    }

    private void checkAndUpdateStatus(Long recordId) {
        logger.info("Checking status for record ID: {}", recordId);

        Integer statusId = bookMapper.getStatusIdByRecordId(recordId);
        if (statusId != null && statusId == 1) {
            logger.info("Updating status to 3 for record ID: {}", recordId);
            bookMapper.updateStatusId(recordId, 3);
        }
    }
}
