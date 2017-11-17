package com.ywqf.dao;
import com.ywqf.entity.Community;
import com.ywqf.entity.ParkingPay;
import com.ywqf.entity.ParkingStatus;
import com.ywqf.entity.PropertyCompany;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParkingPayDao {
    /**
     * 查询当日停车费缴费信息
     * @return
     */
    public List<ParkingPay> findTodayParkingPay(@Param("offset") int offset, @Param("rows") int rows);
    /**
     * 查询当日停车费缴费信息条数
     * @return
     */
    public int findParkingPayCount();


    /**
     * 查询业主车位缴费状态
     * @param parking_num
     * @param corp_id
     * @param community_id
     * @param year
     * @return
     */
    public List<ParkingStatus> findParkingStatus(@Param("parking_num") int parking_num,
                                                 @Param("corp_id") int corp_id,
                                                 @Param("community_id") int community_id,
                                                 @Param("year") int year);

    /**
     * 查询当日车位缴费信息（苏瑞涛）
     * @param offset
     * @param rows
     * @param corpId
     * @param communityId
     * @param date
     * @param search
     * @return
     */
    public List<ParkingPay> findParkingPayInfo(@Param("offset") int offset,
                                               @Param("rows") int rows,
                                               @Param("corpId") int corpId,
                                               @Param("communityId") int communityId,
                                               @Param("date") String date,
                                               @Param("search") String search);

    /**
     * 查询当日车位缴费总计(苏瑞涛)
     * @param offset
     * @param rows
     * @param corpId
     * @param communityId
     * @param date
     * @param search
     * @return
     */
    public String findParkingPayTotal(@Param("offset") int offset,
                                     @Param("rows") int rows,
                                     @Param("corpId") int corpId,
                                     @Param("communityId") int communityId,
                                     @Param("date") String date,
                                     @Param("search") String search);

    //-----------郭阳代码
    /**
     * 查询所属物业公司
     * @param corp_id
     * @return
     */
    public PropertyCompany findPropertyCompany(@Param("corp_id") int corp_id);

    /**
     * 查询所属小区
     * @return
     */
    public List<Community> findListCommunity(@Param("corp_id") int corp_id);

    /**
     * 查询车位编号是否存在
     * @param parking_num
     * @return
     */
    public String findParkingNum(@Param("parking_num") int parking_num);

    /**
     * 查询车位业主信息
     * @param parking_num
     * @return
     */
    public ParkingPay findParkingPay(@Param("parking_num") int parking_num,
                                     @Param("community_id") int community_id);

    /**
     * 查询业主车位缴费状态
     * @param parking_num
     * @param year
     * @return
     */
    public List<ParkingStatus> findParkingStatus(@Param("parking_num") int parking_num,
                                                 @Param("community_id") int community_id,
                                                 @Param("year") int year);

}
