package com.ywqf.service.impl;

import com.ywqf.base.BaseException;
import com.ywqf.dao.ForgetPasswordDao;
import com.ywqf.dto.excution.ForgetPasswordExcution;
import com.ywqf.dto.in.ForgetPasswordDto;
import com.ywqf.entity.ResetPassword;
import com.ywqf.enums.ForgetPasswordEnum;
import com.ywqf.exception.db.InsertInnerErrorException;
import com.ywqf.exception.db.QueryInnerErrorException;
import com.ywqf.service.ForgetPasswordService;
import lombok.experimental.var;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForgetPasswordServiceImpl implements ForgetPasswordService{
    private org.slf4j.Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ForgetPasswordDao forgetPasswordDao;
    @Override
    /**
     * 申请重置密码
     */
    public ForgetPasswordExcution applyResetPassword(ForgetPasswordDto forgetPasswordDto) {
        String corp_name = forgetPasswordDto.getCorp_name();
        String real_name = forgetPasswordDto.getReal_name();
        String phone = forgetPasswordDto.getPhone();
        try {
            ResetPassword userInfo = forgetPasswordDao.findUserIdByPhone(phone);
            if (userInfo==null){
                throw new QueryInnerErrorException("输入信息有误");
            }
            int userId = userInfo.getId();
            String userName = userInfo.getAccount();
            if (!userName.equals(real_name)){
                throw new InsertInnerErrorException("输入的用户名称有误");
            }
            int corpId = forgetPasswordDao.findCorpId(userId);
            String corpName = forgetPasswordDao.findCorpNameByCorpId(corpId);
            if (!corp_name.equals(corpName)){
                throw new InsertInnerErrorException("输入信息有误");
            }
            int isApply = forgetPasswordDao.applyResetPassword(corp_name,real_name,phone);
            return new ForgetPasswordExcution(ForgetPasswordEnum.APPLY_SUCCSEE);
        }catch (InsertInnerErrorException e1){
            throw e1;
        }catch (QueryInnerErrorException e2){
            throw e2;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    @Override
    public ForgetPasswordExcution checkUserName(ForgetPasswordDto forgetPasswordDto) {
        String real_name = forgetPasswordDto.getReal_name();
        String phone = forgetPasswordDto.getPhone();
        try {
            ResetPassword userInfo = forgetPasswordDao.findUserIdByPhone(phone);
            return new ForgetPasswordExcution(ForgetPasswordEnum.APPLY_SUCCSEE,userInfo);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
}
