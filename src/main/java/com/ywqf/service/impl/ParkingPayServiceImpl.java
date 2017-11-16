package com.ywqf.service.impl;
import com.ywqf.base.BaseException;
import com.ywqf.dao.ParkingPayDao;
import com.ywqf.dto.excution.ParkingPayExcution;
import com.ywqf.dto.in.ParkingPayDto;
import com.ywqf.entity.Community;
import com.ywqf.entity.ParkingPay;
import com.ywqf.entity.ParkingStatus;
import com.ywqf.entity.PropertyCompany;
import com.ywqf.enums.CompanyInforEnum;
import com.ywqf.service.ParkingPayService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParkingPayServiceImpl implements ParkingPayService {
    //日志对象
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ParkingPayDao parkingPayDao;

    /**
     * 查询车位缴费当日信息
     * @param parkingPayDto
     * @return
     */
    @Override
    public ParkingPayExcution findParkingPayInfo(ParkingPayDto parkingPayDto){
        int page = 1;
        int rows = 20;
        int corpId = parkingPayDto.getCorpId();
        int communityId = parkingPayDto.getCommunityId();
        String search = parkingPayDto.getSearch();
        String date = parkingPayDto.getDate();
        try {
            int offset = (page - 1) * rows;
            List<ParkingPay> parkingPayList = parkingPayDao.findParkingPayInfo(offset,rows,corpId,communityId,date,search);
            for(int i = 0;i<parkingPayList.size();i++){
                ParkingPay parkingPay = parkingPayList.get(i);
                //--截取开始时间
                String serviceStartDate = parkingPay.getServiceStartDate();
                String serviceStartDate1 = serviceStartDate.substring(0,10);
                parkingPay.setServiceStartDate(serviceStartDate1);
                //--截取结束时间
                String serviceEndDate = parkingPay.getServiceEndDate();
                String serviceEndDate1 = serviceEndDate.substring(0,10);
                parkingPay.setServiceEndDate(serviceEndDate1);
                //--截取缴费时间
                String payDate = parkingPay.getPayDate();
                String payDate1 = payDate.substring(0,10);
                parkingPay.setPayDate(payDate1);
                //--截取操作时间
                String operateTime = parkingPay.getOperateTime();
                String operateTime1 = operateTime.substring(0,10);
                parkingPay.setOperateTime(operateTime1);
            }
            String amount = parkingPayDao.findParkingPayTotal(offset,rows,corpId,communityId,date,search);//查询当日缴费总计
            HashMap map = new HashMap();
            map.put("data",parkingPayList);
            map.put("amount",amount);
            return new ParkingPayExcution(CompanyInforEnum.FIND_SUCCESS, map);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }


    //郭阳
    /**
     * 查询物业公司
     * @return
     */
    @Override
    public ParkingPayExcution findPayCost() {
        /*HttpSession session = this.getRequest().getSession();
		int corp_id = (int) session.getAttribute("corp_id");*/
        int corp_id = 1000 ;
        try{
            PropertyCompany findPropertyCompany = parkingPayDao.findPropertyCompany(corp_id);//查询所属物业公司
            if (findPropertyCompany == null){
                return new ParkingPayExcution(CompanyInforEnum.FIND_ERROR);
            }
            return new ParkingPayExcution(CompanyInforEnum.FIND_SUCCESS, findPropertyCompany);
        }catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 查询所属小区
     * @return
     */
    @Override
    public ParkingPayExcution findListCommunity() {
        /*HttpSession session = this.getRequest().getSession();
		int corp_id = (int) session.getAttribute("corp_id");*/
        int corp_id = 1000;
        try{
            List<Community> findListCommunity = parkingPayDao.findListCommunity(corp_id);//查询所属物业公司
            if (findListCommunity == null){
                return new ParkingPayExcution(CompanyInforEnum.FIND_ERROR);
            }
            return new ParkingPayExcution(CompanyInforEnum.FIND_SUCCESS, findListCommunity);
        }catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 查询业主信息和车位缴费状态
     * @param parkingPayDto
     * @return
     */
    @Override
    public ParkingPayExcution findParkingPay(ParkingPayDto parkingPayDto) {
        int parking_num = parkingPayDto.getParkingNum();
        int community_id = parkingPayDto.getCommunityId();
        int year = parkingPayDto.getYear();
        try{
            String findParkingNum = parkingPayDao.findParkingNum(parking_num);
            if (findParkingNum == null){
                return new ParkingPayExcution(CompanyInforEnum.FIND_ERROR);
            }
            ParkingPay findParkingPay = parkingPayDao.findParkingPay(parking_num, community_id);
            List<ParkingStatus> findParkingStatus = parkingPayDao.findParkingStatus(parking_num,community_id,year);
            if (findParkingPay == null || findParkingStatus == null){
                return new ParkingPayExcution(CompanyInforEnum.FIND_ERROR);
            }
            Map map = new HashMap();
            map.put("findParkingPay", findParkingPay);
            map.put("findParkingStatus", findParkingStatus);
            return new ParkingPayExcution(CompanyInforEnum.FIND_SUCCESS, map);
        }catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 得到request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
}

