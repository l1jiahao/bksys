package com.t6.bksys.mapper;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Mapper
public interface BookMapper {

    @Select("SELECT room_id FROM seat WHERE seat_id = #{seatId}")
    Integer getRoomIdBySeatId(@Param("seatId") Long seatId);

    @Select("SELECT status_id FROM classroom WHERE room_id = #{roomId}")
    Integer getStatusIdByRoomId(@Param("roomId") Integer roomId);

    @Select("SELECT * FROM record WHERE seat_id = #{seatId} AND status_id NOT IN (3, 4)")
    List<JSONObject> getRecordsBySeatId(@Param("seatId") Long seatId);

    @Insert("INSERT INTO record (seat_id, user_id, start_time, end_time, status_id) VALUES (#{seatId}, #{userId}, #{startTime}, #{endTime}, #{statusId})")
    void createRecord(@Param("seatId") Long seatId, @Param("userId") Long userId, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime, @Param("statusId") Integer statusId);

    @Select("SELECT open_time, close_time FROM classroom WHERE room_id = #{roomId}")
    ClassroomTime getClassroomTimeByRoomId(@Param("roomId") Integer roomId);

    class ClassroomTime {
        private LocalTime openTime;
        private LocalTime closeTime;

        // Getters and Setters
        public LocalTime getOpenTime() {
            return openTime;
        }

        public void setOpenTime(LocalTime openTime) {
            this.openTime = openTime;
        }

        public LocalTime getCloseTime() {
            return closeTime;
        }

        public void setCloseTime(LocalTime closeTime) {
            this.closeTime = closeTime;
        }
    }
}
