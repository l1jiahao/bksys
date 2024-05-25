package com.t6.bksys.service;

import com.t6.bksys.entity.Classroom;
import com.t6.bksys.mapper.FindClassroomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.annotation.Resource;
import java.util.List;

@Service
public class FindClassroomService {

    @Resource
    private FindClassroomMapper findClassroomMapper;
    @Autowired
    public FindClassroomService(FindClassroomMapper findClassroomMapper) {
        this.findClassroomMapper = findClassroomMapper;
    }

    @Transactional
    public List<Classroom> findClassroomsByBuildingAndFloor(String building, Integer floor) {
        return findClassroomMapper.findByBuildingAndFloor(building, floor);
    }
}
