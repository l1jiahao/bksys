package com.t6.bksys.service;

import com.t6.bksys.entity.Classroom;
import com.t6.bksys.mapper.InsertClassroomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertClassroomService {
    private final InsertClassroomMapper insertClassroomMapper;

    @Autowired
    public InsertClassroomService(InsertClassroomMapper insertClassroomMapper) {
        this.insertClassroomMapper = insertClassroomMapper;
    }

    public void addClassroom(Classroom classroom) {
        insertClassroomMapper.insertClassroom(classroom);
    }
}
