package com.t6.bksys.service;

import com.t6.bksys.entity.Address;
import com.t6.bksys.mapper.InsertFloorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertFloorService {

    private final InsertFloorMapper insertFloorMapper;

    @Autowired
    public InsertFloorService(InsertFloorMapper insertFloorMapper) {
        this.insertFloorMapper = insertFloorMapper;
    }

    public void addAddress(Address address) {
        insertFloorMapper.insertAddress(address);
    }
}
