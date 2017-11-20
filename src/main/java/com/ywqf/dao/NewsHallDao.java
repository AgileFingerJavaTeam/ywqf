package com.ywqf.dao;

import com.ywqf.entity.NewsHall;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsHallDao {
    /**
     * 查询消息信息
     * @param searchNewsInfo
     * @return
     */
    public List<NewsHall> findNewsInfo(@Param("searchNewsInfo") String searchNewsInfo);

    /**
     * 查询消息条数
     * @param searchNewsInfo
     * @return
     */
    public int findNewsInfoRows(@Param("searchNewsInfo") String searchNewsInfo);
}
