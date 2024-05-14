package com.t6.bksys.mapper;

import com.t6.bksys.entity.Classroom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ClassroomTimeMapper {

    @Update("UPDATE classroom SET open_time = #{classroom.openTime}, close_time = #{classroom.closeTime} WHERE room_id = #{classroom.roomId}")
    void updateClassroomTime(@Param("classroom") Classroom classroom);
}
