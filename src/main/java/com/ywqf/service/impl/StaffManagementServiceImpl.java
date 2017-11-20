package com.ywqf.service.impl;

import com.ywqf.base.BaseException;
import com.ywqf.dao.StaffManagementDao;
import com.ywqf.dto.excution.StaffManagementExcution;
import com.ywqf.dto.in.StaffManagementDto;
import com.ywqf.entity.StaffManagement;
import com.ywqf.enums.StaffManagementEnum;
import com.ywqf.exception.db.InsertInnerErrorException;
import com.ywqf.service.StaffManagementService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/11/14 0014.
 */
@Service
public class StaffManagementServiceImpl implements StaffManagementService{
    private String realPath = "C:/Users/Administrator/Desktop/keepReal";
    //��־����
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StaffManagementDao staffManagementDao;

    @Override
    public StaffManagementExcution getStaffList(StaffManagementDto staffManagementDto) {
        try {
            List<StaffManagement> info = staffManagementDao.findParkingList();
            HashMap map = new HashMap();
            map.put("rows", info);
            return new StaffManagementExcution(StaffManagementEnum.SUCCESS, map);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    @Override
    public StaffManagementExcution getRoleList() {
        try {
            List<StaffManagement> info = staffManagementDao.findRoleList();

            return new StaffManagementExcution(StaffManagementEnum.SUCCESS, info);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }


    @Override
    public StaffManagementExcution insertStaff(HttpServletRequest request, @Param("name") String name, @Param("telephone") String telephone, @Param("corp_id") Integer corp_id, @Param("status") Integer status, @Param("avater") MultipartFile avater, @Param("operator") String operator,@Param("role_name")Integer role_name){

        String realPath1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/app/file/";
        String path = null;
        String pathShare = null;
        String pathAll = null;
        String pathAllShare = null;
        long time = System.currentTimeMillis();
        if (avater != null) {
            String type = null;
            String fileName = avater.getOriginalFilename();
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()) : null;
            if (type != null) {
                if ("JPG".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase())) {
                    String trueFileName = String.valueOf(System.currentTimeMillis()+fileName);
                    path = realPath + trueFileName;
                    pathAll = realPath1 + trueFileName;
                    try {
                        avater.transferTo(new File(path));
                     int staff = staffManagementDao.insertStaff(name,telephone,corp_id,status,path,operator,role_name);
                     if(staff > 0 ){
                         return new StaffManagementExcution(StaffManagementEnum.SUCCESS,null);
                     }else{
                         throw new InsertInnerErrorException("添加失败");
                     }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        return new StaffManagementExcution(StaffManagementEnum.SUCCESS,null);
    }

}
