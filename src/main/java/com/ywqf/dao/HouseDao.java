package com.ywqf.dao;


import java.util.List;

import com.ywqf.entity.CompanyAndCommunity;
import org.apache.ibatis.annotations.Param;

import com.ywqf.entity.HouseInfo;

public interface HouseDao {
    /*查询公司*/
    public  CompanyAndCommunity findCompanyById(int id);
    /*查询公司通过类型*/
    public  List<CompanyAndCommunity> findCompanyByType();
    /*查询小区*/
    public  List<CompanyAndCommunity> findCommunityById(int id);
    /*查询小区*/
    public  List<CompanyAndCommunity> findCommunityByCorp(int id);
	/*查询列表*/
    public  List<HouseInfo> findHouseInfo(@Param("offset")int offset,@Param("rows")int rows,@Param("community_id") int community_id,@Param("corp_id") int corp_id);
    /*数量*/
    public int findHouseCount(int community_id);
    /*户型*/
    public List<HouseInfo> findRoomType();
    /*小区*/
    public List<HouseInfo> findCommunityName(@Param("corp_id")int corp_id);
    /*保存*/
    public int saveHouseInfo(@Param("community_id") int community_id,@Param("building") String building,@Param("unit") String unit,@Param("floor") String floor,@Param("room_num") String room_num,@Param("house_type_id") int house_type_id,@Param("area") double area,@Param("previous_estate_unit_price") double previous_estate_unit_price,@Param("previous_estate_fee") double previous_estate_fee,@Param("owner_name") String owner_name,@Param("owner_tel") String owner_tel,@Param("owner_standby_tel") String owner_standby_tel,@Param("family_size") int family_size,@Param("house_num")String house_num);
    /*通过ID查看详细信息*/
    public  HouseInfo findHouseInfoByID(@Param("id")int id);

    /*保存修改*/
    public int editHouseInfo(@Param("community_id") int community_id,@Param("building") String building,@Param("unit") String unit,@Param("floor") String floor,@Param("room_num") String room_num,@Param("house_type_id") int house_type_id,@Param("area") double area,@Param("previous_estate_unit_price") double previous_estate_unit_price,@Param("previous_estate_fee") double previous_estate_fee,@Param("owner_name") String owner_name,@Param("owner_tel") String owner_tel,@Param("owner_standby_tel") String owner_standby_tel,@Param("family_size") int family_size,@Param("house_num")String house_num,@Param("id")int id);

    /*删除*/
    public  int deleteHouseInfo(int id);

}
