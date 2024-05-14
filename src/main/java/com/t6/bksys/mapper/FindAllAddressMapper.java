package com.t6.bksys.mapper;

import com.t6.bksys.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FindAllAddressMapper {

    @Select("SELECT * FROM address")
    List<Address> findAllAddresses();
}
