package com.t6.bksys.entity;

public class Address {
    private String building;
    private int floor;
    private int addressId;

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }


    public int getAddress_id() {
        return addressId;
    }

    public void setAddress_id(int addressId) {
        this.addressId = addressId;
    }
}
