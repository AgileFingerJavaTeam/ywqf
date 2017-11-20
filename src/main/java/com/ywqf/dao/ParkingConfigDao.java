package com.ywqf.dao;

import com.ywqf.entity.ParkingConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParkingConfigDao {

    /*查询列表*/
    public List<ParkingConfig> findParkingList(@Param("community_id") int community_id, @Param("corp_id") int corp_id);

    /*新增信息*/
    public  int addParkingConfig(@Param("community_id")int community_id,@Param("parking_num")int parking_num,@Param("license_plate_number")String license_plate_number,@Param("location_description")String location_description,@Param("previous_parking_unit_price")double previous_parking_unit_price,@Param("house_id")int house_id,@Param("car_owner_name")String car_owner_name,@Param("car_owner_tel")String car_owner_tel,@Param("car_owner_standby_tel")String car_owner_standby_tel,@Param("gender")int gender);

    /*门牌号联想*/
    public  ParkingConfig findHouseNum(@Param("community_id")int community_id,@Param("house_id")String house_id);

    /*根据id查询详细信息*/
    public  ParkingConfig findParkingById(@Param("row_id")int row_id);

    /*修改信息*/
    public  int editParkingConfig(@Param("community_id")int community_id,@Param("parking_num")int parking_num,@Param("license_plate_number")String license_plate_number,@Param("location_description")String location_description,@Param("previous_parking_unit_price")double previous_parking_unit_price,@Param("house_id")int house_id,@Param("car_owner_name")String car_owner_name,@Param("car_owner_tel")String car_owner_tel,@Param("car_owner_standby_tel")String car_owner_standby_tel,@Param("gender")int gender,@Param("row_id")int row_id);

    /*删除信息*/
    public  int deleteParkingConfig(@Param("row_id")int row_id);
}
