package com.ywqf.service;


import com.ywqf.dto.excution.NewsHallExcution;
import com.ywqf.dto.in.NewsHallDto;

public interface NewsHallService {
    public NewsHallExcution findNewsInfo(NewsHallDto newsHallDto);
}
