package com.t6.bksys.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SeatMapper {
    @Insert("INSERT INTO seat(room_id, bonus_id, row_num, col_num) VALUES(#{roomId}, #{bonusId}, #{rowNum}, #{colNum})")
    void insertSeat(@Param("roomId") Integer roomId, @Param("bonusId") Integer bonusId, @Param("rowNum") Integer rowNum, @Param("colNum") Integer colNum);
}
