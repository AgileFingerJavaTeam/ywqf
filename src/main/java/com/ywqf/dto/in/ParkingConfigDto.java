package com.ywqf.dto.in;

public class ParkingConfigDto {
        private int corp_id;
        private int community_id;
        private  int parking_num;
        private String license_plate_number;
        private String location_description;
        private double previous_parking_unit_price;
        private String room_num;
        private String house_num;
        private String car_owner_name;
        private String car_owner_tel;
        private String car_owner_standby_tel;
        private int gender;
        private int house_id;
        private  int row_id;
    public int getCorp_id() {
        return corp_id;
    }

    public void setCorp_id(int corp_id) {
        this.corp_id = corp_id;
    }

    public int getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }

    public int getParking_num() {
        return parking_num;
    }

    public void setParking_num(int parking_num) {
        this.parking_num = parking_num;
    }

    public String getLicense_plate_number() {
        return license_plate_number;
    }

    public void setLicense_plate_number(String license_plate_number) {
        this.license_plate_number = license_plate_number;
    }

    public String getLocation_description() {
        return location_description;
    }

    public void setLocation_description(String location_description) {
        this.location_description = location_description;
    }

    public double getPrevious_parking_unit_price() {
        return previous_parking_unit_price;
    }

    public void setPrevious_parking_unit_price(double previous_parking_unit_price) {
        this.previous_parking_unit_price = previous_parking_unit_price;
    }

    public String getRoom_num() {
        return room_num;
    }

    public void setRoom_num(String room_num) {
        this.room_num = room_num;
    }

    public String getCar_owner_name() {
        return car_owner_name;
    }

    public void setCar_owner_name(String car_owner_name) {
        this.car_owner_name = car_owner_name;
    }

    public String getCar_owner_tel() {
        return car_owner_tel;
    }

    public void setCar_owner_tel(String car_owner_tel) {
        this.car_owner_tel = car_owner_tel;
    }

    public String getCar_owner_standby_tel() {
        return car_owner_standby_tel;
    }

    public void setCar_owner_standby_tel(String car_owner_standby_tel) {
        this.car_owner_standby_tel = car_owner_standby_tel;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getHouse_num() {
        return house_num;
    }

    public void setHouse_num(String house_num) {
        this.house_num = house_num;
    }

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public int getRow_id() {
        return row_id;
    }

    public void setRow_id(int row_id) {
        this.row_id = row_id;
    }
}
