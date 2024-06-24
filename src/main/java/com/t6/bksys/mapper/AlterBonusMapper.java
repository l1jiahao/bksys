package com.t6.bksys.mapper;

import com.t6.bksys.entity.Seat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AlterBonusMapper {

    @Select("SELECT * FROM seat WHERE seat_id = #{seatId}")
    Seat getSeatById(@Param("seatId") Long seatId);

    @Update("UPDATE seat SET bonus_id = #{bonusId} WHERE seat_id = #{seatId}")
    int updateBonusId(@Param("seatId") Long seatId, @Param("bonusId") Integer bonusId);
}
