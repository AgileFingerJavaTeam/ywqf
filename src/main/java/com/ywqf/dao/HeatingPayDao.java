package com.ywqf.dao;

import com.ywqf.entity.HeatingPay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HeatingPayDao {
    /**
     * 查询当日采暖缴费信息
     * @param offset
     * @param rows
     * @param corpId
     * @param communityId
     * @param date
     * @param search
     * @return
     */
    public List<HeatingPay> findHeatingPayInfo(@Param("offset") int offset,
                                               @Param("rows") int rows,
                                               @Param("corpId") int corpId,
                                               @Param("communityId") int communityId,
                                               @Param("date") String date,
                                               @Param("search") String search);

    /**
     * 查询当日采暖缴费总额
     * @param offset
     * @param rows
     * @param corpId
     * @param communityId
     * @param date
     * @param search
     * @return
     */
    public String findHeatingPayTotal(@Param("offset") int offset,
                                      @Param("rows") int rows,
                                      @Param("corpId") int corpId,
                                      @Param("communityId") int communityId,
                                      @Param("date") String date,
                                      @Param("search") String search);
    public int findHeatingPayCount();
}
