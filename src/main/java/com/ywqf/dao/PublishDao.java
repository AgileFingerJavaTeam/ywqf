package com.ywqf.dao;

import org.apache.ibatis.annotations.Param;

public interface PublishDao {
    /**
     * 删除信息
     * @param announcementId
     * @return
     */
    public int isRemove (@Param("announcementId")int announcementId);

    /**
     * 新增信息
     * @return
     */
    public int isAdd();
}
