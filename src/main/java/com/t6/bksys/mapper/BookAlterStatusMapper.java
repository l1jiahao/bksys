package com.t6.bksys.mapper;

import com.t6.bksys.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BookAlterStatusMapper {

    @Select("SELECT * FROM record WHERE record_id = #{recordId}")
    Record getRecordById(@Param("recordId") Long recordId);

    @Update("UPDATE record SET status_id = #{statusId} WHERE record_id = #{recordId}")
    int updateStatusById(@Param("recordId") Long recordId, @Param("statusId") Integer statusId);
}
