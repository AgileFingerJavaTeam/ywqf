package com.ywqf.dao;

import com.ywqf.entity.StaffManagement;

import java.util.List;

/**
 * Created by Administrator on 2017/11/15 0015.
 */
public interface StaffManagementDao {

    List<StaffManagement> findParkingList();
}
