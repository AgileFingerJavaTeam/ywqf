package com.ywqf.service;

import com.ywqf.dto.excution.ForgetPasswordExcution;
import com.ywqf.dto.in.ForgetPasswordDto;

public interface ForgetPasswordService {

    public ForgetPasswordExcution applyResetPassword(ForgetPasswordDto forgetPasswordDto);


    public ForgetPasswordExcution checkUserName(ForgetPasswordDto forgetPasswordDto);
}
