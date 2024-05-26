package com.t6.bksys.mapper;

import com.t6.bksys.entity.Classroom;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FindClassroomMapper {
    @Select("SELECT * FROM classroom")
    @Results({
            @Result(column = "room_id", property = "roomId"),
            @Result(column = "address_id", property = "address_id"),
            @Result(column = "room_name", property = "roomName"),
            @Result(column = "row_count", property = "rowCount"),
            @Result(column = "col_count", property = "colCount"),
            @Result(column = "open_time", property = "openTime"),
            @Result(column = "close_time", property = "closeTime"),
            @Result(column = "status_id", property = "statusId")
    })
    List<Classroom> findAll();
}
