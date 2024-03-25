package com.t6.bksys.service;

import com.t6.bksys.mapper.ClassroomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    private final ClassroomMapper classroomMapper;

    @Autowired
    public ClassroomService(ClassroomMapper classroomMapper) {
        this.classroomMapper = classroomMapper;
    }

    public List<Integer> getAllRoomIds() {
        return classroomMapper.getAllRoomIds();
    }
}
