package com.ywqf.service.impl;

import com.ywqf.base.BaseException;
import com.ywqf.dao.ResetPasswordDao;
import com.ywqf.dto.excution.ResetPasswordExcution;
import com.ywqf.dto.in.ResetPasswordDto;
import com.ywqf.entity.ResetPassword;
import com.ywqf.enums.ResetPasswordEnum;
import com.ywqf.exception.db.InsertInnerErrorException;
import com.ywqf.service.UserPasswordResetService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPasswordResetServiceImpl implements UserPasswordResetService{
    private org.slf4j.Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ResetPasswordDao resetPasswordDao;
    @Override
    public ResetPasswordExcution findApplyResetPasswordInfo(ResetPasswordDto resetPasswordDto) {
        String searchResetApplyInfo = resetPasswordDto.getSearchResetApplyInfo();
        String checkBoxType = resetPasswordDto.getCheckBoxType();
        try {
            List<ResetPassword> applyResetPasswordList = resetPasswordDao.findApplyResetPasswordInfo(searchResetApplyInfo,checkBoxType);
            return new ResetPasswordExcution(ResetPasswordEnum.FIND_SUCCESS,applyResetPasswordList);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    @Override
    public ResetPasswordExcution resetPassword(ResetPasswordDto resetPasswordDto) {
        String phone = resetPasswordDto.getPhone();
        try {
            int isReset = resetPasswordDao.resetPassword(phone);
            if(isReset == 1){
                int isChangeStatus = resetPasswordDao.changeApplyStatus(phone);
            }else {
                throw new InsertInnerErrorException("重置密码失败");
            }
            return new ResetPasswordExcution(ResetPasswordEnum.RESET_SUCCESS);
        }catch (InsertInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
}
