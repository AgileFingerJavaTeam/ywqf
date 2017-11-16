package com.ywqf.service.impl;

import com.ywqf.base.BaseException;
import com.ywqf.dao.LoginDao;
import com.ywqf.dto.excution.LoginExcution;
import com.ywqf.dto.excution.PayCostExcution;
import com.ywqf.dto.in.LoginDto;
import com.ywqf.entity.Login;
import com.ywqf.entity.Session;
import com.ywqf.enums.CompanyInforEnum;
import com.ywqf.enums.LoginEnum;
import com.ywqf.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService{

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public LoginDao loginDao;

    /**
     * 登陆
     * @param loginDto
     * @return
     */
    @Override
    public LoginExcution findSession(LoginDto loginDto) {
        String telephone = loginDto.getTelephone();
        String password = loginDto.getPassword();
        HttpSession session = getRequest().getSession();
        try{
            Login findUsernamePwd = loginDao.findUsernamePwd(telephone,password);
            if (findUsernamePwd == null){
                return new LoginExcution(LoginEnum.ACCOUNT_ERROR);
            }else if (!findUsernamePwd.getPassword().equals(password)){
                return new LoginExcution(LoginEnum.PASSWORD_ERROR);
            }
            int corp_id = findUsernamePwd.getCorpId();
            Session findSession = loginDao.findSession(corp_id);
            if (findSession == null){
                return new LoginExcution(LoginEnum.FIND_ERROR);
            }
            session.setAttribute("rows",findSession);
            return new LoginExcution(LoginEnum.FIND_SUCCESS);
        }catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 得到request对象
	 */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
}
