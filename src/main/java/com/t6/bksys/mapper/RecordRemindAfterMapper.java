package com.t6.bksys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordRemindAfterMapper {
    @Select("SELECT record_id FROM record WHERE (TIMESTAMPDIFF(MINUTE, NOW(), start_time) BETWEEN 14 AND 16) AND status_id = 1")
    List<Integer> getRecordsWithinTimeRangeAfter();
}
