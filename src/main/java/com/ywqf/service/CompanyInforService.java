package com.ywqf.service;

import com.ywqf.dto.excution.CompanyInforExcution;
import com.ywqf.dto.in.CompanyInforDto;

public interface CompanyInforService {
	/**
	 * 查询公司信息
	 * @return
	 */
	public CompanyInforExcution findCompanyInfor();
	
	/**
	 * 修改公司信息
	 * @return
	 */
	public CompanyInforExcution editCompanyInfor(CompanyInforDto companyInforDto);


}
