package com.t6.bksys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordRemindBeforeMapper {
    @Select("SELECT record_id FROM record WHERE TIMESTAMPDIFF(MINUTE, start_time, NOW()) BETWEEN 9 AND 11 ")
    List<Integer> getRecordsWithinTimeRangeBefore();
}


