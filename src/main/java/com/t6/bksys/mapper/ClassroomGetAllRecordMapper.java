package com.t6.bksys.mapper;

import com.t6.bksys.entity.Record;
import com.t6.bksys.entity.Seat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassroomGetAllRecordMapper {

    @Select("SELECT * FROM seat")
    List<Seat> getAllSeats();

    @Select("SELECT * FROM record WHERE seat_id = #{seatId}")
    List<Record> getRecordsBySeatId(Long seatId);
}
