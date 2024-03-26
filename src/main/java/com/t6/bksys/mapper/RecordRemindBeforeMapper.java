package com.t6.bksys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordRemindBeforeMapper {
    @Select("SELECT user.email FROM user,record WHERE record.user_id = user.user_id AND TIMESTAMPDIFF(MINUTE, NOW(),record.start_time) BETWEEN 14 AND 16")
    List<String> getRecordsWithinTimeRangeBefore();
}


