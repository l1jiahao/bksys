package com.t6.bksys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AlterStatusMapper {

    @Update("UPDATE classroom SET status_id = #{statusId} WHERE room_id = #{roomId}")
    int updateStatus(@Param("roomId") Integer roomId, @Param("statusId") Integer statusId);
}
