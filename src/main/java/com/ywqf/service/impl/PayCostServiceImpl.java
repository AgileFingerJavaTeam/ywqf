package com.ywqf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ywqf.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ywqf.base.BaseException;
import com.ywqf.dao.PayCostDao;
import com.ywqf.dto.excution.PayCostExcution;
import com.ywqf.dto.in.PayCostDto;
import com.ywqf.enums.CompanyInforEnum;
import com.ywqf.service.PayCostService;
@Service
public class PayCostServiceImpl implements PayCostService{
	
	//日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public PayCostDao payCostDao;
    
    /**
     * 查询物业公司
     */
	@Override
	public PayCostExcution findPayCost() {
		/*HttpSession session = this.getRequest().getSession();
		int corp_id = (int) session.getAttribute("corp_id");*/
		int corp_id = 1000 ;
		try{
			PropertyCompany findPropertyCompany = payCostDao.findPropertyCompany(corp_id);//查询所属物业公司
			if (findPropertyCompany == null){
				return new PayCostExcution(CompanyInforEnum.FIND_ERROR);
			}
			return new PayCostExcution(CompanyInforEnum.FIND_SUCCESS, findPropertyCompany);
		}catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
	}

	/**
	 * 查询所属小区
	 */
	@Override
	public PayCostExcution findListCommunity() {
		/*HttpSession session = this.getRequest().getSession();
		int corp_id = (int) session.getAttribute("corp_id");*/
		int corp_id = 1000;
		try{
			List<Community> findListCommunity = payCostDao.findListCommunity(corp_id);//查询所属物业公司
			if (findListCommunity == null){
				return new PayCostExcution(CompanyInforEnum.FIND_ERROR);
			}
			return new PayCostExcution(CompanyInforEnum.FIND_SUCCESS, findListCommunity);
		}catch (Exception  e){
			logger.error(e.getMessage(),e);
			throw new BaseException(e.getMessage());
		}
	}

	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}

	/**
	 * 查询业主信息和条件查询业主缴费信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PayCostExcution findOwnerInfor(PayCostDto payCostDto) {
		int corp_id = payCostDto.getCorpId();
		int community_id = payCostDto.getCommunityId();
		String house_num = payCostDto.getHouseNum();
		int year = payCostDto.getYear();
		try{
			String findHouseNum = payCostDao.findHouseNum(house_num,community_id);
			if (findHouseNum == null){
				return new PayCostExcution(CompanyInforEnum.FIND_ERROR);
			}
			OwnerInfor findOwnerInfor = payCostDao.findOwnerInfor(community_id, house_num);
			List<PaymentInfor> findListPaymentInfor = payCostDao.findListPaymentInfor(corp_id, community_id, house_num, year);
			if (findOwnerInfor == null || findListPaymentInfor == null){
				return new PayCostExcution(CompanyInforEnum.FIND_ERROR);
			}
			Map map = new HashMap<>();
			map.put("findOwnerInfor", findOwnerInfor);
			map.put("findListPaymentInfor", findListPaymentInfor);
            return new PayCostExcution(CompanyInforEnum.FIND_SUCCESS,map);
		}catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
	}
}
