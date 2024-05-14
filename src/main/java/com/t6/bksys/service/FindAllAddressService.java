package com.t6.bksys.service;

import com.t6.bksys.entity.Address;
import com.t6.bksys.mapper.FindAllAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllAddressService {

    private final FindAllAddressMapper findAllAddressMapper;

    @Autowired
    public FindAllAddressService(FindAllAddressMapper findAllAddressMapper) {
        this.findAllAddressMapper = findAllAddressMapper;
    }

    public List<Address> findAllAddresses() {
        return findAllAddressMapper.findAllAddresses();
    }
}
