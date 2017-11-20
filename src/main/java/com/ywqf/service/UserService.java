package com.ywqf.service;


import com.ywqf.dto.excution.UserExcution;
import com.ywqf.dto.in.UserDto;

public interface UserService {
	/**
	 * 修改密码
	 * @param userDto
	 * @return
	 */
	public int changePassword(UserDto userDto);
	
	/**
	 * 修改手机号
	 * @param userDto
	 * @return
	 */
	public int changePhoneNo(UserDto userDto);
	
	/**
	 * 获取旧手机号
	 * @return
	 */
	public UserExcution getOldPhone();
}
