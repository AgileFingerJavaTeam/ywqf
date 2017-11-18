package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.HouseEnum;
import com.ywqf.enums.NewsHallEnum;

public class NewsHallExcution extends BaseAPIExcution{
    public NewsHallExcution(NewsHallEnum newsHallEnum, Object data) {
        this.code = newsHallEnum.getCode();
        this.data = data;
    }
    public NewsHallExcution(NewsHallEnum newsHallEnum) {
        this.code = newsHallEnum.getCode();
    }
}
