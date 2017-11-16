package com.ywqf.dao;

import com.ywqf.entity.HeatingPrefeTreat;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface HeatingPrefeTreatDao {
    /**
     * 查询采暖优惠政策
     * @param community_id
     * @return
     */
    public List<HeatingPrefeTreat> findListHeatingPrefeTreat(@Param("community_id") int community_id);

    /**
     * 添加采暖优惠政策
     * @param community_id
     * @param discount_start_date
     * @param discount_end_date
     * @param rate
     * @return
     */
    public int addHeatingPrefeTreat(@Param("community_id") int community_id,
                                    @Param("discount_start_date") String discount_start_date,
                                    @Param("discount_end_date") String discount_end_date,
                                    @Param("rate") double rate);
}
