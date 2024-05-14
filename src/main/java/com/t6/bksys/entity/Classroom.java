package com.t6.bksys.entity;

import java.time.LocalTime;

public class Classroom {
    private Integer roomId;    // 主键，自增
    private Integer address_id; // 地址ID
    private String roomName;   // 教室名称
    private Integer rowCount;  // 行数
    private Integer colCount;  // 列数
    private LocalTime openTime = LocalTime.of(9, 0);   // 开放时间，默认为09:00
    private LocalTime closeTime = LocalTime.of(22, 0); // 关闭时间，默认为22:00
    private Integer statusId = 1;                      // 状态ID，默认为1

    // Getter和Setter
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getaddress_id() {
        return address_id;
    }

    public void setaddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getColCount() {
        return colCount;
    }

    public void setColCount(Integer colCount) {
        this.colCount = colCount;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "roomId=" + roomId +
                ", address_id=" + address_id +
                ", roomName='" + roomName + '\'' +
                ", rowCount=" + rowCount +
                ", colCount=" + colCount +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", statusId=" + statusId +
                '}';
    }
}
