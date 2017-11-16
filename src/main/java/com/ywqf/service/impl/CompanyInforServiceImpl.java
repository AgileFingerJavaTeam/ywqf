package com.ywqf.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ywqf.base.BaseException;
import com.ywqf.dao.CompanyInforDao;
import com.ywqf.dto.excution.CompanyInforExcution;
import com.ywqf.dto.in.CompanyInforDto;
import com.ywqf.entity.CompanyInfor;
import com.ywqf.enums.CompanyInforEnum;
import com.ywqf.service.CompanyInforService;

@Service
public class CompanyInforServiceImpl implements CompanyInforService{

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CompanyInforDao companyInforDao;
    
    /**
     * 查询公司信息
     */
	@Override
	public CompanyInforExcution findCompanyInfor() {
		//HttpSession session = this.getRequest().getSession();
		//int id = (int) session.getAttribute("id");
		int id = 1;
		try{
			CompanyInfor findCompanyInfor = companyInforDao.findCompanyInfor(id);
			if (findCompanyInfor == null) {
				return new CompanyInforExcution(CompanyInforEnum.FIND_ERROR);
			}
            return new CompanyInforExcution(CompanyInforEnum.FIND_SUCCESS,findCompanyInfor);
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
	 * 修改公司信息
	 */
	@Override
	public CompanyInforExcution editCompanyInfor(CompanyInforDto companyInforDto) {
		//HttpSession session = this.getRequest().getSession();
		//int id = (int) session.getAttribute("id");
		int id = 1;
		String aptitude = companyInforDto.getAptitude();
		String reg_address = companyInforDto.getRegAddress();
		String description = companyInforDto.getDescription();
		String service_tel = companyInforDto.getServiceTel();
		try{
			int editCompanyInfor = companyInforDao.editCompanyInfor(id, aptitude, reg_address, description, service_tel);
			if (editCompanyInfor > 0) {
				return new CompanyInforExcution(CompanyInforEnum.UPDATE_SUCCESS);
			}else {
				return new CompanyInforExcution(CompanyInforEnum.UPDATE_ERROR);
			}
		}catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
	}
}
