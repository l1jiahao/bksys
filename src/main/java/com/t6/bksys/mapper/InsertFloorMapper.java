package com.t6.bksys.mapper;

import com.t6.bksys.entity.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InsertFloorMapper {

    @Insert("INSERT INTO address (building, floor) VALUES (#{building}, #{floor})")
    void insertAddress(Address address);
}
