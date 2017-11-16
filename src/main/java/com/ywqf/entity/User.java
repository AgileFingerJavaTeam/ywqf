package com.ywqf.entity;

public class User {
	private int id;
	private String account;
	private String telephone;
	private String password;
	private String avater;
	private int status;
	private String operator;
	private String operate_time;
	private String operate_ip;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAvater() {
		return avater;
	}
	public void setAvater(String avater) {
		this.avater = avater;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperate_time() {
		return operate_time;
	}
	public void setOperate_time(String operate_time) {
		this.operate_time = operate_time;
	}
	public String getOperate_ip() {
		return operate_ip;
	}
	public void setOperate_ip(String operate_ip) {
		this.operate_ip = operate_ip;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", account=" + account + ", telephone="
				+ telephone + ", password=" + password + ", avater=" + avater
				+ ", status=" + status + ", operator=" + operator
				+ ", operate_time=" + operate_time + ", operate_ip="
				+ operate_ip + "]";
	}
}
