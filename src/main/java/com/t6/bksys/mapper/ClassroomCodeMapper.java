package com.t6.bksys.mapper;

import com.t6.bksys.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ClassroomCodeMapper {

    @Select("SELECT * FROM record WHERE record_id = #{recordId}")
    Record findRecordById(@Param("recordId") Integer recordId);

    @Update("UPDATE record SET status_id = #{status} WHERE record_id = #{recordId}")
    void updateRecordStatus(@Param("recordId") Integer recordId, @Param("status") Integer status);
}
