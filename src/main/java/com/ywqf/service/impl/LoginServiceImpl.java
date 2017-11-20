package com.ywqf.service.impl;

import com.ywqf.base.BaseException;
import com.ywqf.dao.LoginDao;
import com.ywqf.dto.excution.LoginExcution;
import com.ywqf.dto.in.LoginDto;
import com.ywqf.entity.*;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            int corp_id = findUsernamePwd.getCorpId();//获取物业公司id
            int user_id = findUsernamePwd.getUserId();//获取登录用户id
            Session findSession = loginDao.findSession(corp_id);//查询物业公司信息
            List<RoleId> findId = loginDao.findId(user_id);//查询角色id
            Map map = new HashMap();
            for (int i = 0 ; i < findId.size() ; i++){
                int role_id = findId.get(i).getRoleId();
                List<AclId> findAclId = loginDao.findAclId(role_id);//查询权限id
                for (int j = 0 ; j < findAclId.size() ; j++){
                    int acl_id = (int)findAclId.get(j).getAcl_id();
                    List<Module> findAcl = loginDao.findAcl(acl_id);//获取登陆权限菜单
                    map.put("findAcl",findAcl);
                }
            }
            if (findSession == null && map == null){
                return new LoginExcution(LoginEnum.FIND_ERROR);
            }
            session.setAttribute("findSession",findSession);
            return new LoginExcution(LoginEnum.FIND_SUCCESS,map);
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
