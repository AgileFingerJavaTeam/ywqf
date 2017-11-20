package com.ywqf.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywqf.dao.UserDao;
import com.ywqf.dto.excution.UserExcution;
import com.ywqf.dto.in.UserDto;
import com.ywqf.entity.User;
import com.ywqf.enums.UserEnum;
import com.ywqf.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public int changePassword(UserDto userDto) {
		int id = 333;
		String password = userDto.getPassword();
		String newPassword = userDto.getNewPassword();
		String subPassword = userDto.getSubPassword();
		if (!newPassword.equals(subPassword)) {
			return 0;
		}
//		try {
			User user = userDao.selectOldPassword(id);
			if (user == null) {
				return 1;
			}
			String oldPassword = user.getPassword();
			if (!password.equals(oldPassword) || oldPassword.equals(newPassword)) {
				return 2;
			}
			int num = userDao.changePassword(newPassword, id);
			if (num < 1) { 
				return 3;
			}
//		} catch (Exception e) {
			// TODO: handle exception
//		}
//		return 0;
			return 4;
	}

	@Override
	public int changePhoneNo(UserDto userDto) {
		int id = 333;//登录人ID
		String oldTelephone = userDto.getOldTelephone();
		String newTelephone = userDto.getNewTelephone();
		if (oldTelephone.equals(newTelephone)) {
			return 0;
		}
		int num = userDao.changeOldPhone(newTelephone, id);
		if (num < 1) {
			return 1;
		}
		return 2;
	}

	@Override
	public UserExcution getOldPhone() {
		int userId = 333;//登录人ID 
		List<User> oldPhone = userDao.selectOldPhone(userId);
		HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("phone",oldPhone);
        return  new UserExcution(UserEnum.SUCCESS,map);
	}

}
