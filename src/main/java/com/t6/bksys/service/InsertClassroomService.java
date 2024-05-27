package com.t6.bksys.service;

import com.t6.bksys.entity.Classroom;
import com.t6.bksys.mapper.InsertClassroomMapper;
import com.t6.bksys.mapper.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InsertClassroomService {
    private final InsertClassroomMapper insertClassroomMapper;
    private final SeatMapper seatMapper;

    @Autowired
    public InsertClassroomService(InsertClassroomMapper insertClassroomMapper, SeatMapper seatMapper) {
        this.insertClassroomMapper = insertClassroomMapper;
        this.seatMapper = seatMapper;
    }

    @Transactional
    public void addClassroom(Classroom classroom) {
        insertClassroomMapper.insertClassroom(classroom);
        initializeSeats(classroom);
    }

    private void initializeSeats(Classroom classroom) {
        for (int row = 1; row <= classroom.getRowCount(); row++) {
            for (int col = 1; col <= classroom.getColCount(); col++) {
                seatMapper.insertSeat(classroom.getRoomId(), 3, row, col);
            }
        }
    }

    public void addSpecifiedSeat(Integer roomId, Integer rowNum, Integer colNum) {
        seatMapper.insertSeat(roomId, 3, rowNum, colNum);
    }
}
