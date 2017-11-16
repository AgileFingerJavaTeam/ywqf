package com.ywqf.enums;

public enum HouseEnum{
	FIND_SUCCESS(1000),//��ѯ�ɹ�
	FIND_FAIL(-1000),//��ѯʧ��
	ADD_SUCCESS(1100),//�����ɹ�
	ADD_FAIL(-1100),//����ʧ��
	UPDATE_SUCCESS(1200),
	UPDATE_FAIL(-1200),
	DEL_SUCCESS(1300),
	DEL_FAIL(-1300);
	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	private HouseEnum(int code) {
		this.code = code;
	}
	
	
}
