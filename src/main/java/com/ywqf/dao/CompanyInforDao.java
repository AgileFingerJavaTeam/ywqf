package com.ywqf.dao;

import org.apache.ibatis.annotations.Param;

import com.ywqf.entity.CompanyInfor;

public interface CompanyInforDao {
	/**
	 * 查询公司信息
	 * @param id
	 * @return
	 */
	public CompanyInfor findCompanyInfor(@Param("corp_id") int corp_id);
	
	/**
	 * 编辑公司信息
	 * @param corp_id
	 * @param aptitude
	 * @param reg_address
	 * @param description
	 * @param service_tel
	 * @return
	 */
	public int editCompanyInfor(@Param("corp_id") int corp_id,
                                @Param("aptitude") String aptitude,
                                @Param("reg_address") String reg_address,
                                @Param("description") String description,
                                @Param("service_tel") String service_tel);

}
