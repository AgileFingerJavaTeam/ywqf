package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.HouseEnum;


public class HouseExcution extends BaseAPIExcution{
	public HouseExcution(HouseEnum houseenum, Object data) {
        this.code = houseenum.getCode();
        this.data = data;
    }
	public HouseExcution(HouseEnum houseenum) {
        this.code = houseenum.getCode();
      
    }
}
