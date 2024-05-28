package com.t6.bksys.mapper;

import com.t6.bksys.entity.Classroom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface GetLocationByRecordMapper {

    @Select("SELECT seat_id FROM record WHERE record_id = #{recordId}")
    Integer getSeatIdByRecordId(@Param("recordId") Integer recordId);

    @Select("SELECT room_id, row_num, col_num FROM seat WHERE seat_id = #{seatId}")
    Map<String, Object> getSeatDataById(@Param("seatId") Integer seatId);

    @Select("SELECT * FROM classroom WHERE room_id = #{roomId}")
    @Results({
            @Result(property = "roomId", column = "room_id"),
            @Result(property = "address_id", column = "address_id"), // 保持与 Classroom 类字段一致
            @Result(property = "roomName", column = "room_name"),
            @Result(property = "rowCount", column = "row_count"),
            @Result(property = "colCount", column = "col_count"),
            @Result(property = "openTime", column = "open_time"),
            @Result(property = "closeTime", column = "close_time"),
            @Result(property = "statusId", column = "status_id")
    })
    Classroom getClassroomById(@Param("roomId") Integer roomId);

    @Select("SELECT building, floor FROM address WHERE address_id = #{addressId}")
    Map<String, Object> getAddressById(@Param("addressId") Integer addressId);
}
