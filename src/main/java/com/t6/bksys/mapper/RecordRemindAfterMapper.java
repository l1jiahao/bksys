package com.t6.bksys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RecordRemindAfterMapper {

    @Select("SELECT user.email FROM user,record WHERE record.user_id = user.user_id " +
            "AND (TIMESTAMPDIFF(MINUTE, record.start_time,NOW()) BETWEEN 9 AND 11) AND record.status_id = 1")
    List<String> getRecordsWithinTimeRangeAfter();

    @Update("UPDATE record SET status_id = 3 WHERE record_id IN (" +
            "SELECT r.record_id FROM (SELECT record.record_id FROM record WHERE " +
            "(TIMESTAMPDIFF(MINUTE, record.start_time, NOW()) BETWEEN 9 AND 11) AND record.status_id = 1) r)")
    void updateRecordsStatusToThree();


}
