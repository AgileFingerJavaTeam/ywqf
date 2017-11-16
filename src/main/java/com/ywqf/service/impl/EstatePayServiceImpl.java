package com.ywqf.service.impl;

import com.ywqf.base.BaseException;
import com.ywqf.dao.EstatePayDao;
import com.ywqf.dto.excution.EstatePayExcution;
import com.ywqf.dto.in.EstatePayDto;
import com.ywqf.entity.Community;
import com.ywqf.entity.Corps;
import com.ywqf.entity.EstatePay;
import com.ywqf.enums.EstatePayEnum;
import com.ywqf.service.EstatePayService;
import lombok.experimental.var;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EstatePayServiceImpl implements EstatePayService {
    private org.slf4j.Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EstatePayDao estatePayDao;

    /**
     * 查询当日物业费缴费信息（缴费详情和缴费总计）
     * @param estatePayDto
     * @return
     */
    @Override
    public EstatePayExcution findEstatePayInfo(EstatePayDto estatePayDto) {
//        int page = estatePayDto.getPage();
//        int rows = estatePayDto.getRows();
        int page = 1;
        int rows = 20;
        int corpId = estatePayDto.getCorpId();
        int communityId = estatePayDto.getCommunityId();
        String search = estatePayDto.getSearch();
        String date = estatePayDto.getDate();
        try {
            int offset = (page - 1) * rows;
            List<EstatePay> estatePayList = estatePayDao.findEstatePayInfo(offset,rows,corpId,communityId,date,search);//查询当日缴费信息详情
            for(int i = 0;i<estatePayList.size();i++){
                EstatePay estatePay = estatePayList.get(i);
                //--截取开始时间
                String serviceStartDate = estatePay.getServiceStartDate();
                String serviceStartDate1 = serviceStartDate.substring(0,10);
                estatePay.setServiceStartDate(serviceStartDate1);
                //--截取结束时间
                String serviceEndDate = estatePay.getServiceEndDate();
                String serviceEndDate1 = serviceEndDate.substring(0,10);
                estatePay.setServiceEndDate(serviceEndDate1);
                //--截取缴费时间
                String payDate = estatePay.getPayDate();
                String payDate1 = payDate.substring(0,10);
                estatePay.setPayDate(payDate1);
                //--截取操作时间
                String operateTime = estatePay.getOperateTime();
                String operateTime1 = operateTime.substring(0,10);
                estatePay.setOperateTime(operateTime1);
            }
//            int count = estatePayDao.findTodayEstatePayCount();
            String amount = estatePayDao.findEstatePayTotal(offset,rows,corpId,communityId,date,search);//查询当日缴费总计
            HashMap map = new HashMap();
            map.put("data",estatePayList);
//            map.put("total",count);
            map.put("amount",amount);
            return new EstatePayExcution(EstatePayEnum.FIND_ESTATE_PAY_SUCCESS,map);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
    /**
     * 查询当前物业公司管理的所有小区
     * @param estatePayDto
     * @return
     */
    @Override
    public EstatePayExcution findCorpManagedCommunity(EstatePayDto estatePayDto) {
        int cropId = estatePayDto.getCorpsId();
        try {
            List<Community> communityList = estatePayDao.findAllCommunityByCorpId(cropId);
            return new EstatePayExcution(EstatePayEnum.FIND_COMMUNITY_SUCCESS,communityList);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
    /**
     *查询当前登录员工管理的所有小区
     * @param estatePayDto
     * @return
     */
    @Override
    public EstatePayExcution findUserManagedCommunity(EstatePayDto estatePayDto) {
//        int userId = estatePayDto.getUserId();
        int userId = 1000;
        try {
            List<Community> communityList = estatePayDao.findUserManagedCommunityByUseId(userId);
            return new EstatePayExcution(EstatePayEnum.FIND_COMMUNITY_SUCCESS,communityList);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
    /**
     * 查询员工所属物业公司
     * @return
     */
    @Override
    public EstatePayExcution findUserBelongsCrop(EstatePayDto estatePayDto) {
//        int userId = estatePayDto.getUserId();
        int userId = 1000;
        try {
            Corps corp = estatePayDao.findCorpsByUserId(userId);
            return new EstatePayExcution(EstatePayEnum.FIND_CORPS_SUCCESS,corp);
        }catch (Exception e){
        logger.error(e.getMessage(),e);
        throw new BaseException(e.getMessage());
        }
    }
    /**
     * 查询所有物业公司信息
     * @return
     */
    @Override
    public EstatePayExcution findCorpsInfo() {
        try{
            List<Corps> corpsList = estatePayDao.findCorpsInfo();
            return new EstatePayExcution(EstatePayEnum.FIND_CORPS_SUCCESS,corpsList);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 查询登录员工类型
     * @param estatePayDto
     * @return
     */
    @Override
    public EstatePayExcution findUserType(EstatePayDto estatePayDto) {
//        int userId = estatePayDto.getUserId();
        int userId = 1000;
        try {
            String userType = estatePayDao.findUserType(userId);
            return new EstatePayExcution(EstatePayEnum.FIND_SUCCESS,userType);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    //----石匡代码
    @Override
    public EstatePayExcution queryEstatePay(EstatePayDto estatePayDto) {
        int check = estatePayDto.getChecked();
        String timeYearMonth = estatePayDto.getTimeYearMonth();
        String[] string = timeYearMonth.split("-");
        int year = Integer.parseInt(string[0]);
        int month = Integer.parseInt(string[1]);
        try {
            List<EstatePay> estatePayList = estatePayDao.queryEstatePayList(year, month, check);
            int total=estatePayDao.queryEstatePayCount(year, month, check);
            HashMap<String, Object> map=new HashMap<String, Object>();
            map.put("rows",estatePayList);
            map.put("total",total);
            return  new EstatePayExcution(EstatePayEnum.QUERY_SUCCESS,map);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
}
