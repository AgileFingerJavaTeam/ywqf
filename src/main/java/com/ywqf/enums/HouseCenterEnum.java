package com.ywqf.enums;

public enum HouseCenterEnum {
	FIND_SUCCESS(1000),//查询成功
	FIND_FAIL(-1000),//查询失败
	ADD_SUCCESS(1100),//新增成功
	ADD_FAIL(-1100),//新增失败
	UPDATE_SUCCESS(1200),//修改成功
	UPDATE_FAIL(-1200),//修改失败
	DEL_SUCCESS(1300),//删除成功
	DEL_FAIL(-1300);//删除失败
	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	private HouseCenterEnum(int code) {
		this.code = code;
	}
	
	
}
