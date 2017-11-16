package com.ywqf.dao;


import org.apache.ibatis.annotations.Param;

import com.ywqf.entity.User;

public interface UserDao {
	/**
	 * 查询旧密码
	 * @return
	 */
	public User selectOldPassword(int id);
	
	/**
	 * 修改密码
	 * @return
	 */
	public int changePassword(@Param("newPassword") String newPassword, @Param("id") int id);
	
	/**
	 * 查询旧手机号
	 * @param id
	 * @return
	 */
	public User selectOldPhone(int id);
	
	/**
	 * 修改旧手机号
	 * @return
	 */
	public int changeOldPhone(@Param("newTelephone") String newTelephone, @Param("id") int id);
}
