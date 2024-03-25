package com.t6.bksys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassroomMapper {
    @Select("SELECT room_id FROM classroom")
    List<Integer> getAllRoomIds();
}
