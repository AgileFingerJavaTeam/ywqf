package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.CorpAndCommunityEnum;

public class CorpAndCommunityExcution extends BaseAPIExcution{
	
	public CorpAndCommunityExcution(CorpAndCommunityEnum corpAndCommunityEnum,Object data){
		this.code = corpAndCommunityEnum.getCode();
        this.data = data;
	}

}
