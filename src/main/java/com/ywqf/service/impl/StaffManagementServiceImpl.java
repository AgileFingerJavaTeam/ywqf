package com.ywqf.service.impl;

import com.ywqf.base.BaseException;
import com.ywqf.dao.StaffManagementDao;
import com.ywqf.dto.excution.StaffManagementExcution;
import com.ywqf.dto.in.StaffManagementDto;
import com.ywqf.entity.StaffManagement;
import com.ywqf.enums.StaffManagementEnum;
import com.ywqf.service.StaffManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/11/14 0014.
 */
@Service
public class StaffManagementServiceImpl implements StaffManagementService{
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
}
