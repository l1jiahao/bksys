package com.t6.bksys.service;

import com.t6.bksys.mapper.RecordRemindBeforeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordRemindBeforeService {
    private RecordRemindBeforeMapper recordRemindBeforeMapper;

    @Autowired
    public RecordRemindBeforeService(RecordRemindBeforeMapper recordRemindBeforeMapper){
        this.recordRemindBeforeMapper = recordRemindBeforeMapper;
    }
    public List<String> getremindRecord(){
        List<String> emails = recordRemindBeforeMapper.getRecordsWithinTimeRangeBefore();
        return emails;
    }
}
