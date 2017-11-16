package com.ywqf.service;

import com.ywqf.dto.excution.ResetPasswordExcution;
import com.ywqf.dto.in.ResetPasswordDto;

public interface UserPasswordResetService {
    public ResetPasswordExcution findApplyResetPasswordInfo(ResetPasswordDto resetPasswordDto);

    /**
     * 重置密码
     * @param resetPasswordDto
     * @return
     */
    public ResetPasswordExcution resetPassword(ResetPasswordDto resetPasswordDto);
}
