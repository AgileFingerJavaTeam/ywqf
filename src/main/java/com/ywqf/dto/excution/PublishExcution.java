package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.EstatePayEnum;
import com.ywqf.enums.PublishEnum;

public class PublishExcution extends BaseAPIExcution{
    public PublishExcution(PublishEnum publishEnum, Object data) {
        this.code = publishEnum.getCode();
        this.data = data;
    }
    public PublishExcution(PublishEnum publishEnum) {
        this.code = publishEnum.getCode();
    }
}

