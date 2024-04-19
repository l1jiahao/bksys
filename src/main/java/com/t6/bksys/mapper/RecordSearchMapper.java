package com.t6.bksys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import com.t6.bksys.entity.Record;

@Mapper
public interface RecordSearchMapper {
    @Select("SELECT record.record_id, record.seat_id, record.start_time, record.end_time, record.status_id, record.user_id " +
            "FROM record WHERE record.user_id = #{userId}")
    List<Record> getRecordsByUserId(@Param("userId") Integer userId);
}
