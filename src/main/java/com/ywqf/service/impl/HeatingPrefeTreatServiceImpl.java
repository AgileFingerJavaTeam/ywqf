package com.ywqf.service.impl;

import com.ywqf.base.BaseException;
import com.ywqf.dao.HeatingPrefeTreatDao;
import com.ywqf.dto.excution.HeatingPrefeTreatExcution;
import com.ywqf.dto.in.HeatingPrefeTreatDto;
import com.ywqf.entity.HeatingPrefeTreat;
import com.ywqf.enums.CompanyInforEnum;
import com.ywqf.exception.db.QueryInnerErrorException;
import com.ywqf.service.HeatingPrefeTreatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Service
public class HeatingPrefeTreatServiceImpl implements HeatingPrefeTreatService{
    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public HeatingPrefeTreatDao heatingPrefeTreatDao;

    /**
     * 查询采暖优惠政策
     * @return
     */
    @Override
    public HeatingPrefeTreatExcution findHeatingPrefeTreat() {
        /*HttpSession session = getRequest().getSession();
        int corp_id = (int)session.getAttribute("corp_id");*/
        int community_id =1000;
        try{
            List<HeatingPrefeTreat> findListHeatingPrefeTreat = heatingPrefeTreatDao.findListHeatingPrefeTreat(community_id);
            if (findListHeatingPrefeTreat == null){
                throw new QueryInnerErrorException("查询失败");
            }
            return new HeatingPrefeTreatExcution(CompanyInforEnum.FIND_SUCCESS,findListHeatingPrefeTreat);
        }catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 添加优惠采暖政策
     * @param heatingPrefeTreatDto
     * @return
     */
    @Override
    public HeatingPrefeTreatExcution addHeatingPrefeTreat(HeatingPrefeTreatDto heatingPrefeTreatDto) {
        /*HttpSession session = getRequest().getSession();
        int corp_id = (int)session.getAttribute("corp_id");*/
        int community_id =1000;
        String discount_start_date = heatingPrefeTreatDto.getDiscount_start_date();
        String discount_end_date = heatingPrefeTreatDto.getDiscount_end_date();
        Double rate = heatingPrefeTreatDto.getRate();
        try{
            int addHeatingPrefeTreat = heatingPrefeTreatDao.addHeatingPrefeTreat(community_id,discount_start_date,discount_end_date,rate);
            if (addHeatingPrefeTreat > 0){
                return new HeatingPrefeTreatExcution(CompanyInforEnum.ADD_SUCCESS);
            }else {
                return new HeatingPrefeTreatExcution(CompanyInforEnum.ADD_ERROR);
            }
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
