package com.ywqf.dao;


import com.ywqf.entity.HouseAsk;
import com.ywqf.entity.RentAndSale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseCenterDao {
    /*查询求租求购列表*/
    public  List<HouseAsk> findHouseAsk(@Param("community_id") int community_id, @Param("corp_id") int corp_id,@Param("type")int type);
    /*查询需求*/
    public List<HouseAsk> findAskType();
    /*查询户型*/
    public List<HouseAsk> findHouseType();
    /*查询朝向*/
    public List<HouseAsk> findDirection();
    /*查询面积*/
    public List<HouseAsk> findArea();
    /*查询装修情况*/
    public List<HouseAsk> findFitment();
    /*查询租价*/
    public List<HouseAsk> findRentPrice();
    /*查询售价*/
    public List<HouseAsk> findBuyPrice();
    /*添加数据*/
    public int addData(@Param("corp_id")int corp_id,@Param("community_id")int community_id,@Param("house_need_rent_num")String house_need_rent_num,@Param("type")int type,@Param("house_type_id")int house_type_id,@Param("rent_house_price_range_id")int rent_house_price_range_id,@Param("buy_house_price_range_id")int buy_house_price_range_id,@Param("house_direction_type_id")int house_direction_type_id,@Param("house_fitment_type_id")int house_fitment_type_id,@Param("house_area_type_id")int house_area_type_id,@Param("remark")String remark,@Param("customer_name")String customer_name,@Param("phone")String phone);

    /*修改数据*/
    public int editData(/*@Param("community_id")int community_id,*/@Param("house_need_rent_num")String house_need_rent_num,@Param("type")int type,@Param("house_type_id")int house_type_id,@Param("rent_house_price_range_id")int rent_house_price_range_id,@Param("buy_house_price_range_id")int buy_house_price_range_id,@Param("house_direction_type_id")int house_direction_type_id,@Param("house_fitment_type_id")int house_fitment_type_id,@Param("house_area_type_id")int house_area_type_id,@Param("remark")String remark,@Param("customer_name")String customer_name,@Param("phone")String phone,@Param("id")int id);

    /*根据ID查询详细信息*/
    public HouseAsk findAskById(int id);

    /*删除数据*/
    public int deleteData(int id);






    /*根据小区查看楼号*/
    public  List<RentAndSale> findBuildingById(@Param("building_id") String building_id);
    /*查询租售列表*/
    public List<RentAndSale> findRentSale();
    /*房号联想*/
    public List<RentAndSale> findHouseNum(String house_num);
}
