package com.ywqf.dao;

import com.ywqf.entity.PublishWorker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublishDao {
    /**
     * 删除信息
     * @param announcementId
     * @return
     */
    public int isRemove(@Param("announcementId") int announcementId);

    /**
     * 新增信息
     * @return
     */
    public int addNews(@Param("title")String title,@Param("content")String content,@Param("publishWorkerId")int publishWorker);

    /**
     * 查询发布员工列表
     * @param corpId
     * @return
     */
    public List<PublishWorker> findPublishWorker(@Param("corpId") int corpId);
}
