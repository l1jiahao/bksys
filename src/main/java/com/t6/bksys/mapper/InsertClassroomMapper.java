package com.t6.bksys.mapper;

import com.t6.bksys.entity.Classroom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface InsertClassroomMapper {
    @Insert("INSERT INTO classroom(address_id, room_name, row_count, col_count, open_time, close_time, status_id) " +
            "VALUES(#{address_id}, #{roomName}, #{rowCount}, #{colCount}, #{openTime}, #{closeTime}, #{statusId})")
    @Options(useGeneratedKeys = true, keyProperty = "roomId")
    void insertClassroom(Classroom classroom);
}
