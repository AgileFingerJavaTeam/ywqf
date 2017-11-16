package com.ywqf.dto.in;

public class UserDto {
	private int id;
	private String password;
	private String newPassword;
	private String subPassword;
	private String oldTelephone;
	private String newTelephone;
	
	public String getOldTelephone() {
		return oldTelephone;
	}
	public void setOldTelephone(String oldTelephone) {
		this.oldTelephone = oldTelephone;
	}
	public String getNewTelephone() {
		return newTelephone;
	}
	public void setNewTelephone(String newTelephone) {
		this.newTelephone = newTelephone;
	}
	public String getSubPassword() {
		return subPassword;
	}
	public void setSubPassword(String subPassword) {
		this.subPassword = subPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", password=" + password
				+ ", newPassword=" + newPassword + ", subPassword="
				+ subPassword + ", oldTelephone=" + oldTelephone
				+ ", newTelephone=" + newTelephone + "]";
	}
	
	
	

}
