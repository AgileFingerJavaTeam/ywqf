package com.ywqf.service;
import com.ywqf.dto.excution.ParkingPayExcution;
import com.ywqf.dto.in.ParkingPayDto;

public interface ParkingPayService {

    /**
     * 查询当日车位缴费信息(苏瑞涛)
     * @param parkingPayDto
     * @return
     */
    public ParkingPayExcution findParkingPayInfo(ParkingPayDto parkingPayDto);

    //郭阳
    /**
     * 查询物业公司
     * @return
     */
    public ParkingPayExcution findPayCost();

    /**
     * 查询所属小区
     * @return
     */
    public ParkingPayExcution findListCommunity();

    /**
     * 查询业主信息和车位缴费状态
     * @param parkingPayDto
     * @return
     */
    public ParkingPayExcution findParkingPay(ParkingPayDto parkingPayDto);
}
