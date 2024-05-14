package com.t6.bksys.service;

import com.t6.bksys.entity.Classroom;
import com.t6.bksys.mapper.ClassroomMapper;
import com.t6.bksys.mapper.ClassroomTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomTimeService {

    private final ClassroomTimeMapper classroomTimeMapper;

    @Autowired
    public ClassroomTimeService(ClassroomTimeMapper classroomTimeMapper) {
        this.classroomTimeMapper = classroomTimeMapper;
    }

    public void alterClassroomTime(Classroom classroom) {
        classroomTimeMapper.updateClassroomTime(classroom);
    }
}
