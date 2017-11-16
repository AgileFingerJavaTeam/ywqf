package com.ywqf.dao;

import com.ywqf.dto.in.EstatePayDto;
import com.ywqf.entity.Community;
import com.ywqf.entity.Corps;
import com.ywqf.entity.EstatePay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EstatePayDao {
    /**
     * 查询当日缴费信息
     * @param offset
     * @param rows
     * @param corpId
     * @param communityId
     * @param date
     * @param search
     * @return
     */
    public List<EstatePay> findEstatePayInfo(@Param("offset") int offset,
                                             @Param("rows") int rows,
                                             @Param("corpId") int corpId,
                                             @Param("communityId") int communityId,
                                             @Param("date") String date,
                                             @Param("search") String search);

    public int findTodayEstatePayCount(@Param("offset") int offset,
                                       @Param("rows") int rows,
                                       @Param("corpId") int corpId,
                                       @Param("communityId") int communityId,
                                       @Param("date") String date,
                                       @Param("search") String search);

    /**
     *查询当日缴费总计
     * @param offset
     * @param rows
     * @param corpId
     * @param communityId
     * @param date
     * @param search
     * @return
     */
    public String findEstatePayTotal(@Param("offset") int offset,
                                     @Param("rows") int rows,
                                     @Param("corpId") int corpId,
                                     @Param("communityId") int communityId,
                                     @Param("date") String date,
                                     @Param("search") String search);

    /**
     * 查询当前物业公司管理的所有小区
     * @return
     */
    public List<Community> findAllCommunityByCorpId(@Param("corpId") int corpId);
    /**
     * 查询当前登录员工管理的所有小区
     * @param userId
     * @return
     */
    public List<Community> findUserManagedCommunityByUseId(@Param("userId") int userId);
    /**
     * 查询登录用户所属物业公司
     * @return
     */
    public Corps findCorpsByUserId(@Param("userId")int userId);
    /**
     * 查询所有物业公司信息
     * @return
     */
    public List<Corps> findCorpsInfo();

    /**
     * 查询登录员工类型
     * @param userId
     * @return
     */
    public String findUserType(@Param("userId")int userId);
    //---石匡代码
    public List<EstatePay> queryEstatePayList(@Param("year")int year,@Param("month")int month,@Param("check")int check);

    public int queryEstatePayCount(@Param("year")int year,@Param("month")int month,@Param("check")int check);


}
