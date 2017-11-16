package com.ywqf.service;

import com.ywqf.dto.excution.LoginExcution;
import com.ywqf.dto.in.LoginDto;

public interface LoginService {
    /**
     * 登陆
     * @param loginDto
     * @return
     */
    public LoginExcution findSession(LoginDto loginDto);
}
