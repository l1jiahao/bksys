package com.t6.bksys.service;

import com.t6.bksys.mapper.RecordRemindAfterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordRemindAfterService {
    private RecordRemindAfterMapper recordremindafterMapper;

    @Autowired
    public void RecordremindafterService(RecordRemindAfterMapper recordremindafterMapper){
        this.recordremindafterMapper = recordremindafterMapper;
    }

    public List<Integer> getremindRecord(){
        List<Integer>  record = recordremindafterMapper.getRecordsWithinTimeRangeAfter();
        return record;
    }
}
