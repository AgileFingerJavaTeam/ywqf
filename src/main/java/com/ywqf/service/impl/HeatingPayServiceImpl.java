package com.ywqf.service.impl;

import com.ywqf.base.BaseException;
import com.ywqf.dao.HeatingPayDao;
import com.ywqf.dto.excution.HeatingPayExcution;
import com.ywqf.dto.in.HeatingPayDto;
import com.ywqf.entity.EstatePay;
import com.ywqf.entity.HeatingPay;
import com.ywqf.enums.HeatingPayEnum;
import com.ywqf.service.HeatingPayService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class HeatingPayServiceImpl implements HeatingPayService {
    private org.slf4j.Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private HeatingPayDao heatingPayDao;
    @Override
    public HeatingPayExcution findHeatingPayInfo(HeatingPayDto heatingPayDto) {
        int page = 1;
        int rows = 20;
        int corpId = heatingPayDto.getCorpId();
        int communityId = heatingPayDto.getCommunityId();
        String search = heatingPayDto.getSearch();
        String date = heatingPayDto.getDate();
        try {
            int offset = (page - 1) * rows;
            List<HeatingPay> heatingPayList = heatingPayDao.findHeatingPayInfo(offset,rows,corpId,communityId,date,search);
            for(int i = 0;i<heatingPayList.size();i++){
                HeatingPay heatingPay = heatingPayList.get(i);
                //--截取缴费时间
                String payDate = heatingPay.getPaymentDate();
                String payDate1 = payDate.substring(0,10);
                heatingPay.setPaymentDate(payDate1);
                //--截取操作时间
                String operateTime = heatingPay.getOperateTime();
                String operateTime1 = operateTime.substring(0,10);
                heatingPay.setOperateTime(operateTime1);
            }
            String amount = heatingPayDao.findHeatingPayTotal(offset,rows,corpId,communityId,date,search);
            HashMap map = new HashMap();
            map.put("data",heatingPayList);
            map.put("amount",amount);
            return new HeatingPayExcution(HeatingPayEnum.FIND_SUCCESS,map);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
