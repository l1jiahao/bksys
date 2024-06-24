package com.t6.bksys.mapper;

import com.t6.bksys.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookGetAllMapper {

    @Select("SELECT * FROM record")
    List<Record> getAllRecords();
}
