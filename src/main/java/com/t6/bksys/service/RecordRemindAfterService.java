package com.t6.bksys.service;

import com.t6.bksys.SendafterEmail;
import com.t6.bksys.mapper.RecordRemindAfterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordRemindAfterService {
    private RecordRemindAfterMapper recordremindafterMapper;
    private static final Logger logger = LoggerFactory.getLogger(SendafterEmail.class);
    @Autowired
    public void RecordremindafterService(RecordRemindAfterMapper recordremindafterMapper){
        this.recordremindafterMapper = recordremindafterMapper;
    }

    public List<String> getremindRecord(){
        List<String>  emails = recordremindafterMapper.getRecordsWithinTimeRangeAfter();
        recordremindafterMapper.updateRecordsStatusToThree();
        return emails;
    }
}
