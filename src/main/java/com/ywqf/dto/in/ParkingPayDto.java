package com.ywqf.dto.in;

public class ParkingPayDto {
    private String date;
    private String search;
    private int parkingNum;
    private int corpId;
    private int communityId;
    private int year;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getParkingNum() {
        return parkingNum;
    }

    public void setParkingNum(int parkingNum) {
        this.parkingNum = parkingNum;
    }

    public int getCorpId() {
        return corpId;
    }

    public void setCorpId(int corpId) {
        this.corpId = corpId;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "ParkingPayDto{" +
                "parkingNum=" + parkingNum +
                ", corpId=" + corpId +
                ", communityId=" + communityId +
                ", year=" + year +
                '}';
    }
}
