package com.ywqf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ywqf.dao.UserDao;
import com.ywqf.dto.in.UserDto;
import com.ywqf.entity.User;
import com.ywqf.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public int changePassword(UserDto userDto) {
		// TODO Auto-generated method stub
		int id = userDto.getId();
		String password = userDto.getPassword();
		String newPassword = userDto.getNewPassword();
		String subPassword = userDto.getSubPassword();
		if (!newPassword.equals(subPassword)) {
			return 0;
		}
//		try {
			User user = userDao.selectOldPassword(id);
			if (user == null) {
				return 0;
			}
			String oldPassword = user.getPassword();
			if (!password.equals(oldPassword) || oldPassword.equals(newPassword)) {
				return 0;
			}
			int num = userDao.changePassword(newPassword, id);
//		} catch (Exception e) {
			// TODO: handle exception
//		}
//		return 0;
			return num;
	}

	@Override
	public int changePhoneNo(UserDto userDto) {
		// TODO Auto-generated method stub
		int id = userDto.getId();
		String oldTelephone = userDto.getOldTelephone();
		String newTelephone = userDto.getNewTelephone();
		if (oldTelephone.equals(newTelephone)) {
			return 0;
		}
		User user = userDao.selectOldPhone(id);
		if (user == null) {
			return 0;
		}
		String phone = user.getTelephone();
		if (!phone.equals(oldTelephone) || phone.equals(newTelephone)) {
			return 0;
		}
		int num = userDao.changeOldPhone(newTelephone, id);
		return num;
	}

}
