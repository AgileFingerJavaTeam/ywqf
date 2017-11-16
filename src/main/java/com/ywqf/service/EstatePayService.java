package com.ywqf.service;

import com.ywqf.dto.excution.EstatePayExcution;
import com.ywqf.dto.in.EstatePayDto;

public interface EstatePayService {
    /**
     * 查询当日物业费信息（缴费详细信息和缴费总计）
     * @param estatePayDto
     * @return
     */
    public EstatePayExcution findEstatePayInfo(EstatePayDto estatePayDto);
    /**
     * 查询当前物业公司管理的所有小区
     * @param estatePayDto
     * @return
     */
    public EstatePayExcution findCorpManagedCommunity(EstatePayDto estatePayDto);

    /**
     *查询当前登录员工管理的所有小区
     * @param estatePayDto
     * @return
     */
    public EstatePayExcution findUserManagedCommunity(EstatePayDto estatePayDto);

    /**
     * 查询登录员工所属物业公司
     * @return
     */
    public EstatePayExcution findUserBelongsCrop(EstatePayDto estatePayDto);

    /**
     * 查询所有物业公司信息
     * @return
     */
    public EstatePayExcution findCorpsInfo();

    /**
     * 查询登陆员工类型（属于物业还是总部）
     * @return
     */
    public EstatePayExcution findUserType(EstatePayDto estatePayDto);

    //-----石匡代码
    /**
     * 查询缴费欠费记录
     * @param estatePayDto
     * @return
     */
    public EstatePayExcution queryEstatePay(EstatePayDto estatePayDto);
}
