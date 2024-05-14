package com.t6.bksys.service;

import com.t6.bksys.mapper.AlterStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlterStatusService {

    private final AlterStatusMapper alterStatusMapper;

    @Autowired
    public AlterStatusService(AlterStatusMapper alterStatusMapper) {
        this.alterStatusMapper = alterStatusMapper;
    }

    public boolean updateStatus(Integer roomId, Integer statusId) {
        return alterStatusMapper.updateStatus(roomId, statusId) > 0;
    }
}
