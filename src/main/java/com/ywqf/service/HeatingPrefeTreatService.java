package com.ywqf.service;

import com.ywqf.dto.excution.HeatingPrefeTreatExcution;
import com.ywqf.dto.in.HeatingPrefeTreatDto;

public interface HeatingPrefeTreatService {
    /**
     * 查询采暖优惠政策
     * @return
     */
    public HeatingPrefeTreatExcution findHeatingPrefeTreat();

    /**
     * 添加采暖优惠政策
     * @return
     */
    public HeatingPrefeTreatExcution addHeatingPrefeTreat(HeatingPrefeTreatDto heatingPrefeTreatDto);
}
