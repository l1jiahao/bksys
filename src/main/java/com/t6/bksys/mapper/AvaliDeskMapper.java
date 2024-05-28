package com.t6.bksys.mapper;

import com.t6.bksys.entity.Record;
import com.t6.bksys.entity.Seat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AvaliDeskMapper {

    @Select("SELECT * FROM seat WHERE room_id = #{roomId}")
    List<Seat> getSeatsByRoomId(@Param("roomId") Integer roomId);

    @Select("SELECT * FROM record WHERE seat_id = #{seatId} AND " +
            "(start_time < #{endTime} AND end_time > #{startTime}) AND status_id IN (1, 2)")
    List<Record> getRecordsBySeatIdAndTime(@Param("seatId") Long seatId,
                                           @Param("startTime") String startTime,
                                           @Param("endTime") String endTime);
}