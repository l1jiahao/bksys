package com.t6.bksys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordRemindAfterMapper {

    @Select("SELECT user.email FROM user,record WHERE record.user_id = user.user_id AND (TIMESTAMPDIFF(MINUTE, record.start_time,NOW()) BETWEEN 14 AND 16) AND record.status_id = 1")
    List<String> getRecordsWithinTimeRangeAfter();


}
