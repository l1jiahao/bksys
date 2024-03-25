package com.t6.bksys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Record {
    private Integer recordId;
    private Integer seatId;
    private LocalDateTime endTime;
    private LocalDateTime startTime;
    private Integer statusid;
    private Integer userid;
}
