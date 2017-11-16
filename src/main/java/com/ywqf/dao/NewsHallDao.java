package com.ywqf.dao;

import com.ywqf.entity.NewsHall;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsHallDao {
    public List<NewsHall> findNewsInfo(@Param("searchNewsInfo") String searchNewsInfo);
}
